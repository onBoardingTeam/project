<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >Softhouse</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#/">Home</a></li>
      <li><a href="#/viewproducts" >Products</a></li>
      <li><a href="#/manage" ng-if="(vm.hasCookies() && vm.role == 'adm')">Manage</a></li>
      <li><a href="#/processedorders" ng-if="(vm.hasCookies() && vm.role=='adm')">Processed Orders</a></li>
      <li><a href="#/orderhistory" ng-if="(vm.hasCookies() && vm.role=='emp')">Order History</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
       <li><a href="#/login" ng-if="!vm.hasCookies()"> Login</a></li>
       <li  ng-if="vm.hasCookies()"><a type = "btn" ng-click="vm.onlogout()"> Logout</a></li>
    </ul>
  </div>
</nav>
