angular.module('zapFireChamada').service('chamadaService', function ($http) {
    var _url = "http://12088aa2.ngrok.io/api";
    this.listOcorrencias = function () {
        return $http.get(_url+'/ocorrencias');
    }
    this.createOcorrencia = function (ocorrencia) {
        return $http({
            method: 'post',
            headers: {
                'Content-Type':'application/x-www-form-urlencoded'
            },
            data: JSON.stringify(ocorrencia),
            url: _url+'/ocorrencia'
        })
        //return $http.post(_url+'/ocorrencia', ocorrencia,{headers:'application/x-www-form-urlencoded'});
    }
   /*this.createOcorrencia = function (ocorrencia) {
       var ocorrencias = localStorage.getItem('ocorrencias');
       if(ocorrencias){
           ocorrencias = JSON.parse(ocorrencias);
           ocorrencias.push(ocorrencia);
       }else{
           ocorrencias = [ocorrencia];
       }
       localStorage.setItem('ocorrencias', JSON.stringify(ocorrencias))
   };
   this.listOcorrencias = function(){
       var ocorrencias = localStorage.getItem('ocorrencias');
       if(ocorrencias){
           ocorrencias = JSON.parse(ocorrencias);
           return ocorrencias;
       }else return [];
   }*/
});