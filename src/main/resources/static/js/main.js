//获取焦点触发样式
function slideSearch(){
		$("#search").css("width","300px");
		}
//失去焦点
function returnSearch(){
		$("#search").css("width","200px");
		}
//菜单控制
$(function() {
	$(".menu-nav-item>a").on("click", function() {
		if(!$(".menu-nav").hasClass("menu-nav-mini")) {
			if($(this).next().css("display") == "none") {
				$(".menu-nav-item").children("ul").slideUp(500);
				$(this).next('ul').slideDown(300);
				$(this).parent("li").addClass("nav-show").siblings("li").removeClass("nav-show");
			} else {
				$(this).next().slideUp(400);
				$(this).parent("li").removeClass("nav-show").siblings("li").removeClass("nav-show");
			}
		} 
	})

	//缩略菜单显示
	$("#mini").on("click", function() {
		$("#right-wrap").removeClass("right-wrap-margin");
		$("#right-wrap").addClass("right-wrap-click");		  
		if(!$(".menu-nav").hasClass("menu-nav-mini")) {
			$(".menu-nav-item .nav-show").removeClass("nav-show");
			$(".menu-nav-item ").children("ul").removeAttr("style");
			$(".menu-nav").addClass("menu-nav-mini");
		} else {
			$("#right-wrap").addClass("right-wrap-margin");
			  $("#right-wrap").removeClass("right-wrap-click");
			$(".menu-nav").removeClass("menu-nav-mini");
		}

	})
})

