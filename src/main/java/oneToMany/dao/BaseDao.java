package oneToMany.dao;

import org.apache.log4j.Logger;
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
    private Session session;

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }

    public void saveOrUpdate(T t) {
        log.info("Start saveOrUpdate method with param " + t);
        session.saveOrUpdate(t);
        log.info("Save or update " + t);
        session.flush();
    }

    public void update(T t) {
        log.info("Start update method with param " + t);
        session.update(t);
        log.info("update " + t);
        session.flush();
    }

    public T get(Class clas, Serializable id) {
        log.info("Get " + clas + " " + id);
        return (T) session.get(clas, id);
    }

    public void delete(T t) {
        log.info("Start delete method with param " + t);
        session.delete(t);
        log.info("Delete " + t);
        session.flush();
    }

    public List<T> getAll(T t) {
        return null;
    }
}
