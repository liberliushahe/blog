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
				toastr.error("点击出错");
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
				toastr.error("点击出错");
			}
		});
	})
	//用户编辑
	$(".editUser").click(function(){
		$.ajax({
			url:"/users/edit/"+$(this).attr("userId"),
			success:function(data){
				$("#userFormContainer").html(data);
			},
			error:function(){
				toastr.error("点击出错");
			}
		})
	});
   //提交表单数据
	$("#submitEdit").click(function(){
		$.ajax({
			url:"/users",
			type: "POST", 
			data:$("#userForm").serialize(),
			success:function(data){
				if(data.success){
					toastr.info("操作成功")
				}else{
					toastr.error(data.message);
				}
				
			},
			error:function(){
			toastr.error("error!");	
			}
		})

	});
	//删除用户
	$(".deleteUser").click(function(){
		$.ajax({
			url:"/users/del/"+$(this).attr("userId"),
			type:"DELETE",
			success:function(){
				toastr.info("操作成功");	
			},
			error:function(){
				toastr.error("error!");		
			}
		})
	})
})

	

