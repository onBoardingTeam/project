function productService($http, $interpolate) {
    var product = $interpolate('/api/product/{{id}}');

    return {
        list: list,
        filter: filter,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(product());
    }

    function filter(filter) {
        return $http.get(product() + '?type=' + filter)
    }

    function create(name, category, specifications) {
        var data = {
            name: name,
            category: category,
            specifications: specifications

        };

        return $http.post(product(), data);
    }

    function destroy(id) {
        return $http.delete(product({ id: id }));
    }

    function update(id, name, category, specifications) {
        var data = {
            name: name,
            category: category,
            specifications: specifications
        };

        return $http.put(product({ id: id }), data);
    }
}
