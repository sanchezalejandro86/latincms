latinCMS.controller("ABMPageController", ["$scope", "$location", "PageService", ABMPageController]);

function ABMPageController($scope, $location, PageService){
	$scope.publicar = function(){
		PageService.add($scope.page).then(function(result){
			$scope.page.titulo = "";
			$scope.page.contenido = "";
			$location.path("/admin/abm/page"); 
		});
	}
}