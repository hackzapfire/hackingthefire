angular.module('despachoApp').service('ocorrenciasAPI', function ($http) {
    var _url = 'http://localhost:8080';

    this.listOcorrencias = function () {
        return $http.get(_url+"/ocorrencias");
    }

});