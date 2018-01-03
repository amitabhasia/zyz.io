<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/jsp/comm/incHeader.jsp"></jsp:include>
<script type="text/javascript">
    var pageContextPath = '${pageContext.request.contextPath}';
    
	$(function(){
	    $('#emp_basicInfo_datagrid').datagrid({
	        url : pageContextPath + '/employeeAction!dataGrid.action',
	        pagination : true,
	        checkOnSelect : true,
	        singleSelect : true,
	        selectOnCheck : true,
	        idField : 'empCode',
	        //fitColumns : true,
	        //pageSize : 5,
	        //pageList : [ 5, 10, 20, 30, 40, 50 ],
	        //rownumbers : true,
	        //pagePosition : 'top',
	        sortName : 'empCode',
	        sortOrder : 'asc',
	        frozenColumns : [ [ {
	            field : '',
	            //title : 'コード',
	            checkbox : true,
	            //如果不设置宽度，datagrid的渲染显示时间将会受到很大负面影响
	            //width : 80,
	            //sortable : true
	        }, {
	            field : 'empCode',
	            title : '勤務コード',
	            //checkbox : true,
	            //如果不设置宽度，datagrid的渲染显示时间将会受到很大负面影响
	            width : 80,
	            sortable : true
	        }, {
	            field : 'empName',
	            title : '従業員氏名',
	            width : 80,
	            sortable : true
	        } ] ],
	        columns : [ [ {
	            field : 'empNameKata',
	            title : '氏名(カタカナ)',
	            width : 120
	        }, {
	            field : 'empNameRoma',
	            title : '氏名(ローマ)',
	            width : 120
	        }, {
	            field : 'empGender',
	            title : '性別',
	            width : 40
	        }, {
	            field : 'empBirthdate',
	            title : '生年月日',
	            width : 100,
	            sortable : true
	        }, {
	            field : 'empPhone',
	            title : '電話番号',
	            width : 90
	        }, {
	            field : 'empMail',
	            title : 'メールアドレス',
	            width : 170
	        }, {
	            field : 'empPost',
	            title : '郵便番号',
	            width : 70,
	            sortable : true
	        }, {
	            field : 'empAddress',
	            title : '住所',
	            width : 200,
	            formatter : function(value, rowData, rowIndex) {
	                return '<span title="' +　'〒'　+ rowData.empPost + ' ' + value + '">' + value + '</span>';
	            }
	        }, {
	            field : 'empPassport',
	            title : 'パスポート番号',
	            width : 100
	        }, {
	            field : 'empMynumber',
	            title : '個人番号',
	            width : 100
	        }, {
	            field : 'empPhoto',
	            title : '個人写真',
	            width : 100
	        } ] ],
	        toolbar : [ {
	            text : '新規',
	            iconCls : 'icon-add',
	            handler : function() {
	                $('#emp_basicInfo_editDialog').dialog('open');
	            }
	        }, '-', {
	            text : '修正',
	            iconCls : 'icon-edit',
	            handler : function() {
	                var row = $('#emp_basicInfo_datagrid').datagrid('getSelected');
	           		if (row) {
	         			//alert(row.empCode); 
	         			
	        			parent.$.messager.progress({
	        				text : 'データ読み込み中・・・'
	        			});
	        			
	        			$.post(
	        			    pageContextPath + '/employeeAction!getByID.action', 
	        			    {
	        					empCode : row.empCode,
	        				}, 
	        				function(result) {
	        				    //alert(result.empName);
		        				if (result.empCode != undefined) {
		        				    $('#emp_basicInfo_editForm').form('load',result);
		        				}
	        					parent.$.messager.progress('close');
	         					$('#emp_basicInfo_editDialog').dialog('open');
	        				}, 
	        				'json');
	           		} else {
						alert('修正対象レコードを一件選んでください。');
	           		}
	            }
	        } , '-', {
	            text : '削除',
	            iconCls : 'icon-remove',
	            handler : function() {
	                alert('削除');
	            }
	        }, '-', {
	            text : 'リフレッシュ',
	            iconCls : 'icon-reload',
	            handler : function() {
	                searchFun();
	            }
	        }]
	    });
	});    

    function searchFun() {
        var objForm = serializeObject($('#emp_basicInfo_searchForm'));
        $('#emp_basicInfo_datagrid').datagrid('load',objForm);
        
    }
    
    function clearFun() {
        $('#emp_basicInfo_searchForm input').val('');
        $('#emp_basicInfo_datagrid').datagrid('load',{});
        
    }
</script>
</head>
<body>
<div id="emp_basicInfo_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'検索条件',iconCls:'icon-search',border:false" style="height:65px">
		<form id="emp_basicInfo_searchForm" method="post">
			<table>
				<tr>
					<td>勤務コード</td>
					<td><input name="empCode" type="text"></input></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;氏名 (カタカナ・ローマ字検索可)</td>
					<td><input name="empName" type="text"></input></td>
					<%--					<td>&nbsp;&nbsp;&nbsp;&nbsp;電話番号</td>--%>
					<%--					<td><input name="empPhone" type="text"></input>--%>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btnSearch" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onClick="searchFun();">検索</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btnClear" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onClick="clearFun();">クリア</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:'検索結果',iconCls:'icon-save',border:false">
		<table id="emp_basicInfo_datagrid" data-options="fit:true,border:false"></table>
	</div>
</div>
<%--<jsp:include page="basicInfoEdit.jsp"></jsp:include>
--%></body>
</html>