latinCMS.controller("ABMMenuController", ["$scope", "MenuService", "PageService", ABMMenuController]);

function ABMMenuController($scope, MenuService, PageService){
	$scope.fetchAllPages = function(){
		PageService.getAll().then(function(result){
			$scope.pages = result.data;
		});
	}
	
	$scope.fetchAllPages();
	
	$scope.link = {
			texto: '',
			url: ''
	};
	
	
}