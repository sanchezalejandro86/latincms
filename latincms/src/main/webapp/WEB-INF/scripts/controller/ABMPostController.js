latinCMS.controller("ABMPostController", ["$scope", "PostService", ABMPostController]);

function ABMPostController($scope, PostService){
	
	$scope.fetchAllPosts = function(){
		PostService.getAll().then(function(result){
			$scope.posts = result.data;
		});
	}
	
	$scope.fetchAllPosts();
}