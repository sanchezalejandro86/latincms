var latinCMS = angular.module ( 'latinCMS' , ['ngRoute', 'ngSanitize', 'ui.bootstrap']);

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
    	controller: ABMPostController
    });
    $routeProvider.when('/admin/abm/post/nuevo', {
    	templateUrl: 'admin/abm/post/nuevo',
    	controller: ABMPostController
    });
    $routeProvider.when('/admin/abm/comentarios', {
    	templateUrl: 'admin/abm/comentarios/layout',
    	controller: ABMComentarioController
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);