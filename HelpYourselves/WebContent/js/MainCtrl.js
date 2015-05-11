/** MainCtrl.js * */
/* global angular */
function MainCtrl ($scope, $rootScope) {
	'use strict';
	$rootScope.order = [];
	$scope.foods = [
			{
				name : 'Caesar Salad',
				description : "A salad of romaine lettuce and croutons dressed with parmesan cheese, lemon juice, olive oil, egg, Worcestershire sauce, garlic, and black pepper.",
				price : "$35",
				imgSrc : "../img/caesar-salad-lower.jpg",
				selected : false
			},
			{
				name : 'Spicy Shrimp Scampi Fritta',
				description : "Lightly breaded and fried, tossed with garlic and a spicy cherry pepper sauce.",
				price : "$30",
				imgSrc : "../img/Shrimp.jpg",
				selected : false
			},
			{
				name : 'Pizzaiola Flatbreada',
				description : "Italian sausage, pepperoni, roasted red peppers, basil and homemade marinara with a blend of four Italian cheeses.",
				price : "$30",
				imgSrc : "../img/d-pizzaiola-flatbread-dpv.jpg",
				selected : false
			},
			{
				name : 'Spaghetti with Meatballs',
				description : "Traditional meat sauce seasoned with garlic and herbs over spaghetti with meatballs.",
				price : "$20",
				imgSrc : "../img/spaghetti-and-meatballs-3.jpg",
				selected : false
			} ];

	$rootScope.total = function () {
		if ($rootScope.order.length == 0) {
			return 0;
		} else {

		}
	}
};

angular.module('App').controller('MainCtrl', MainCtrl);
