<div ng-switch on="vm.isEditingProduct">
    <div class="panel panel-default" ng-switch-when="false">
        <div class="panel-heading">
            <h class="panel-title pull-left">{{vm.data.category}}</h>
            <div class="pull-right">
                <a ng-click="vm.editProduct()" class="btn btn-xs btn-info">Edit</a>
                <a ng-click="vm.removeProduct()" class="btn btn-xs btn-danger">Remove</a>
            </div>

            <div class="clearfix"></div>
        </div>
        <div class="panel-body">{{vm.data.name}}</div>
        <div class="panel-body">{{vm.data.specifications}}</div>
    </div>

    <product-form ng-switch-when="true" data="vm.data" on-submit="vm.submitEditedProduct" on-reset="vm.resetEditedProduct"></product-form>
</div>