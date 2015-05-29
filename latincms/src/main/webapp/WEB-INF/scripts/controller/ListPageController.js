latinCMS.controller("ListPageController", ["$scope", "PageService", ListPageController]);

function ListPageController($scope, PageService){
	
	$scope.fetchAllPages = function(){
		PageService.getAll().then(function(result){
			$scope.pages = result.data;
		});
	};
	
	$scope.deletePage = function(postId){
		PageService.delete(pageId).then(function(result){
			$scope.fetchAllPages();
		});
	};
	
	$scope.fetchAllPages();
}