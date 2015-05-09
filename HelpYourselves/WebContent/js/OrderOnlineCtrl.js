angular.module('App').controller('OrderOnlineCtrl',OrderOnlineCtrl);

function OrderOnlineCtrl($scope){
	$scope.menuItems = [
	           		{
	           			name: 'Grilled Cheese',
	           			price: 30.00,
	           			active:true
	           		},{
	           			name: 'Pizza',
	           			price: 40.00,
	           			active:false
	           		},{
	           			name: 'PB&J',
	           			price: 25.00,
	           			active:false
	           		},{
	           			name: 'Hot Dog',
	           			price: 22.00,
	           			active:false
	           		}
	           	];

};