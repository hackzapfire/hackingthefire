angular.module('despachoApp').service('checkAPI', function ($http) {
    var _url = "http://localhost:8080";
    this.signRecurso = function (check) {
        return $http.post(_url+'/checks', check);
    }

});