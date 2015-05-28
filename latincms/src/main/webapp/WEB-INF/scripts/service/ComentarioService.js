latinCMS.service("ComentarioService", ["$http", ComentarioService]);

function ComentarioService($http){
	var service = {};
	
	service.publicar = function(contenido, postId){
		return $http.post("comentario/add", {contenido: contenido, post: {id: postId}});
	}
	
	service.getAll = function(){
		return $http.get("comentario/getAll");
	}
	
	return service;
}