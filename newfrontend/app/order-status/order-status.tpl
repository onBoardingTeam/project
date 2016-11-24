<div class="container">

    <navigation class="row"></navigation>

    <div class="row">
        <h2 class="text-center">Orders Placed</h2>
        <div class="col-xs-12">
            <table class="table">
                <thead>
                <tr>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Specifications</th>
                    <th>Product Category</th>
                </tr>
                </thead>

                <tbody>
                <tr ng-repeat="order in vm.orders"  >
                    <td>{{order.userid}}</td>
                    <td>{{order.username}}</td>
                    <td>{{order.productid}}</td>
                    <td>{{order.name}}</td>
                    <td>{{order.specifications}}</td>
                    <td>{{order.category}}</td>
                </tr>
                </tbody>

            </table>
        </div>
    </div>
</div>
