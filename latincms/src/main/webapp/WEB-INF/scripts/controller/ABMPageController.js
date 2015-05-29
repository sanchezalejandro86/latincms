latinCMS.controller("ABMPageController", ["$scope", "PageService", ABMPageController]);

function ABMPageController($scope, PageService){
	$scope.publicar = function(){
		PageService.add($scope.page).then(function(result){
			$scope.page.titulo = "";
			$scope.page.contenido = "";
		});
	}
}