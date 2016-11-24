<div class="container">
    <navigation class="row"></navigation>

    <div class="row">
        <div class="col-xs-12">
            <table class="table">
                <thead>
                <tr>

                    <th>Name</th>
                    <th>Specifications</th>
                    <th>Category</th>
                    <th>States</th>

                </tr>
                </thead>

                <tbody>
                <tr ng-repeat="product in vm.products"><!--is the orders in vm.products?-->
                    <td>{{product.name}}</td>
                    <td>{{product.specifications}}</td>
                    <td>{{product.category}}</td>
                    <td>{{product.states}}</td> <!-- where is the states?-->
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>