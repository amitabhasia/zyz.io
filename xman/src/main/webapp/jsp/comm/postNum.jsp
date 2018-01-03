<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>郵便番号・住所検索</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<jsp:include page="/jsp/comm/incHeader.jsp"></jsp:include>
</head>
<body>
<script type="text/javascript">
var pageContextPath = '${pageContext.request.contextPath}';
    
$(function(){
    $('#comm_postNum_datagrid').datagrid({
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
            field : 'empCode',
            title : '勤務コード',
            checkbox : true,
            //如果不设置宽度，datagrid的渲染显示时间将会受到很大负面影响
            width : 80,
            sortable : true
        },{
            field : 'empPost',
            title : '郵便番号',
            width : 70,
            sortable : true
        }, {
            field : 'empAddress',
            title : '住所',
            width : 300,
            formatter : function(value, rowData, rowIndex) {
                return '<span title="' +　'〒'　+ rowData.empPost + ' ' + value + '">' + value + '</span>';
            }
        } ,{
			title : '詳細',
			field : 'detailAction',
			width : '60',
			formatter : function(value, row) {
				var	str = formatString('<img class="icon-large-smartart" title="詳細" onclick="showFun(\'{0}\');"/>', row.empPost);
				return str;
			}
		},{
			title : '確定',
			field : 'confirmAction',
			width : '60',
			formatter : function(value, row) {
				var str = formatString('<img class="icon-ok" title="確定" onclick="confirmFun(\'{0}\');"/>', row.empPost);
				return str;
			}
		} ] ]
    });
});    

    function searchFun() {
        var objForm = serializeObject($('#comm_postNum_searchForm'));
        $('#comm_postNum_datagrid').datagrid('load',objForm);
    }
    
    function clearFun() {
        $('#comm_postNum_searchForm input').val('');
        $('#comm_postNum_datagrid').datagrid('load',{});
    }
    
    function showFun(arg) {
        var row = $('#comm_postNum_datagrid').datagrid('getSelected');
        $('#comm_postNumDetail_editForm').form('load',row);
        $('#comm_postNumDetail_editDialog').dialog('open');
    }
    
    function confirmFun(arg) {
        alert(arg);
        
        var row = $('#comm_postNum_datagrid').datagrid('getSelected');
        var postInfo = new Object();
        postInfo.empPost = row.empPost;
        postInfo.empAddress = row.empAddress;
        alert(postInfo.empPost + postInfo.empAddress);
        window.returnValue = postInfo;
    	window.close();
    }
</script>
<div id="comm_postNum_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'検索条件',iconCls:'icon-search',border:false" style="height:65px">
		<form id="comm_postNum_searchForm" method="post">
			<table>
				<tr>
					<td>郵便番号</td>
					<td><input name="empPost" type="text"></input></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btnSearch" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onClick="searchFun();">検索</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="btnClear" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onClick="clearFun();">クリア</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:'検索結果',iconCls:'icon-save',border:false">
		<table id="comm_postNum_datagrid" data-options="fit:true,border:false"></table>
	</div>
</div>
	<jsp:include page="postNumDetail.jsp"></jsp:include>
</body>
</html>
