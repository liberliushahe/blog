//获取焦点触发样式
function slideSearch(){
		$("#search").css("width","300px");
		}
//失去焦点
function returnSearch(){
		$("#search").css("width","200px");
		}
$(function(){
	$(".left-card").slideDown(300);
})
