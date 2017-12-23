//管理员前端js控制
$(function() {
	$(".list-menu-group .list-menu-group-item").click(function(){
		var url=$(this).attr("url");
		$.ajax({
			url:url,
			success:function(data){
				$("#right-wrap").html(data);
			},
			error:function(){
				alert(error);
			}
		});
	})	
})

	

