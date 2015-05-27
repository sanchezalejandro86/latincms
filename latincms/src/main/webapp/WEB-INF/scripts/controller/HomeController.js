latinCMS.controller("HomeController", ["$scope", "PostService", HomeController]);

function HomeController($scope, PostService){
	
	$scope.fetchAllPosts = function(){
		PostService.getAll().then(function(result){
			$scope.posts = result.data;
		});
	}
	
	$scope.fetchAllPosts();
}