package xs.mgr.dao;

import xs.mgr.model.SysUser;

//这种与BaseDaoI分开设置Dao类的写法为标准写法
//方便后期扩展及维护
public interface UserDaoI extends BaseDaoI<SysUser>{

}
