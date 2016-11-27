(function(){

  angular.module('carroapp')
    .controller('FabricaController',['$scope','$http','fabricaService',
      function($scope, $http, fabricaService){

        $scope.fabricas = []
        $scope.load = load

        $scope.load();
        //functions
        function load(){
          $http.get('http://localhost:8086/fabricas')
            .then(function(result){
              $scope.fabricas = result.data
            }, function(err){
              console.error(err);
            })
        }
        $scope.save = function(){
          fabricaService.addFabrica($scope.fabrica)
        }
      }
    ])
      .factory("fabricaService",['$http', function($http){
        var fac = {}

        fac.addFabrica = function(fabrica){
          var data ={
            'id': fabrica.id,
            'nome': fabrica.nome
          }
          $http({
            method: 'POST',
            url: 'http://localhost:8086/fabricas',
            headers: {
              'Content-Type': 'application/json'
            },
            data
          }).then(function(response){
            alert(response.status)
          })
        }
        return fac
      }
    ])

})()
