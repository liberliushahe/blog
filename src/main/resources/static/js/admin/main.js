$(function() {
	//管理员前端菜单js控制
	$(".list-menu-group .list-menu-group-item").click(function(){
		var url=$(this).attr("url");
		$.ajax({
			url:url,
			success:function(data){
				$("#right-wrap").html(data);
			},
			error:function(){
				alert("点击出错");
			}
		});
	});	
	//用户添加控制
	$("#addUser").click(function(){
		$.ajax({
			url:"/users/add",
			success:function(data){
				$("#userFormContainer").html(data);
			},
			error:function(){
				alert(error);
			}
		});
	})
	//用户编辑
	$("#editUser").click(function(){
		var id=$(this).attr("userId");
		$.ajax({
			url:"/users/edit/"+$(this).attr("userId"),
			success:function(data){
				$("#userFormContainer").html(data);
			},
			error:function(){
				
			}
		})
	})

})

	

