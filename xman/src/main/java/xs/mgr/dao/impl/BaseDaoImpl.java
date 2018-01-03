package xs.mgr.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xs.mgr.dao.BaseDaoI;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable save(T t) {
        return sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public T get(String hql) {

        // 查询用createQuery 创建Query之后 用Query.list()方法获取 结果集
        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        List<T> l = q.list();

        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T get(String hql, Object[] params) {

        // 查询用createQuery 创建Query之后 用Query.list()方法获取 结果集
        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        // 参数的设定
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }

        List<T> l = q.list();

        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T get(String hql, Map<String, Object> params) {

        // 查询用createQuery 创建Query之后 用Query.list()方法获取 结果集
        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        // Map的形式拼接hql
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }

        List<T> l = q.list();

        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<T> find(String hql) {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }

        return q.list();
    }

    @Override
    public List<T> find(String hql, int page, int rows) {

        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public List<T> find(String hql, int page, int rows, Map<String, Object> params) {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }

        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public long count(String hql) {

        hql = "select count(*) " + hql;

        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        return (long) q.uniqueResult();
    }

    @Override
    public long count(String hql, Map<String, Object> params) {

        hql = "select count(*) " + hql;

        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }

        return (long) q.uniqueResult();
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);

    }

    @Override
    public void saveOrUpdate(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);

    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);

    }

}
