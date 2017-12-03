angular.module('zapFireChamada').controller('listOcorrenciasCtrl', function($scope, ocorrencias){
    if(ocorrencias)
        $scope.ocorrencias = ocorrencias.data;


    $scope.showOcorrencia = function (ocorrencia) {
        $scope.ocorrencia = ocorrencia;
        $('#chamadaModal').modal('show');
    }
});