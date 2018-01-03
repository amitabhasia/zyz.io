package xs.mgr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xs.com.utility.BeanUtils;
import xs.mgr.dao.MenuDaoI;
import xs.mgr.model.SysMenu;
import xs.mgr.pageModel.Menu;
import xs.mgr.service.MenuServiceI;

@Service("menuService")
public class MenuServiceImpl implements MenuServiceI {

    // @Autowired
    // private BaseDaoI<SysMenu> menuDao;
    @Autowired
    private MenuDaoI menuDao;

    @Override
    public List<Menu> getTreeNode(String pid) {

        List<Menu> listMenu = new ArrayList<Menu>();

        String hql = null;
        Map<String, Object> params = new HashMap<String, Object>();

        if (pid == null || "".equals(pid)) {
            hql = "from SysMenu m where m.sysMenu is null";
        } else {
            // hql = "from SysMenu t where t.sysMenu.id ='" + pid + "'";
            hql = "from SysMenu t where t.sysMenu.id = :pid";
            params.put("pid", pid);
        }
        List<SysMenu> listTmenu = menuDao.find(hql, params);

        if (listTmenu != null && listTmenu.size() > 0) {
            for (SysMenu t : listTmenu) {
                Menu m = new Menu();

                // 类的属性的复制
                BeanUtils.copyProperties(t, m);

                // 判断节点下是否有子节点
                if (t.getSysMenus() != null && t.getSysMenus().size() > 0) {

                    // 当节点有子节点时，将状态设置为closed 画面图标显示为关闭状态的文件夹
                    m.setState("closed");
                } else {
                    // 当节点下没有节点时，将状态设置为open 画面图片显示为文件
                    m.setState("open");
                }

                listMenu.add(m);

            }
        }

        return listMenu;
    }

    @Override
    public List<Menu> getWholeTree() {

        List<Menu> listMenu = new ArrayList<Menu>();

        List<SysMenu> listTmenu = menuDao.find("from SysMenu t ");

        if (listTmenu != null && listTmenu.size() > 0) {
            for (SysMenu t : listTmenu) {
                Menu m = new Menu();

                // 类的属性的复制
                BeanUtils.copyProperties(t, m);

                // 为了在前台用扩展的JS拼装 非异步menuTree 此处需要设置父节点ID
                if (t.getSysMenu() != null) {
                    m.setPid(t.getSysMenu().getId());
                }

                // // 无论当节点下没有节点时，将状态设置为open 默认为open所以不需要设置
                // m.setState("open");

                // id text state 意外的属性都需要放在attributes的Map里面
                Map<String, Object> att = new HashMap<String, Object>();
                att.put("url", t.getUrl());
                att.put("iconCls", t.getIconCls());
                m.setAttributes(att);

                // 将menu存入List
                listMenu.add(m);
            }
        }

        return listMenu;
    }

}
