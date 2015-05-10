/** routingController.js **/
/*global angular */

angular.module('App').config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    'use strict';
	$routeProvider.when("/", {
		controller : "MainCtrl",
		controllerAs : "App"
	}).when("/Menu", {
		templateUrl : "partials/MenuItems.html",
		controller : "MainCtrl",
		controllerAs : "App"
	}).when("/Location", {
		templateUrl : "partials/Locations.html",
		controller : "MainCtrl",
		controllerAs : "App"
	}).when("/OrderOnline", {
		templateUrl : "partials/OnlineOrder.html",
		controller : "OrderOnlineCtrl",
		controllerAs : "App"
	}).when("/Reviews", {
		templateUrl : "partials/Reviews.html",
		controller : "MainCtrl",
		controllerAs : "App"
	}).otherwise({
		redirectTo : "/Menu"
	});
}]);