latinCMS.filter("excerpt", function(){
	return function(content){
		return content.substr(0, 200) + "...";
	}
});
