$(function() {
	var pageSize;
	// 管理员前端菜单js控制
	$(".list-menu-group .list-menu-group-item").click(function() {
		var url = $(this).attr("url");
		$.ajax({
			url : url,
			success : function(data) {
				$("#right-wrap").html(data);
			},
			error : function() {
				toastr.error("点击出错");
			}
		});
	});
	// 根据参数获取当前数据
	
	function getUserByName(index, size) {
		$.ajax({
			url : "/users",
			data : {
				"async" : true,
				"pageIndex" : index,
				"pageSize" : size,
				"name" : $("#searchkey").val()
			},
			success : function(data) {
				$("#mainContainerRepleace").html(data);
			},
			error : function() {
				toastr.error("数据获取出错");
			}
		})
	}
	// 用户添加控制
	$("#addUser").click(function() {
		$.ajax({
			url : "/users/add",
			success : function(data) {
				$("#userFormContainer").html(data);
			},
			error : function() {
				toastr.error("点击出错");
			}
		});
	})
	// 用户编辑
	$("#right-wrap").on("click",".editUser",function(){
		$.ajax({
			url : "/users/edit/" + $(this).attr("userId"),
			success : function(data) {
				$("#userFormContainer").html(data);
			},
			error : function() {
				toastr.error("点击出错");
			}
		})
	});
	// 提交表单数据
	$("#submitEdit").click(function() {
		// 获取 CSRF Token 
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			url : "/users",
			type : "POST",
			beforeSend: function(request) {
                request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token 
            },
			data : $("#userForm").serialize(),
			success : function(data) {
				$('#userForm')
				.val('')
				.removeAttr('selected');
				if (data.success) {
					getUserByName(0, pageSize);
				} else {
					toastr.error(data.message);
				}

			},
			error : function() {
				toastr.error("error!");
			}
		})

	});
	// 删除用户
	//修改这种方式
	
	$("#right-wrap").on("click",".deleteUser",function(){
		// 获取 CSRF Token 
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			url : "/users/del/" + $(this).attr("userId"),
			type : "DELETE",
			beforeSend:function(request){
				request.setRequestHeader(csrfToken,csrfHeader)
			},
			success : function() {
				getUserByName(0, pageSize);
			},
			error : function() {
				toastr.error("error!");
			}
		})
	})
	// 搜索
	$("#searchNameBtn").click(function() {
		getUserByName(0, pageSize);
	});
})
