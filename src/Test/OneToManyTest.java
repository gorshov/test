import oneToMany.Album;
import oneToMany.Group;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.junit.Assert;
import org.junit.Test;
import utill.HibernateUtil;

import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 05.04.2017.
 */
public class OneToManyTest {
    public static HibernateUtil util = null;
    public static Transaction transaction = null;
    private static Logger log = Logger.getLogger(OneToOneTest.class);


    @Test
    public void selectOrUpdateTest() {
        try {
            log.info("start save ");
            Session session = OneToManyTest.getSession();
            transaction = session.beginTransaction();
            Group group = new Group("Metallica", "Metal");
            Album album = new Album(null, "Master of puppets", group);
            Album secondAlbum = new Album(null, "Metallica", group);
            group.getAlbumSet().add(album);
            group.getAlbumSet().add(secondAlbum);
            album.setGroup(group);
            session.saveOrUpdate(group);
            transaction.commit();
            Criteria criteria = session.createCriteria(Group.class);
            List result = criteria.list();
            Group testGroup = (Group) result.get(0);

            Assert.assertNotNull("Not Null", result);
            Assert.assertEquals(1l, result.size());
            Assert.assertEquals("Metallica", testGroup.getName());
        } catch (HibernateException e) {
            log.error("error save " + OneToManyTest.class);
            transaction.rollback();
        }

    }

    @Test
    public void getTest() {
        try {
            log.info("start get method ");
            Session session = OneToManyTest.getSession();
            transaction = session.beginTransaction();
            Group group = (Group) session.get(Group.class, 1l);
            /*Criteria criteria = session.createCriteria(Group.class);*/
            transaction.commit();
            Assert.assertEquals("Metallica", group.getName());
            Assert.assertEquals("Metal", group.getGenre());

        } catch (HibernateException e) {
            log.error("error in getTest " + e);
            transaction.rollback();
        }
    }

    @Test
    public void loadTest() {
        try {
            log.info("start load method ");
            Session session = OneToManyTest.getSession();
            transaction = session.beginTransaction();
            Group group = (Group) session.load(Group.class, 1l);
            transaction.commit();
            Assert.assertEquals("Metallica", group.getName());
            Assert.assertEquals("Metal", group.getGenre());
        } catch (HibernateException e) {
            log.error("error in loadTest " + e);
            transaction.rollback();
        }
    }

    @Test
    public void deleteTest() {
        try {
            log.info("start delete method ");
            Session session = OneToManyTest.getSession();
            transaction = session.beginTransaction();
            Group group = (Group) session.load(Group.class, 1l);
            session.delete(group);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("error in delete Test " + e);
            transaction.rollback();
        }
    }

    public static Session getSession() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        return session;
    }

}
