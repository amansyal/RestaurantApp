/**
 * 
 */

angular
		.module("restaurantApp")
		.factory(
				'getYelpDataFactory',
				function($http) {

					$scope.data;
					return {
						getAllRestaurant: function(ctrlScope) {

							
							console.log("inside getjobs function");

							$http			
									.get(
											'GetYelpDataServlet')
									.success(function(alldata) {
										data = alldata;
										ctrlScope.getFactoryVal(data);
										console.log("in success of get");
										
									}).error(function() {
										console.log("in reject of get");

									});

						}}});