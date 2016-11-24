<form name="vm.productForm" ng-submit="vm.onSubmit(vm.name, vm.category, vm.specifications, vm.quantity)" class="panel panel-default">
    <div class="panel-heading">
    <label >Add Products</label>
    </div>


    <div class="panel-body">
        <div class="form-group">
            <label >Product Name</label>
            <input id="name" name="name" class="form-control" ng-model="vm.name" type="text" placeholder="The name of your product ..." autocomplete="off" required>
        </div>

      <!------- category field starts ---->
        <label >Category</label>
        <div class="row">
            <div class="form-group col-xs-5">
                <input id="category" name="category"  class="form-control" ng-model="vm.category" type="text" placeholder="The category of your product ..." autocomplete="off" required>
            </div>

            <div class="col-xs-3">
                <select class="form-control" id="mySelect" ng-change="vm.selectedCategory(vm.selectedCat)" ng-model="vm.selectedCat">
                    <option value="" disabled selected>Select a category</option>
                    <option ng-repeat="xx in vm.Cat" value="{{xx.category}}">{{xx.category}}</option>
                </select>
            </div>
        </div>

        <!--category field ends---->

        <div class="form-group">
            <label for="specifications">Specifications</label>
            <textarea id="specifications" name="specifications" class="form-control" ng-model="vm.specifications" placeholder="specifations ..." required></textarea>
        </div>

        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input id="quantity" name="quantity" class="form-control" ng-model="vm.quantity" placeholder="enter quantity ..." required>
        </div>

    </div>

    <div class="panel-footer text-right">
        <button type="submit" style="background-color: black" class="btn btn-xs btn-success">Submit</button>
        <button type="reset" class="btn btn-xs btn-default" ng-click="vm.onReset()">Reset</button>
    </div>

</form>

