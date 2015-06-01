latinCMS.controller("PostController", ["$scope", "$sce", "$routeParams", "PostService", "CommentService", PostController]);

function PostController($scope, $sce, $routeParams, PostService, CommentService){
	 var postId = $routeParams.postId;
	 
	 //TODO Si postId es null mostrar error
	 
	 PostService.get(postId).then(function(result){
		 $scope.post = result.data;
	 });
	 
	 $scope.publicar = function(){
		 CommentService.publicar($scope.textoComentario, postId).then(function(result){
			 $scope.textoComentario = "";
			 $scope.post.comentarios.push(result.data);
		 });
	 };
	 
	 $scope.renderHtml = function(html_code){
		 return $sce.trustAsHtml(html_code);
	 };
}