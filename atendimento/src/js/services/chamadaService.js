angular.module('zapFireChamada').service('chamadaService', function ($http) {
    var _url = "http://localhost:8080";
    this.listOcorrencias = function () {
        return $http.get(_url+'/ocorrencias');
    }
    this.createOcorrencia = function (ocorrencia) {
        return $http.post(_url+'/ocorrencia', ocorrencia);
    }
});