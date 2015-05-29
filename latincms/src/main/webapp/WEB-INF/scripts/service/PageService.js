latinCMS.service("PageService", ["$http", PageService]);

function PageService($http){
	var service = {};
	
	service.getAll = function(){
		return $http.get("page/getAll");
	}
	
	service.get = function (postId){
		return $http.get("page/get/"+postId);
	}
	
	service.publicar = function(comentario){
		return $http.post("page/");
	}
	
	service.add = function(page){
		return $http.post("page/add/", page);
	}
	
	service.delete = function(postId){
		return $http.post("page/delete", {id: pageId});
	}
	
	return service;
}