function LoginController (loginService, $location) {
    var vm = this;
    vm.$onInit = $onInit;
    vm.onSubmit = onUserDidSubmit;
    vm.onReset = onUserDidReset;
    vm.showError = showError;
    vm.showSuccess = showSuccess;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.username = parentControllerHasSetData ? vm.data.username : '';
        vm.password = parentControllerHasSetData ? vm.data.password : '';
    }

    function onUserDidSubmit(username, password) {

        var test= function (response) {
            if (response.status == 200) {
                loginService.SetCredentials(username, password, response.data.id, response.data.role);
                $location.path('/home');
            } else {
                vm.showError();
                vm.onReset();
            }
        }

            return loginService.verify(username, password)
                .then(test)
                .catch(test);
    }

    function onUserDidReset(){
        vm.username='';
        vm.password='';
        //vm.$setPristine();
        //vm.$setUntouched();
    }

    function showSuccess() {
        alert("Success");
    }

    function showError() {
        alert("fail");
    }
}