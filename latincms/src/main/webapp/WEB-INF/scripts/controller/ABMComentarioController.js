latinCMS.controller("ABMComentarioController", ["$scope", "ComentarioService", ABMComentarioController]);

function ABMComentarioController($scope, ComentarioService){
	$scope.fetchAllComentarios = function(){
		ComentarioService.getAll().then(function(result){
			$scope.comentarios = result.data;
		});
	};
	
	$scope.fetchAllComentarios();
}