package xs.mgr.dao.impl;

import org.springframework.stereotype.Repository;

import xs.mgr.dao.UserDaoI;
import xs.mgr.model.SysUser;


//先继承 后实现
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<SysUser> implements UserDaoI  {
}
