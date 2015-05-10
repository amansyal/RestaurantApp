/** MenuCtrl.js **/
/*global angular*/
function MenuCtrl($scope) {
    'use strict';
    $scope.menuItems = [ {
		name : 'Grilled Cheese',
        description : 'American slices on whole wheat bread grilled to perfection',
		price : 30.00,
		selected : true
	}, {
		name : 'Pizza',
        description : 'Traditionally cooked in a brick oven with mozzerella and marinera.',
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

angular.module('App').controller('MenuCtrl', ['$scope', MenuCtrl]);