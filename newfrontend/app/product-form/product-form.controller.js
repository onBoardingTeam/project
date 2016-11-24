function ProductFormController(manageService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = vm.onSubmit || onUserDidSubmit;
    vm.onReset  = vm.onReset || onUserDidReset;
    vm.listCategory= listCategory;
    vm.selectedCategory= selectedCategory;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.name = parentControllerHasSetData ? vm.data.name : '';
        vm.category  = parentControllerHasSetData ? vm.data.category  : '';
        vm.specifications  = parentControllerHasSetData ? vm.data.specifications  : '';
        vm.quantity = parentControllerHasSetData ? vm.data.quantity  : '';
        vm.listCategory();
    }

    function onUserDidSubmit(name, category, specifications,quantity) {
        return manageService.create(name, category, specifications,quantity)
            .then(vm.productsController.refreshProducts)
            .then(onUserDidReset)
            .then(vm.listCategory)
            .catch(vm.showError);
    }

    function listCategory(){
        return manageService.listCategories().then(function listCat(response){vm.Cat = response.data;});
        console.log(vm.product);
    }

    function selectedCategory(selectedCat) {
                document.getElementById('category').value = selectedCat;
                 vm.category= selectedCat;
    }



    function onUserDidReset() {
        vm.name = '';
        vm.category = '';
        vm.specifications = '';
        vm.quantity = '';
        vm.productForm.$setPristine();
        vm.productForm.$setUntouched();
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
