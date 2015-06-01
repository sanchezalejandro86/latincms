latinCMS.service("CommentService", ["$http", CommentService]);

function CommentService($http){
	var service = {};
	
	service.publicar = function(contenido, postId){
		return $http.post("comment/add", {contenido: contenido, post: {id: postId}});
	}
	
	service.getAll = function(){
		return $http.get("comment/getAll");
	}
	
	return service;
}