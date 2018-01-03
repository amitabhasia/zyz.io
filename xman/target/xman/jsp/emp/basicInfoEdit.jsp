<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/jsp/comm/incHeader.jsp"></jsp:include>
<script type="text/javascript">
    //追加对话框的初始化 初始状态为关闭 注册按钮绑定提交函数
    $('#emp_basicInfo_editDialog').dialog({
        title : '従業員基本情報追加・編集',
        closable : true,
        modal : true,
        buttons : [ {
            text : '保存',
            iconCls : 'icon-save',
            handler : function() {
                $('#emp_basicInfo_editForm').form('submit');
                $('#emp_basicInfo_editDialog').dialog('close');
            }
        } ]
    }).dialog('close');

    $('#emp_basicInfo_editForm').form({
        url : pageContextPath + '/employeeAction!saveOrUpdate.action',
        success : function(data) {
            var obj = $.parseJSON(data);

            if (obj.success) {
                $('#emp_basicInfo_editDialog').dialog('close');
                searchFun();
            }

            $.messager.show({
                title : '処理結果',
                msg : obj.message
            });
        }
    });

    function searchPostNum() {
        var url = 'jsp/comm/postNum.jsp';
        var args = "郵便番号検索";
        //var option = "dialogWidth:800px;dialogHeight:600px;status:no;help:no";
        //returnVal = window.showModalDialog(url, this, option);

        if (window.showModalDialog) {
            window.showModalDialog(url, args,
                    "dialogWidth:600px;dialogHeight:600px");
        } else {
            window.open(url,args,
                    "height=600px,width=600px,toolbar=no,directories=no,status=no, menubar=no,scrollbars=no,resizable=no ,modal=yes");
        }
        //document.getElementById('foo').textContent = r;
        //alert(r);
    }
</script>
</head>
<body>
<div id="emp_basicInfo_editDialog" class="easyui-dialog">
	<form id="emp_basicInfo_editForm" method="post">
		<table>
			<tr>
				<td>勤務コード</td>
				<td><input name="empCode" readonly="readonly" class="easyui-validatebox" data-options="required:true" /></td>
				<td>従業員氏名</td>
				<td><input name="empName" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>氏名(カタカナ)</td>
				<td><input name="empNameKata" class="easyui-validatebox" data-options="required:true" /></td>
				<td>氏名(ローマ)</td>
				<td><input name="empNameRoma" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><input name="empGender" class="easyui-validatebox" data-options="required:true" /></td>
				<td>生年月日</td>
				<td><input name="empBirthdate" type="text" class="easyui-datebox" required="required" /></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><input name="empPhone" class="easyui-validatebox" data-options="required:true" /></td>
				<td>メールアドレス</td>
				<td><input name="empMail" class="easyui-validatebox" data-options="required:true,validType:'email'" /></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><input name="empPost" class="easyui-validatebox" data-options="required:true" /> <input type="button" onclick="searchPostNum();" class="icon-search" />
				</td>
				<td>住所</td>
				<td><input name="empAddress" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td colspan="4">※1、以上すべての項目は記入必須となること</td>
			</tr>
			<tr>
				<td colspan="4">※2、在留カード写しのアプロード機能は次期バージョンで対応すること</td>
			</tr>
			<tr>
				<td colspan="4">※3、勤務コードの自動採番仕様は別途確認後に実装すること</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>