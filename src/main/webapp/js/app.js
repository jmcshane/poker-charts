'use strict';

var app = angular.module("ngdemo", []);
app.controller("controller", function($scope, $http) {
	var value = $http.get("http://localhost:8080/poker-charts/rest/data/all")
		.success(function(data) {
			createChart(data);
		}).error(function() {
			alert("An error occurred");
		});
})