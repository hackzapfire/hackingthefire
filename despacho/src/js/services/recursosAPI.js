angular.module('despachoApp').service('recursosAPI', function ($http) {
    var _url = "http://localhost:8080";
    this.listRecursos = function () {
        return $http.get(_url+'/recursos');
    };


});