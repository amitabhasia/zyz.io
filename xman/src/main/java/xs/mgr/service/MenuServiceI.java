package xs.mgr.service;

import java.util.List;

import xs.mgr.pageModel.Menu;

public interface MenuServiceI {

    public List<Menu> getTreeNode(String pid);

    public List<Menu> getWholeTree();

}
