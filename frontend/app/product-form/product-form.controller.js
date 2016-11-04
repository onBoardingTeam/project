function ProductFormController(productService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = vm.onSubmit || onUserDidSubmit;
    vm.onReset  = vm.onReset || onUserDidReset;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.name = parentControllerHasSetData ? vm.data.name : '';
        vm.category  = parentControllerHasSetData ? vm.data.category  : '';
        vm.specifications  = parentControllerHasSetData ? vm.data.specifications  : '';
    }

    function onUserDidSubmit(name, category, specifications) {
        return productService.create(name, category, specifications)
            .then(vm.productsController.refreshProducts)
            .then(onUserDidReset)
            .catch(vm.showError);
    }

    function onUserDidReset() {
        vm.name = '';
        vm.category = '';
        vm.specifications = '';
        vm.productForm.$setPristine();
        vm.productForm.$setUntouched();
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
