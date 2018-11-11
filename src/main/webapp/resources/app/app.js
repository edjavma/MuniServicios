var app = angular.module("modelApp",['ngRoute', 'ui.bootstrap','mgcrea.ngStrap.datepicker','angularMoment','ngTable','fxpicklist']);

app.config(function ($routeProvider,  $datepickerProvider) {
    $routeProvider        
        .when('/', {
            templateUrl: 'resources/app/views/modelo.jsp'
           // controller: 'modeloController'
        })
        .when('/usuario', {
            templateUrl: 'resources/app/views/usuario.jsp',
            controller: 'usuarioController'
        })
        .otherwise({redirectTo:'/'});
    
    angular.extend($datepickerProvider.defaults, {
        dateFormat: 'dd/MM/yyyy',
        startWeek: 1,
      //  startView: 1,  
        hasToday: true,
       // startDate: 'today',
     //   daysOfWeekDisabled: '0,6'
    });
});
