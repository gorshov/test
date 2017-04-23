package oneToMany.dao;

import oneToMany.entity.Group;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 18.04.2017.
 */

@Repository
public class BaseDao<T> implements DaoInterface<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);

    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(T t) {
        log.info("Start saveOrUpdate method with param " + t);
        getSession().saveOrUpdate(t);
        log.info("Save or update " + t);
    }

    public void update(T t) {
        log.info("Start update method with param " + t);
        getSession().update(t);
        log.info("update " + t);
    }

    public T get(Class clas, Serializable id) {
        log.info("Get " + clas + " " + id);
        return (T) getSession().get(clas, id);
    }

    public void delete(T t) {
        log.info("Start delete method with param " + t);
        getSession().delete(t);
        log.info("Delete " + t);
    }

    public List<T> getAll(T t) {
        Criteria criteria = getSession().createCriteria(Group.class);
        List lst = criteria.list();
        return lst;
    }
}
