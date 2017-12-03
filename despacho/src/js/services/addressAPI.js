angular.module('despachoApp').service('addressAPI', function ($http) {
    this.getLocation = function (address) {
        if(address.toLowerCase().startsWith('rua')){
            address = address.toLowerCase().substring(4,address.length);
        }
        return $http.get('http://maps.googleapis.com/maps/api/geocode/json?address='+encodeURIComponent(address));
    };

})