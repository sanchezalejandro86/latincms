latinCMS.controller("ABMPostController", ["$scope", "$location", "breadcrumbs", "PostService", ABMPostController]);

function ABMPostController($scope, $location, breadcrumbs, PostService){
	$scope.breadcrumbs = breadcrumbs;
	
	$scope.publicar = function(){
		PostService.add($scope.post).then(function(result){
			$scope.post.titulo = "";
			$scope.post.contenido = "";
			$location.path("/admin/post"); 
		});
	}
}