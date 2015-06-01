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
		return $http.post("post/");
	}
	
	service.add = function(post){
		return $http.post("post/add/", post);
	}
	
	service.delete = function(postId){
		return $http.post("post/delete", {id: postId});
	}
	
	service.getYears = function(){
		return $http.get("post/getYears");
	}
	
	service.getMonths = function(year){
		return $http.get("post/getMonths/"+year);
	}
	
	service.getPostsByMonth = function(month){
		return $http.get("post/getPostsByMonth/"+month);
	}
	
	return service;
}