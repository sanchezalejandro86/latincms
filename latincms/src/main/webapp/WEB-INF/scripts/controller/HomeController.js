latinCMS.controller("HomeController", ["$scope", "breadcrumbs", "PostService", HomeController]);

function HomeController($scope, breadcrumbs, PostService){
	
	$scope.$parent.breadcrumbs = breadcrumbs;
	
	$scope.fetchAllPosts = function(){
		PostService.getAll().then(function(result){
			$scope.posts = result.data;
		});
	}
	
	$scope.fetchAllPosts();
	
    $scope.add = function(data) {
    	if(data.nodes.length == 0){
    		if(data.level == 1){
    			//TODO traerse los hijos: MESES
    			PostService.getMonths(data.name).then(function(result){
    				data.nodes = result.data;
    			});
    		}else if(data.level == 2){
    			//TODO traerse los hijos: POSTS
    		    PostService.getPostsByMonth(data.name).then(function(result){
    		    	data.nodes = result.data;
    			});
    		}
    		data.open = true;
    	}else{
    		data.open = !data.open;
    	}
    };
    
    $scope.tree = []
    PostService.getYears().then(function(result){
    	$scope.tree = result.data;
    });

    
}