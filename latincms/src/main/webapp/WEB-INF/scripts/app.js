var latinCMS = angular.module ( 'latinCMS' , ['ngRoute', 'ngSanitize', 'ui.bootstrap', 'ui.tree', 'ng-breadcrumbs']);

latinCMS.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/layout',
        controller: HomeController,
        label: 'Home'
    });
    $routeProvider.when('/post/:postId', {
    	templateUrl: 'post/layout',
    	controller: PostController,
    	label: 'Post'
    	
    });
    $routeProvider.when('/admin', {
        templateUrl: 'admin/layout',
        controller: AdminController,
        label: 'Admin'
    });
    $routeProvider.when('/admin/post', {
    	templateUrl: 'admin/abm/post/layout',
    	controller: ListPostController,
    	label: 'Posts'
    });
    $routeProvider.when('/admin/post/nuevo', {
    	templateUrl: 'admin/abm/post/nuevo',
    	controller: ABMPostController,
    	label: 'Editar'
    });
    $routeProvider.when('/admin/page', {
    	templateUrl: 'admin/abm/page/layout',
    	controller: ListPageController,
    	label: 'Páginas'
    });
    $routeProvider.when('/admin/page/nuevo', {
    	templateUrl: 'admin/abm/page/nuevo',
    	controller: ABMPageController,
		label: 'Editar'
    });
    $routeProvider.when('/admin/comment', {
    	templateUrl: 'admin/abm/comment/layout',
    	controller: ABMCommentController,
    	label: 'Comentarios'
    });
    $routeProvider.when('/admin/menu', {
    	templateUrl: 'admin/abm/menu/layout',
    	controller: ABMMenuController,
    	label: 'Men&uacute;s'
    });
    $routeProvider.when('/admin/user', {
    	templateUrl: 'admin/abm/user/layout',
    	controller: ListUserController,
    	label: 'Usuarios'
    });
    $routeProvider.when('/admin/user/nuevo', {
    	templateUrl: 'admin/abm/user/nuevo',
    	controller: ABMUserController,
    	label: 'Editar'
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);
