latinCMS.service("UserService", ["$http", UserService]);

function UserService($http){
	var service = {};
	
	service.getAll = function(){
		return $http.get("user/getAll");
	}
	
	service.get = function (postId){
		return $http.get("user/get/"+userId);
	}
	
	service.getCurrent = function (){
		return $http.get("user/getCurrent");
	}
	
	service.add = function(user){
		return $http.post("user/add/", user);
	}
	
	service.delete = function(userId){
		return $http.post("user/delete", {id: userId});
	}
	
	service.update = function(user){
		return $http.post("user/update", user);
	}
	
	return service;
}