<div class="container">
<navigation class="row"></navigation>

 <section id="content">
     <div class="row">
         <empty_space class="col-xs-4"></empty_space>

         <!--<div ng-show="error" class="alert alert-danger">{{error}}</div>-->

         <form name="vm.loginbox" ng-submit="vm.onSubmit(vm.username, vm.password)" class="panel panel-default">

             <div class="panel-body">
                 <div class="form-group">
                     <label for="username">Username</label>
                     <!--<i class="fa fa-key"></i>-->
                     <input type="text" name="username" id="username" class="form-control" ng-model="vm.username" placeholder="Username" autocomplete="off" required />
                     <!--<div class="row" ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</div>-->
                 </div>

                 <div class="form-group">
                     <label for="password">Password</label>
                     <!--<i class="fa fa-lock"></i>-->
                     <input type="password" name="password" id="password" class="form-control" ng-model="vm.password"  placeholder="********" required />
                     <!--<div class="row" ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</div>-->
                 </div>
             </div>

             <div class="panel-footer text-right">
                 <button type="submit" class="btn btn-xs btn-info">Login</button>
             </div>

         </form>
         <empty_space1 class="col-xs-4"></empty_space1>
     </div>
 </section>


    <order-status></order-status>
    </div>







