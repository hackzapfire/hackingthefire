angular.module('despachoApp').controller('recursosCtrl', function ($scope, recursos, recursosAPI, $timeout, ocorrenciasAPI, checkAPI, ocorrencias, addressAPI) {

    var lat = -18.911;
    var lng = -48.264;

    $scope.maps = new GMaps({
        el: '#map',
        lat: lat,
        lng: lng
    });
    console.log($scope.maps);
    if(recursos){
        $scope.recursos = recursos.data;
        console.log($scope.recursos);
    }
    if(ocorrencias){
        $scope.a = ocorrencias.data;
        $scope.ocors = [];
        $scope.a.forEach(function (o) {
           addressAPI.getLocation(o.endereco).then(function (res) {
               var lets = res.data;
               console.log(lets);
               if(lets){
                   if(lets.results) {
                       if (lets.results.length > 0) {
                           if (lets.results[0].geometry) {
                               console.log('okay');
                               var loc = lets.results[0].geometry.location;
                               o.latitude = loc.lat;
                               o.longitude = loc.lng;
                               $scope.ocors.push(o);
                               $scope.maps.addMarker({
                                   lat: loc.lar,
                                   lng: loc.lng,
                                   title: 'Lima',
                                   icon: '/img/8597baf7-2ee6-40d5-9405-2c1dc9ae7b4f.jpg'
                               });
                           }
                       }
                   }
               }
           });
        });
    }


    $scope.ocorrencia = localStorage.getItem('newOcorrencia');

    if($scope.ocorrencia){
        $scope.ocorrencia = JSON.parse($scope.ocorrencia);
        //localStorage.removeItem('newOcorrencia');
        lat = $scope.ocorrencia.latitude;
        lng = $scope.ocorrencia.longitude;

        $scope.maps.setCenter(lat, lng);
        $scope.maps.addMarker({
           lat: lat,
           lng: lng,
            id: $scope.ocorrencia.userId,
           title: $scope.ocorrencia.endereco,
            icon: '/img/8597baf7-2ee6-40d5-9405-2c1dc9ae7b4f.jpg'
        });

    }


    $scope.recursos.forEach(function (rec) {
        $scope.maps.addMarker({
            lat: parseFloat(rec.latitude),
            lng: parseFloat(rec.longitude),
            title: 'Lima',
            icon: '/img/93c042a5-952c-44db-9d75-f5aed50e86c9.jpg',
            userId: rec.userId,
            click: function(e) {
                $scope.funcaoRecurso(rec);
            }
        });
    });
    $timeout(function () {
        recursosAPI.listRecursos().then(function (resp) {
            var newObs = resp.data;
            newObs.forEach(function (o) {
                var is = false;
                var i = 0;
                $scope.maps.markers = $scope.maps.markers.map(function (mk) {
                    if(mk.userId==o.userId){
                        mk.lat = parseFloat(o.latitude);
                        mk.lng = parseFloat(o.longitude);
                        is = true;
                    }
                    return mk;
                });
                if(!is){
                    $scope.maps.addMarker({
                        lat: parseFloat(o.latitude),
                        lng: parseFloat(o.longitude),
                        title: 'Lima',
                        icon: '/img/93c042a5-952c-44db-9d75-f5aed50e86c9.jpg',
                        userId: rec.userId,
                        click: function(e) {
                            $scope.funcaoRecurso(o);
                        }
                    });
                }
            })


        })
    }, 15*1000);

    $scope.funcaoRecurso = function (recurso) {
        if($scope.ocorrencia){
            enviar(recurso, $scope.ocorrencia);
        }else{
            ocorrenciasAPI.listOcorrencias().then(function (resp) {
                $scope.selectRecurso = recurso;
                console.log('recebido', resp.data);
                $scope.ocorrencias = resp.data;
                $('#checksModal').modal('show');
            },function (error) {
                $scope.alert = true;
                $timeout(function () {
                    $scope.alert = false;
                }, 5*1000);
                console.log('erro', error);
            });
        }
    }
    $scope.selecionaParaRecurso = function (ocorrencia) {
        enviar($scope.selectRecurso, ocorrencia);
    };

    var enviar = function (recurso, ocorrencia) {
        if(confirm('Deseja encaminhar esse recurso para essa ocorrenica?')){
            var check = {};
            check.recurso = recurso;
            check.ocorrencia = ocorrencia;
            console.log('enviando ', check);
            checkAPI.signRecurso(check).then(function () {
                console.log('ok');
                if($scope.ocorrencia) {
                    $scope.ocorrencia = null;
                    localStorage.removeItem('newOcorrencia');

                }
                if($scope.selectRecurso){
                    $scope.selectRecurso = null;
                }
                $('#checksModal').modal('hide');
                ocorrencia = null;
            });
        }
    }

    $scope.zoomMap = function (elem) {
        $scope.maps.markers.forEach(function (mar) {
            console.log(elem.longitude, mar.lng);
            if(elem.latitude==mar.lat && elem.longitude==mar.lng){
                $scope.maps.setCenter(elem.latitude, elem.longitude);
            }
        });
    };

    $scope.removerOcorrencia = function () {
        localStorage.removeItem('newOcorrencia');
        $scope.ocorrencia = null;
    }
});