function appConfig($routeProvider, $httpProvider) {
    $routeProvider
        .when('/manage', {template: '<products></products>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/processedorders', {template: '<processedorders></processedorders>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/viewproducts', {template: '<info></info>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/orderhistory', {template: '<orderhistory></orderhistory>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/', {template: '<home></home>'})
        .when('/login', {template: '<login></login>'})
        .otherwise({
            redirectTo: '/'
        });
    $httpProvider.interceptors.push('loginInterceptor');
}

var onlyLoggedIn = function ($location,$q,$cookies) {
    var deferred = $q.defer();
    var authdata = $cookies.get('authdata') || null;

    if (authdata!= null)
    {
        deferred.resolve();
    }
    else
    {
        deferred.reject();
        $location.url('/login');
    }
    return deferred.promise;
}