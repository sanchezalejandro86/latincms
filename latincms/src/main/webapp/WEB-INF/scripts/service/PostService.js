latinCMS.service("PostService", ["$http", PostService]);

function PostService($http){
	var service = {};
	
	service.getAll = function(){
		return $http.get("post/getAll");
	}
	
	service.get = function (postId){
		return $http.get("post/get/"+postId);
	}
	
	service.publicar = function(comentario){
		return $http.post("post/")
	}
	
	return service;
}