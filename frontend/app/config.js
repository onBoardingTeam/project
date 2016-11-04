function appConfig($routeProvider) {
    $routeProvider
        .when('/', { template: '<products></products>' })
        .when('/info', { template: '<info></info>' })
        .otherwise({
            redirectTo: '/'
        })
}