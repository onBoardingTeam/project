<div class="container">
    <navigation class="row"></navigation>

    <div class="row">
        <product-form class="col-xs-12"></product-form>

        <div class="col-xs-12 text-center" ng-if="!vm.hasProducts()">
            <div class="alert alert-info" role="alert">
                <h4>There are no products yet!</h4>

            </div>
        </div>
    </div>

    <div class="row">
        <product class="col-xs-6" ng-repeat="product in vm.products" data="product"></product>
    </div>

</div>