angular.module('despachoApp').config(function ($routeProvider) {
    $routeProvider.when('/', {
        controller: 'listOcorrenciasCtrl',
       resolve: {
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.listOcorrencias();
            }
       },
       templateUrl: 'templates/list-ocorrencias.html'
    }).when('/recursos',{controller: 'recursosCtrl',
        resolve:{
            recursos: function (recursosAPI) {
                return recursosAPI.listRecursos();
            },
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.listOcorrencias();
            }
        },
        templateUrl: 'templates/recursos.html'
    })
});