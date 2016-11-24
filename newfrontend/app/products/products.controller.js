function ProductsController(manageService, orderService) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshProducts = refreshProducts;
    vm.refreshOrders = refreshOrders;
    vm.hasProducts = hasProducts;
    vm.acceptOrder = acceptOrder;
    vm.rejectOrder = rejectOrder;
    vm.orderstatus = orderstatus;


    function $onInit() {
        vm.orders= [];
        vm.products = [];
        vm.refreshProducts();
        vm.refreshOrders();
    }

    function  orderstatus() {
        return vm.orders.status >0;

    }

    function refreshProducts() {

        return manageService.list().then(function refreshedProducts(response) {
            vm.products = response.data;
        });
    }

    function refreshOrders() {
        return orderService.list().then(function refreshedProducts(response) {
            vm.orders = response.data;
        });
    }

    function acceptOrder(orderid,productid) {
        var status=1;
        //console.log('acceptingOrder' + id);
        return orderService.updateOrder(orderid, productid, status).then(vm.refreshOrders)

    }

    function rejectOrder(orderid,productid) {
        var status=2;
       // console.log('rejectingOrder' + id);

        return orderService.updateOrder(orderid, productid, status).then(vm.refreshOrders)

    }

    function onaccept(id) {



        // return productService.onaccepting(id).then (vm.refreshProducts);

    }

    function hasProducts() {
        return vm.products.length > 0;
    }


}
