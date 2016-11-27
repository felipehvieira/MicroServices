(function(){
  angular.module('carroapp',['ui.router'])
    .config(['$stateProvider','$urlRouterProvider',
      function($stateProvider,$urlRouterProvider){
        var fabricasState = {
          name: 'fabricas',
          url: '/fabricas',
          templateUrl: 'app/fabrica/fabrica-list.html',
          controller: 'FabricaController'
        }
        var carrosState = {
          name: 'carros',
          url:  '/carros/:id',
          templateUrl: 'app/carro/carro-list.html',
          controller: 'CarroController'
        }
        var fabricasSaveState={
            name: 'fabricas/save',
            url: 'fabricas/save',
            templateUrl: 'app/fabrica/fabrica-cadastro.html',
            controller: 'FabricaController'
        }

        var carrosSaveState={
          name: 'carros/save',
          url: 'save/car',
          templateUrl: 'app/carro/carro-cadastro.html',
          controller: 'CarroController'
        }

        $urlRouterProvider.otherwise('/')
        $stateProvider.state(fabricasState)
        $stateProvider.state(carrosState)
        $stateProvider.state(fabricasSaveState)
        $stateProvider.state(carrosSaveState)
      }
    ])
})()
