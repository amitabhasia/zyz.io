package xs.mgr.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import xs.mgr.pageModel.Menu;
import xs.mgr.service.MenuServiceI;

import com.opensymphony.xwork2.ModelDriven;

@Action("menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {

    private Menu menu = new Menu();

    @Override
    public Menu getModel() {
        return menu;
    }

    // @Autowired 既可以直接写在属性上 也可以写在属性的setter上
    // 如果写在属性上 ，则Spring自动将其变成公有public来使用
    // 如果写在setter上，则属性依然为类内部私有private
    @Autowired
    private MenuServiceI menuService;

    /**
     * 异步树
     * 
     * 异步获取树节点
     */
    public void getTreeNode() {

        super.writeJson(menuService.getTreeNode(menu.getId()));

    }

    /**
     * 非异步树
     * 
     * 全体节点一次性抽出返回前台 在前台用JS拼装tree
     */
    public void getWholeTree() {

        super.writeJson(menuService.getWholeTree());
    }

}
