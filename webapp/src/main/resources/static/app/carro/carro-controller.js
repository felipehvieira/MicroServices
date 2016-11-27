(function(){

  angular.module('carroapp')
    .controller('CarroController',['$scope','$http','$stateParams','carroService',
      function($scope,$http,$stateParams,carroService){

        $scope.carros = []
        //funções
        $scope.load = function(){
          $http.get('http://localhost:8086/carroFabrica/' + $stateParams.id)
            .then(function(result){
              $scope.carros = result.data
            }, function(err){
                console.error(err)
            })
        }
        $scope.save = function(){
          carroService.addCarro($scope.carro)
        }
    }
  ]).factory('carroService',['$http', function($http){
    var fac = {}

    fac.addCarro = function(carro){
      var data ={
        'modelo': carro.modelo,
        'cilindradas': carro.cilindradas,
        'cor': carro.cor,
        'fabrica': carro.fabrica
      }
      $http({
        method: 'POST',
        url: 'http://localhost:8085/carro',
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
