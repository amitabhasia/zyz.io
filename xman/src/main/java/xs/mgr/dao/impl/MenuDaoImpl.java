package xs.mgr.dao.impl;

import org.springframework.stereotype.Repository;

import xs.mgr.dao.MenuDaoI;
import xs.mgr.model.SysMenu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<SysMenu> implements MenuDaoI {

}
