function manageService($http, $interpolate,$cookies, $q) {
    var product = $interpolate('/api/product/{{id}}');
    var order1 = $interpolate('/api/orders/{{id}}');
    var category = $interpolate('/api/product/category');
    return {
        list: list,
        filter: filter,
        create: create,
        order: order,
        getorders: getorders,
        destroy: destroy,
        update: update,
        onaccepting: onaccepting,
        listCategories: listCategories
    };

    function getCategories() {
        var cat={xx};
        return $http.get(product() + '?type=' + cat);

    }



    function list() {
        return $http.get(product());
    }

    function listCategories() {
        return $http.get(category());
    }

    function getorders() {
        return $http.get(order1());
    }

    function filter(filter) {
        return $http.get(product() + '?type=' + filter)
    }

    function create(name, category, specifications, quantity) {
        var data = {
            name: name,
            category: category,
            specifications: specifications,
            quantity: quantity

        };

        return $http.post(product(), data);
    }

   function order(orderedproduct, status) {

       var userid= $cookies.get('userid');
       var username= $cookies.get('username');


        console.log(userid);
        var data = {
            productid:orderedproduct.id,
            name: orderedproduct.name,
            category: orderedproduct.category,
            specifications: orderedproduct.specifications,
            userid: parseInt(userid),
            username: username,
            status: status

        };

        return $http.post(order1(), data);
    }

    function onaccepting(id) {

        return $http.delete(product({ id: id }));

    }


    function destroy(id) {
        return $http.delete(product({ id: id }));
    }

    function update(id, name, category, specifications, quantity) {
        var data = {
            name: name,
            category: category,
            specifications: specifications,
            quantity:quantity
        };

        return $http.put(product({ id: id }), data);
    }

}
