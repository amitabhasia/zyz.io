package xs.mgr.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xs.mgr.dao.UserDaoI;
import xs.mgr.dao.impl.UserDaoExtendsFromBase;
import xs.mgr.model.SysUser;
import xs.mgr.pageModel.User;
import xs.mgr.service.UserServiceI;
import xs.mgr.util.Encrypt;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDaoI userDao;

    // 如果此处希望使用userDaoI的接口来定义
    // 那么需要接口UserDaoI继承接口BaseDaoI 并代入泛型类<SysUser>
    // 而且需要实现类UserDaoImpl继承实现类BaseDaoImpl 并代入泛型 <SysUser>
    @Autowired
    private UserDaoExtendsFromBase userDaoExtendsFormBase;

    @Override
    public void test() {

        logger.info("userService TEST");
    }

    @Override
    public Serializable save(SysUser t) {

        return userDao.save(t);
    }

    @Override
    public void save(String username, String password) {

        SysUser t = new SysUser();

        t.setId(UUID.randomUUID().toString());
        t.setUsername(username);
        t.setPassword(password);
        t.setCreatedatetime(new Date());

        // 事务挂在servcie层的方法上 userDao的数据插入操作在service层save方法全部执行完毕返回action的时候执行
        // 所以此处即便userDao会返回数据库异常 也无法在此捕获
        try {
            userDao.save(t);
            // userDaoExtendsFormBase.save(t);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Serializable save(User u) {

        SysUser t = new SysUser();

        BeanUtils.copyProperties(u, t);

        t.setId(UUID.randomUUID().toString());
        // 静态方法的调用 ：类名.方法名
        t.setPassword(Encrypt.e(u.getPassword()));
        t.setCreatedatetime(new Date());

        return userDao.save(t);
    }

    @Override
    public User login(User u) {

        // 字符串拼接的方式拼出Hql语句
        String hql = "from SysUser t where t.username = '" + u.getUsername() + "'" + " and t.password = '"
                + Encrypt.e(u.getPassword()) + "'";

        // 和dao有关的用TModel
        SysUser t = userDao.get(hql);

        // 字符串用使用占位符，用参数数组替换占位符的方式
        String hql2 = "from SysUser t where t.username = ? and t.password = ?";

        // 数组的初始化用花括号
        String[] params2 = new String[] { u.getUsername(), Encrypt.e(u.getPassword()) };

        t = userDao.get(hql2, params2);

        // 以Hibernate推荐的冒号：的形式拼接hql字符串 并用map对其进行替换赋值
        String hql3 = "from SysUser t where t.username = :username and t.password = :password";

        Map<String, Object> params3 = new HashMap<String, Object>();
        params3.put("username", u.getUsername());
        params3.put("password", Encrypt.e(u.getPassword()));

        t = userDao.get(hql3, params3);
        if (t != null) {
            // 和Action有关的用pageModel
            return u;
        } else {
            return null;
        }
    }
}
