latinCMS.service("ComentarioService", ["$http", ComentarioService]);

function ComentarioService($http){
	var service = {};
	
	service.publicar = function(contenido, postId){
		return $http.post("comentario/add", {contenido: contenido/*, postId: postId*/});
	}
	
	return service;
}