/** OrderOnlineCtrl.js * */
/* global angular */

function OrderOnlineCtrl ($scope, $rootScope, $window) {
	'use strict';

	$scope.orderOnline = function () {
		var orderIndex = 0;
		for (var i = 0; i < $scope.foods.length; i++) {
			if ($scope.foods[i].selected) {
				$rootScope.order[orderIndex] = {
					foodItems : $scope.foods[i].foodItems,
					price : $scope.foods[i].price
				};
				orderIndex++;
			}
		}
		alert("food selected = =" + $scope.order[0].foodItems);
		$window.location.href = "#/ReviewOrder";
	}
	$scope.menuItems = [ {
		name : 'Grilled Cheese',
		price : 30.00,
		selected : true
	}, {
		name : 'Pizza',
		price : 40.00,
		selected : false
	}, {
		name : 'PB&J',
		price : 25.00,
		selected : false
	}, {
		name : 'Hot Dog',
		price : 22.00,
		selected : false
	} ];
	$scope.foods = [ {
		name : 'Grilled Cheese',
		ingredients : "white bread, cheese product",
		price : "$10.00",
		selected : false
	}, {
		name : 'PB&J',
		ingredients : "white bread, peanut butter, grape jelly",
		price : "$15.00",
		selected : false
	}, {
		name : 'Pizza',
		ingredients : "cheese, tomato, dough",
		price : "$20.00",
		selected : false
	}, {
		name : 'Hot Dog',
		ingredients : "hotdog*, pretzel bun",
		price : "$8.00",
		selected : false
	} ];
}

angular.module('App').controller('OrderOnlineCtrl', [ '$scope', '$rootScope', '$window', OrderOnlineCtrl ]);