angular.module('zapFireChamada').config(function ($routeProvider) {
    $routeProvider.when('/',{
       controller: 'createChamadaCtrl',
       templateUrl: 'templates/nova-chamada.html'
    })
        .when('/ocorrencias',{
            controller: 'listOcorrenciasCtrl',
            resolve: {
                ocorrencias: function (chamadaService) {
                    return chamadaService.listOcorrencias();
                }
            },
            templateUrl: 'templates/listar-ocorrencias.html'
        });
})