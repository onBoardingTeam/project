function processedOrdersController(orderService) {

    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshOrders= refreshOrders;

    function $onInit() {
        vm.refreshOrders();
    }



    function refreshOrders() {
        return orderService.list().then(function refreshedProducts(response) {
            vm.orders = response.data;
        });
    }

}
