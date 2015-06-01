latinCMS.service("UserService", ["$http", UserService]);

function UserService($http){
	var service = {};
	
	service.getAll = function(){
		return $http.get("user/getAll");
	}
	
	service.get = function (postId){
		return $http.get("page/get/"+userId);
	}
	
	service.add = function(user){
		return $http.post("user/add/", user);
	}
	
	service.delete = function(userId){
		return $http.post("user/delete", {id: userId});
	}
	
	return service;
}