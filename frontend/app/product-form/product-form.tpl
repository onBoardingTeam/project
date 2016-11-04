<form name="vm.productForm" ng-submit="vm.onSubmit(vm.name, vm.category, vm.specifications)" class="panel panel-default">
    <div class="panel-body">
        <div class="form-group">
            <label for="name">Product Name</label>
            <input id="name" name="name" class="form-control" ng-model="vm.name" type="text" placeholder="The name of your product ..." autocomplete="off" required>
        </div>
                <div class="form-group">
                    <label for="category">Category</label>
                    <input id="category" name="category" class="form-control" ng-model="vm.category" type="text" placeholder="Category ..." autocomplete="off" required>
                </div>


        <div class="form-group">
            <label for="specifications">Specifications</label>
            <textarea id="specifications" name="specifications" class="form-control" ng-model="vm.specifications" placeholder="specifations ..." required></textarea>
        </div>
    </div>

    <div class="panel-footer text-right">
        <button type="submit" class="btn btn-xs btn-success">Submit</button>
        <button type="reset" class="btn btn-xs btn-default" ng-click="vm.onReset()">Reset</button>
    </div>
</form>