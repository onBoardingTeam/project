function ProductController(manageService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.editProduct = editProduct;
    vm.removeProduct = removeProduct;
    vm.submitEditedProduct = submitEditedProduct;
    vm.resetEditedProduct = resetEditedProduct;
    vm.showError = showError;
    vm.getCategories= getCategories;

    function $onInit() {
        // vm.notesController will be our parent controller (NotesController)
        // vm.data will contain the data of this note
        vm.resetEditedProduct();
        vm.getCategories;
    }

    function getCategories() {

        return manageService.getCategories.then(function gotCategories(response){ vm.categories= response.data;});

    }



    function editProduct() {
        vm.isEditingProduct = true;
    }

    function removeProduct() {
        manageService.destroy(vm.data.id)
            .then(vm.productsController.refreshProducts);
    }

    function submitEditedProduct(name, category, specifications, quantity) {
        return manageService.update(vm.data.id, name, category, specifications, quantity)
            .then(vm.productsController.refreshProducts)
            .then(vm.resetEditedProduct)
            .catch(vm.showError);
    }

    function resetEditedProduct() {
        vm.isEditingProduct = false;
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
