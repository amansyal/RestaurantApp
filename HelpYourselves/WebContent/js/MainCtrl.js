angular.module('App').controller('MainCtrl',MainCtrl);

function MainCtrl($scope,$rootScope){
	$rootScope.order = [];
	$scope.foods = [
	           		{
	           			foodItems: 'Caesar Salad',
	           			ingredients: "A salad of romaine lettuce and croutons dressed with parmesan cheese, lemon juice, olive oil, egg, Worcestershire sauce, garlic, and black pepper.",
	           			price:"$35",
	           			imgSrc:"../img/caesar-salad-lower.jpg",
	           			selected:false
	           		},{
	           			foodItems: 'Spicy Shrimp Scampi Fritta',
	           			ingredients: "Lightly breaded and fried, tossed with garlic and a spicy cherry pepper sauce.",
	           			price:"$30",
	           			imgSrc:"../img/Shrimp.jpg",
	           			selected:false
	           		},{
	           			foodItems: 'Pizzaiola Flatbreada',
	           			ingredients: "Italian sausage, pepperoni, roasted red peppers, basil and homemade marinara with a blend of four Italian cheeses.",
	           			price:"$30",
	           			imgSrc:"../img/d-pizzaiola-flatbread-dpv.jpg",
	           			selected:false
	           		},{
	           			foodItems: 'Spaghetti with Meatballs',
	           			ingredients: "Traditional meat sauce seasoned with garlic and herbs over spaghetti with meatballs.",
	           			price:"$20",
	           			imgSrc:"../img/spaghetti-and-meatballs-3.jpg",
	           			selected:false
	           		}
	           	];
	
	$rootScope.total = function(){
		if($rootScope.order.length==0){
			return 0;
		}
		else{
			
		}
	}
};