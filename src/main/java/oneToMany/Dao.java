package oneToMany;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import utill.HibernateUtil;

import java.util.List;

/**
 * Created by Admin on 18.04.2017.
 */


@Component
@Aspect
public class Dao implements DaoInterface<Group> {
    private static Logger log = Logger.getLogger(Dao.class);

    public Dao() {
    }


    public void saveOrUpdate(Group group) {
        log.info("start save");
        Session session = HibernateUtil.getHibernateUtil().getSession();
        Transaction tresaction = session.beginTransaction();
        session.saveOrUpdate(group);
        tresaction.commit();
        session.close();
        log.info("finished save");
    }

    public Group getObject(long id) {
        return null;
    }

    public void delete(Group group) {

    }

    @Pointcut("execution(* oneToMany.Dao.saveOrUpdate())")
    public List getAll(Group group) {
        log.info("start getAll");
        Session session = HibernateUtil.getHibernateUtil().getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Group.class);
        List result = criteria.list();
        transaction.commit();
        session.close();
        log.info("finished getAll");
        return result;
    }

    public void addAlbumInGroup(String string, Group entity) {
        Album album = new Album(string, entity);
        entity.getAlbumSet().add(album);
    }
}
