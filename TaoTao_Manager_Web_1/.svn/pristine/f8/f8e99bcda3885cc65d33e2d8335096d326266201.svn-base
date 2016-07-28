<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="importall()">同步索引库</a>
</div>
<script type="text/javascript">
	function importall(){
		$.get("/index/importall","",function(data){
			if (data.status==200) {
				alert("导入成功");
			} else {
				alert(data.msg);
			}
			
		});	
	}
</script>