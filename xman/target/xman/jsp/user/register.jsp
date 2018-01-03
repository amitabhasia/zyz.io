<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
    $(function() {

        //注册对话框的初始化 初始状态为关闭 注册按钮绑定提交函数
        $('#user_register_regDialog').dialog({
            title : 'register',
            modal : true,
            closable : true,
            buttons : [ {
                text : 'register',
                iconCls : 'icon-help',
                handler : function() {
                    //$('#index_regForm').submit();
                    regUser();
                    //regUserByAjax();
                }
            } ]
        }).dialog('close');

        //回车提起 自动提交表单的功能
        $('#user_register_regForm input').bind('keyup', function(event) {
            
            if (event.keyCode == '13') {
                regUser();
            }
        });

    });

 
    //利用EasyUI的Form的注册功能
    function regUser() {
        // Initiate form and submit it to a designated url;
        $('#user_register_regForm').form('submit', {
            // el expression${pageContext.request.contextPath} == java code<\%=request.getContextPath()%>
            //url : '${pageContext.request.contextPath}/userAction!registerByServletActionContextParameter.action',
            //url : '${pageContext.request.contextPath}/userAction!registerBySetClassProperty.action',
            url : '${pageContext.request.contextPath}/userAction!registerByModelDriven.action',

            //onSubmit : function() {
            // 如果不写此方法 则前台的form中的validate会check并作出相应check结果提示
            // do some check
            // return false to prevent submit;
            //},

            // data is a return value of String 
            success : function(data) {
                //javaScript 的原生方法 创建对象 转换JSon字符串为对象
                //var obj = eval("("+data+")");

                console.info(data);

                var obj = jQuery.parseJSON(data);

                if (obj.success) {
                    $('#user_register_regDialog').dialog('close');
                }

                $.messager.show({
                    title : 'INFO',
                    msg : obj.message,
                //timeout : 5000,
                //showType : 'slide'
                });
            }
        });
    }


    //利用jQuery的ajax的注册功能
    function regUserByAjax() {
        if ($('#user_register_regForm').form('validate')) {
            $.ajax({
                url : '${pageContext.request.contextPath}/userAction!register.action',
                method : 'post',
                data : $('#user_register_regForm').serialize(),
                /*{
                    username : $('#index_regForm input[name=username]')
                            .val(),
                    password : $('#index_regForm input[name=password]')
                            .val()
                },*/
                dataType : 'json',
                success : function(data, textStatus, jqXHR) {
                    console.info(data);

                    //由于谢了dataType : 'json',所以data返回时直接就是json无需再转换形式
                    //var obj = $.parseJSON(data);
                    var obj = data;

                    if (obj.success) {
                        $('#user_register_regDialog').dialog('close');
                    }

                    $.messager.show({
                        title : 'INFO',
                        msg : obj.message,
                        timeout : 5000,
                        showType : 'slide'
                    });
                }
            });
        } else {
            alert('validate failure');
        }
    }
</script>

<div id="user_register_regDialog">
	<form id="user_register_regForm" method="post">
		<table>
			<tr>
				<th>username</th>
				<%--表单要Name不要ID--%>
				<td><input name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'username is required!'" /></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input name="password" id="password" type="password" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>re-password</th>
				<%-- \为转义符号 --%>
				<td><input name="rpwd" type="password" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#password\']'" /></td>
			</tr>
		</table>
	</form>

</div>