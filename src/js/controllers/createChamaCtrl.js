angular.module('zapFireChamada').controller('createChamadaCtrl', function ($scope, chamadaService) {
    $scope.chamada = {};

    $scope.solicitacao = function (chamada) {
        chamada.time = new Date().getTime();
        chamadaService.createOcorrencia(chamada).then(function (response) {
            console.log('resposta', response);
            $scope.chamada = {};
        },function (error) {
            console.log('erro', error);
        });


    }
});