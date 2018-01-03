<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
    $(function() {
        //loginDialog的初期化
        $('#user_login_loginDialog').dialog({
            title : 'login',
            modal : true,
            closable : false,
            buttons : [ {
                text : 'login',
                iconCls : 'icon-edit',
                handler : function() {
                    $('#user_login_loginForm').submit();
                }
            }, {
                text : 'register',
                iconCls : 'icon-help',
                handler : function() {
                    $('#user_register_regForm input').val('');
                    //$('#index_regForm').form('load:{}');
                    $('#user_register_regDialog').dialog('open');
                }
            } ]
        });

        //loginForm 的初期化
        $('#user_login_loginForm').form({
            url : '${pageContext.request.contextPath}/userAction!login.action',
            success : function(data) {
                var json = jQuery.parseJSON(data);

                if (json.success) {
                    $('#user_login_loginDialog').dialog('close');
                }

                $.messager.show({
                    title : 'info',
                    msg : json.message
                });

            }

        });
        
        //回车提起 自动提交表单的功能
        $('#user_login_loginForm input').bind('keyup', function(event) {
            
            if (event.keyCode == '13') {
                $('#user_login_loginForm').submit();
            }
        });

        //loginForm 的input标签的值的初期化
        //$('#user_login_loginForm input').val('');

        //username Input获得焦点
        $('#user_login_loginForm input[name=username]').focus();
        
        //for IE
        window.setTimeout(function() {
            $('#user_login_loginForm input[name=username]').focus();
        },0);
    });
</script>


<div id="user_login_loginDialog" class="easyui-dialog">
	<form id="user_login_loginForm" method="post"> 
		<table>
			<tr>
				<th>username</th>
				<td><input name="username" class="easyui-validatebox" data-options="required:true"/></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input name="password" type="password" class="easyui-validatebox" data-options="required:true"/></td>
			</tr>
		</table>
	</form>
</div>

