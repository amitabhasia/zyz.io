<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function() {
        /**
         *menuTree的初期化
         */
        $('#layout_west_menuTree').tree({
            //　异步树
            //url : '${pageContext.request.contextPath}/menuAction!getTreeNode.action',
            // 非异步树
            url : '${pageContext.request.contextPath}/menuAction!getWholeTree.action',
            parentField : 'pid',
            lines : true,
            onClick : function(node) {
                if ("" != node.attributes.url) {
                    addTab(node);
                }
            }
        });

    });
</script>

<div class="easyui-panel" data-options="title:'業務メニュー',border:false,fit:true">
	<div class="easyui-accordion" data-options="border:false,fit:true">
		<div title="従業員管理台帳" data-options="iconCls:'icon-save',selected:true">
			<ul id="layout_west_menuTree" class="easyui-tree"></ul>
		</div>
		<div title="給与管理台帳" data-options="iconCls:'icon-reload'"></div>
	</div>
</div>