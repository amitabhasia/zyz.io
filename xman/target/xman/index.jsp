<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="jslib/jquery-3.2.1.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.5.2/locale/easyui-lang-jp.js"></script>
<link rel="stylesheet" href="jslib/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.5.2/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="jslib/extEasyUI.js"></script>
<script type="text/javascript" src="jslib/extJquery.js"></script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height:50px"></div>
	<div data-options="region:'south',split:false" style="height:20px;"></div>
	<div data-options="region:'east',split:true" title="コンテキスト" style="width:200px;"></div>
	<div data-options="region:'west',split:false" style="width:200px;">
		<jsp:include page="jsp/layout/west.jsp"></jsp:include>
	</div>
	<div data-options="region:'center',title:'㈱Xサービスへようこそ'">
		<jsp:include page="jsp/layout/center.jsp"></jsp:include>
	</div>


	<%--用户登录以及注册的代码--%>
<%--			<jsp:include page="jsp/user/login.jsp"></jsp:include>--%>
<%--			<jsp:include page="jsp/user/register.jsp"></jsp:include>--%>

</body>
</html>
