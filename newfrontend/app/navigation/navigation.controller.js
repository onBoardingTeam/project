function NavigationController($cookies, loginService, $location) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.hasCookies = hasCookies;
    vm.onlogout = logout;

    function $onInit() {
        vm.products = [];
        vm.role=[];
    }

    function hasCookies() {
        var authdata = $cookies.get('authdata') || null;
         vm.role = $cookies.get('role');
        //console.log(role);

        if (authdata!= null){
            vm.products= [1];
        }
        return vm.products.length > 0;
    }

    function logout() {
        loginService.ClearCredentials();

        $location.path('/home');
    }
}