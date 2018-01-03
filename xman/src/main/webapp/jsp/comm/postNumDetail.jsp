<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function() {
        //追加对话框的初始化 初始状态为关闭 注册按钮绑定提交函数
        $('#comm_postNumDetail_editDialog').dialog({
            title : '郵便番号住所詳細',
            closable : true,
            modal : true
        }).dialog('close');
    });
</script>
<div id="comm_postNumDetail_editDialog" class="easyui-dialog">
	<form id="comm_postNumDetail_editForm" method="post">
		<table>
			<tr>
				<td>郵便番号</td>
				<td><input name="empPost" readonly="readonly" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<td>住所</td>
				<td><input name="empAddress" type="text" readonly="readonly" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
		</table>
	</form>
</div>
