function orderHistoryController(orderService, $cookies) {

    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshOrders= refreshOrders;

    function $onInit() {
        vm.refreshOrders();
        vm.u_id = [];
    }



    function refreshOrders() {
        return orderService.list().then(function refreshedProducts(response) {
            vm.orders = response.data;
            vm.u_id= $cookies.get('userid');
        });

    }

}
