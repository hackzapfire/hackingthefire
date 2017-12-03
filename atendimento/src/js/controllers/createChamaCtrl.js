angular.module('zapFireChamada').controller('createChamadaCtrl', function ($scope, chamadaService, $timeout) {
    $scope.chamada = {cidade:'Uberlandia'};

    $scope.dados = false;

    $scope.solicitacao = function (chamada) {
        chamada.time = new Date().getTime();
        chamadaService.createOcorrencia(chamada).then(function (response) {
            console.log('resposta', response);
            $scope.chamada = {};
            $scope.alerta = true;
            $timeout(function () {
               $scope.alerta = false;
            },5*1000);
        },function (error) {
            console.log('erro', error);
        });


    }
});