latinCMS.controller("ABMCommentController", ["$scope", "CommentService", ABMCommentController]);

function ABMCommentController($scope, CommentService){
	$scope.fetchAllComments = function(){
		CommentService.getAll().then(function(result){
			$scope.comments = result.data;
		});
	};
	
	$scope.fetchAllComments();
}