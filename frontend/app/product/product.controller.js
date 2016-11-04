function ProductController(productService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.editProduct = editProduct;
    vm.removeProduct = removeProduct;
    vm.submitEditedProduct = submitEditedProduct;
    vm.resetEditedProduct = resetEditedProduct;
    vm.showError = showError;

    function $onInit() {
        // vm.notesController will be our parent controller (NotesController)
        // vm.data will contain the data of this note
        vm.resetEditedProduct();
    }

    function editProduct() {
        vm.isEditingProduct = true;
    }

    function removeProduct() {
        productService.destroy(vm.data.id)
            .then(vm.productsController.refreshProducts);
    }

    function submitEditedProduct(name, category, specifications) {
        return productService.update(vm.data.id, name, category, specifications)
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
