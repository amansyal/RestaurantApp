/** routingController.js **/
/*global angular */

angular.module('App').config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    'use strict';
	$routeProvider.when("/", {
	}).when("/Menu", {
		templateUrl : "partials/MenuItems.html",
		controller : "MenuCtrl"
	}).when("/Location", {
		templateUrl : "partials/Locations.html",
		controller : "ContactInfoCtrl",
		controllerAs : "locationCtrl"
	}).when("/OrderOnline", {
		templateUrl : "partials/OnlineOrder.html",
		controller : "OrderOnlineCtrl",
		controllerAs : "orderCtrl"
	}).when("/Reviews", {
		templateUrl : "partials/Reviews.html",
		controller : "ReviewCtrl",
		controllerAs : "reviewCtrl"
	}).otherwise({
		redirectTo : "/Menu"
	});
}]);