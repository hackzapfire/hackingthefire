angular.module('despachoApp').controller('listOcorrenciasCtrl', function ($scope, ocorrencias, addressAPI,$location, $timeout, recursosAPI) {
    if(ocorrencias)
        $scope.ocorrencias = ocorrencias.data;

    $scope.selecionaOcorrencia = function (ocorrencia) {
        if(ocorrencia) {
            var query = ocorrencia.endereco;
            if (ocorrencia.numero){
                query += ","+ ocorrencia.numero;
                if(ocorrencia.bairro){
                    query +=","+ ocorrencia.bairro;
                    if(ocorrencia.cidade){
                        query += ","+ ocorrencia.cidade;
                    }
                }

            }


            addressAPI.getLocation(query).then(function (resp) {
                var maps = resp.data;
                console.log(maps);
                if(maps){
                    if(maps.results) {
                        if (maps.results.length > 0) {
                            if (maps.results[0].geometry) {
                                console.log('okay');
                                var loc = maps.results[0].geometry.location;
                                ocorrencia.latitude = loc.lat;
                                ocorrencia.longitude = loc.lng;
                                localStorage.setItem('newOcorrencia', JSON.stringify(ocorrencia));
                                $location.path('/recursos');
                            }
                        }
                    }
                }
                $scope.alerta = true;
                $timeout(function () {
                    $scope.alerta = false;
                },5*1000);
            });
        }
    }
});