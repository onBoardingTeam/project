<div class="container">

    <navigation class="row"></navigation>

    <div class="row">
        <h2 class="text-center">Order History</h2>
        <div class="col-xs-12">
            <table class="table">
                <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Specifications</th>
                    <th>Product Category</th>
                    <th>Order status</th>
                </tr>
                </thead>

                <tbody>
                <tr ng-repeat="order in vm.orders" ng-if="order.userid==vm.u_id">
                    <td>{{order.productid}}</td>
                    <td>{{order.name}}</td>
                    <td>{{order.specifications}}</td>
                    <td>{{order.category}}</td>
                    <td ng-if="order.status==1">{{"Order accepted"}}</td>
                    <td ng-if="order.status==2">{{"Order rejected"}}</td>
                    <td ng-if="order.status==0">{{"Order pending"}}</td>
                </tr>
                </tbody>

            </table>
        </div>
    </div>
</div>
