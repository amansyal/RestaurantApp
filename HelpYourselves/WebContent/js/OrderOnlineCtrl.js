angular.module('App').controller('OrderOnlineCtrl',OrderOnlineCtrl);

function OrderOnlineCtrl($scope,$rootScope,$window){
	$scope.foods = [
	           		{
	           			foodItems: 'Grilled Cheese',
	           			ingredients: "white bread, cheese product",
	           			price:"$10.00",
	           			selected:false
	           		},{
	           			foodItems: 'PB&J',
	           			ingredients: "white bread, peanut butter, grape jelly",
	           			price:"$15.00",
	           			selected:false
	           		},{
	           			foodItems: 'Pizza',
	           			ingredients: "cheese, tomato, dough",
	           			price:"$20.00",
	           			selected:false
	           		},{
	           			foodItems: 'Hot Dog',
	           			ingredients: "hotdog*, pretzel bun",
	           			price:"$8.00",
	           			selected:false
	           		}
	           	];
	
	$scope.orderOnline = function(){
		var orderIndex =0;
		for(var i=0;i<$scope.foods.length;i++){
			if($scope.foods[i].selected){
				$rootScope.order[orderIndex] = {foodItems:$scope.foods[i].foodItems,price:$scope.foods[i].price};
				orderIndex++;
			}
		}
		alert("food selected = ="+$scope.order[0].foodItems);
		$window.location.href="#/ReviewOrder";
		

	}

};