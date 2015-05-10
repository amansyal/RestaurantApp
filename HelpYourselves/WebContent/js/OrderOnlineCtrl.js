/** OrderOnlineCtrl.js **/
/*global angular */

function OrderOnlineCtrl($scope) {
    'use strict';
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

}

angular.module('App').controller('OrderOnlineCtrl', ['$scope', OrderOnlineCtrl]);