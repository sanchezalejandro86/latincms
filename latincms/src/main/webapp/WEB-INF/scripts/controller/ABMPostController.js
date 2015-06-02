latinCMS.controller("ABMPostController", ["$scope", "$location", "PostService", ABMPostController]);

function ABMPostController($scope, $location, PostService){
	$scope.publicar = function(){
		PostService.add($scope.post).then(function(result){
			$scope.post.titulo = "";
			$scope.post.contenido = "";
			$location.path("/admin/post"); 
		});
	}
}