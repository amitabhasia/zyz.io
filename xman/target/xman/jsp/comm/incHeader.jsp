<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript" src="<%=path%>/jslib/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=path%>/jslib/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/jslib/jquery-easyui-1.5.2/locale/easyui-lang-jp.js"></script>
<link rel="stylesheet" href="<%=path%>/jslib/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=path%>/jslib/jquery-easyui-1.5.2/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="<%=path%>/jslib/extEasyUI.js"></script>
<script type="text/javascript" src="<%=path%>/jslib/extJquery.js"></script>
