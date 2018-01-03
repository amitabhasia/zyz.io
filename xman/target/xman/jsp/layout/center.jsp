<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
    /**
     *添加tab
     */
    function addTab(node) {
        var t = $('#layout_center_tabs');

        // 判断tab是否已经存在
        if (t.tabs('exists', node.text)) {
            // 如果已经存在 则选中tab
            t.tabs('select', node.text);
        } else {
            //　如果不存在 则新建一个tab
            t.tabs('add', {
                title : node.text,
                href : node.attributes.url,
                closable : true,
            });
        }
    }
</script>
<div id="layout_center_tabs" class="easyui-tabs" data-options="fit:true,border:false">
	<div title="お知らせ案内"></div>
</div>