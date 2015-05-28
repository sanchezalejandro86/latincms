latinCMS.controller("ListPostController", ["$scope", "PostService", ListPostController]);

function ListPostController($scope, PostService){
	
	$scope.fetchAllPosts = function(){
		PostService.getAll().then(function(result){
			$scope.posts = result.data;
		});
	};
	
	$scope.deletePost = function(postId){
		PostService.delete(postId).then(function(result){
			$scope.fetchAllPosts();
		});
	};
	
	$scope.fetchAllPosts();
}