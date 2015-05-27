var latinCMS = angular.module ( 'latinCMS' , ['ngRoute', 'ngSanitize', 'ui.bootstrap', 'ap.lateralSlideMenu']);

latinCMS.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/layout',
        controller: HomeController
    });
    $routeProvider.when('/post/:postId', {
    	templateUrl: 'post/layout',
    	controller: PostController
    });
    $routeProvider.when('/admin', {
        templateUrl: 'admin/layout',
        controller: AdminController
    });
    $routeProvider.when('/admin/abm/post', {
    	templateUrl: 'admin/abm/post/layout',
    	controller: ListPostController
    });
    $routeProvider.when('/admin/abm/post/nuevo', {
    	templateUrl: 'admin/abm/post/nuevo',
    	controller: ABMPostController
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);