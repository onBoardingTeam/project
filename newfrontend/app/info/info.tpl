<div class="container">
    <navigation class="row"></navigation>

    <div class="row">
        <div class="col-xs-3">
            <select class="form-control" id="mySelect" ng-change="vm.addFilter(selectedCat)" ng-model="selectedCat">
                <option value="" selected>Category</option>
                <option ng-repeat="xx in vm.Cat" value="{{xx.category}}">
                    {{xx.category}}
                </option>
            </select>
            <!--<a ng-click="vm.addFilter('Mobile')" class="btn btn-default">Mobile</a>-->
            <!--<a ng-click="vm.addFilter('Laptop')" class="btn btn-default">Laptop</a>-->
            <!--<a ng-click="vm.addFilter('')"  class="btn btn-default">all products</a>-->
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Specifications</th>
                        <th>Category</th>
                    </tr>
                </thead>

                <tbody>
                    <tr ng-repeat="product in vm.products">
                        <td>{{product.name}}</td>
                        <td>{{product.specifications}}</td>
                        <td>{{product.category}}</td>
                        <td> <button style="background-color:black" type="submit" ng-click="vm.onSubmit(product)" class="btn btn-xs btn-success">Add to cart</button> </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>