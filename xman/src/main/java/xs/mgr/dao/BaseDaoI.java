package xs.mgr.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

// 在创建接口时定义泛型 利用java1.5的泛型
// 该接口在被实现时代入需要 处理的泛型类 比如SysUser SysMenu
// 代入什么类 就是什么类的DAO
public interface BaseDaoI<T> {

    // public Serializable save(Object o);
    public Serializable save(T t);

    // 查询一条数据 不带参数的写法 （如带参数则用下面的方法）
    public T get(String hql);

    // 查询一条数据 一般的做法
    public T get(String hql, Object[] params);

    // 查询一条数据 Hibernate的推荐方式
    public T get(String hql, Map<String, Object> params);

    // 查询多条数据 不带参数的写法
    public List<T> find(String hql);

    // 查询多条数据 带参数的写法
    public List<T> find(String hql, Map<String, Object> params);

    // 分页查询多条数据 不带参数的写法
    public List<T> find(String hql, int page, int rows);

    // 分页查询多条数据 带参数的写法
    public List<T> find(String hql, int page, int rows, Map<String, Object> params);

    // 查询数据的记录数 不带参数的写法
    public long count(String hql);

    // 查询数据的记录数 带参数的写法
    public long count(String hql, Map<String, Object> params);

    // 修改数据
    public void update(T t);

    // 保存或修改数据
    public void saveOrUpdate(T t);

    // 删除数据
    public void delete(T t);

}
