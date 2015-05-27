latinCMS.controller("ABMPostController", ["$scope", "PostService", ABMPostController]);

function ABMPostController($scope, PostService){
	$scope.publicar = function(){
		PostService.add($scope.post).then(function(result){
			$scope.post.titulo = "";
			$scope.post.contenido = "";
		});
	}
}