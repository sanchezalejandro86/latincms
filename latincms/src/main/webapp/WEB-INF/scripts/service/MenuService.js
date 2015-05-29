latinCMS.service("MenuService", ["$http", MenuService]);

function MenuService($http){
	var service = {};
	
	service.getAll = function(){
		return $http.get("menu/getAll");
	}
	
	service.save = function(menu){
		return $http.post("menu/save", menu);
	}
	
	return service;
}