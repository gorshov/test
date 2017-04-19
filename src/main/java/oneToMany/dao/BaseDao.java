package oneToMany.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    

    private Session createSession() {
        return sessionFactory.openSession();
    }

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(T t) {
        log.info("Start saveOrUpdate method with param " + t);
        Session session = createSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        log.info("Save or update " + t);
    }

    public void update(T t) {
        log.info("Start update method with param " + t);
        Session session = createSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        log.info("update " + t);
    }

    public T get(Class clas, Serializable id) {
        log.info("Get " + clas + " " + id);
        return (T) createSession().get(clas, id);
    }

    public void delete(T t) {
        log.info("Start delete method with param " + t);
        Session session = createSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        log.info("Delete " + t);
    }

    public List<T> getAll(T t) {
        return null;
    }
}
