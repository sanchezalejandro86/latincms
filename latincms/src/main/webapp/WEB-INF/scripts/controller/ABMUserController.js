latinCMS.controller("ABMUserController", ["$scope", "$location", "UserService", ABMUserController]);

function ABMUserController($scope, $location, UserService){
	$scope.registrar = function(){
		UserService.add($scope.user).then(function(result){
			$scope.user.username = '';
			$scope.user.nombre = '';
			$scope.user.apellido = '';
			$scope.user.email = '';
			$scope.user.perfil.id = '';
			$location.path("/admin/user"); 
		});
	}
}