/** ContactInfoCtrl.js **/
/*global angular */
function ContactInfoCtrl($scope) {
    'use strict';
	$scope.business = {
		phone : '847-742-2411',
		address : '59 W Grand Ave, Chicago, IL 60654',
		email : 'HelpYourselves@food.com'
	};
}

angular.module('App').controller('ContactInfoCtrl', ['$scope', ContactInfoCtrl]);
