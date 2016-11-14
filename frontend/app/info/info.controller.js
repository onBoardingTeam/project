function InfoController(productService, $log) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshProducts = refreshProducts;
    vm.hasProducts = hasProducts;
    vm.addFilter = addFilter;
    vm.hasFilter = hasFilter;

    function hasFilter() {
        return vm.filter.length > 0;
    }

    function $onInit() {
        vm.products = [];
        vm.filter = "";
        vm.refreshProducts();
    }

    function addFilter(filter) {
        vm.filter = filter;
        $log.debug(vm);
        vm.refreshProducts();
    }

    function refreshProducts() {
        var promise = productService.list();

        if (vm.hasFilter()) {
            promise = productService.filter(vm.filter);
        }

        return promise .then(function refreshedProducts(response) {
            vm.products = response.data;
            $log.debug(vm);
        });
    }

    function hasProducts() {
        return vm.products.length > 0;
    }
}
