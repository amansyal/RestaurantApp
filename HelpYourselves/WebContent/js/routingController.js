angular.module('App').config(function($routeProvider,$locationProvider){
$routeProvider.when("/",
		{
		controller:"MainCtrl",
		controllerAs:"App"
		}
	)
	.when("/Menu",
			{
		templateUrl:"partials/MenuItems.html",
		controller:"MainCtrl",
		controllerAs:"App"
	}
	)
	.when("/Location",
			{
		templateUrl:"partials/Location.html",
		controller:"MainCtrl",
		controllerAs:"App"
	}
	)
	.when("/OrderOnline",{
		templateUrl:"partials/OrderOnline.html",
		controller:"OrderOnlineCtrl",
		controllerAs:"App"
	}
	)
	.when("/Reviews",{
		templateUrl:"partials/Reviews.html",
		controller:"MainCtrl",
		controllerAs:"App"
	}
	)
	.otherwise({
		  redirectTo:"/Menu"
	  });
});