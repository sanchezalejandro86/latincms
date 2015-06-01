latinCMS.controller("ListUserController", ["$scope", "UserService", ListUserController]);

function ListUserController($scope, UserService){
	
	$scope.fetchAllUsers = function(){
		UserService.getAll().then(function(result){
			$scope.users = result.data;
		});
	};
	
	$scope.deleteUser = function(userId){
		UserService.delete(userId).then(function(result){
			$scope.fetchAllUsers();
		});
	};
	
	$scope.fetchAllUsers();
}