function ProductsController(productService, $log) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshProducts = refreshProducts;
    vm.hasProducts = hasProducts;

    function $onInit() {
        vm.products = [];
        vm.refreshProducts();
    }

    function refreshProducts() {
        return productService.list().then(function refreshedProducts(response) {
            vm.products = response.data;
        });
    }

    function hasProducts() {
        return vm.products.length > 0;
    }
}
