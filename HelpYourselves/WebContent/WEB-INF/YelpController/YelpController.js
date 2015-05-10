/**
 * 
 */
var app = angular.module("restaurantApp");
				app.controller(
						'yelpDataController',
						[ '$scope', 'getYelpDataFactory','$rootScope','$location',
								function($scope, getjobFactory,$rootScope, $location, $cookieStore) {
								
							$scope.restaurantlist;
									$scope.getYelpdata = function() {
										getjobFactory.getJobs($scope);
									}

									$scope.getYelpdata();

									$scope.getFactoryVal = function(response) {
										console.log("response is " + JSON.stringify(response))
										//$('#loader').hide();
									   // $('#restaurantlist').show();
										//$scope.restaurantlist = response;
										console.log("in yelpresponse "+ response);
										
									}
									
						}
						]
						);
									