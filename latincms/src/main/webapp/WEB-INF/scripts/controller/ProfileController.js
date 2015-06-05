latinCMS.controller("ProfileController", ["$scope", "$location", "UserService", ProfileController]);

function ProfileController($scope, $location, UserService){
	$scope.fetchCurrentUser = function(){
		UserService.getCurrent().then(function(result){
			$scope.currentUser = result.data;
		});
	}
	
	$scope.fetchCurrentUser();
	
	$scope.guardar = function(){
		UserService.update($scope.currentUser).then(function(result){
			$scope.currentUser = {};
			$location.path("/home"); 
		});
	}
}