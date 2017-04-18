import oneToMany.Album;
import oneToMany.Dao;
import oneToMany.Group;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import utill.HibernateUtil;

import java.util.List;

/**
 * Created by Admin on 05.04.2017.
 */
public class OneToManyTest {
    public static HibernateUtil util = null;
    public static Transaction transaction = null;
    private static Logger log = Logger.getLogger(OneToOneTest.class);

    @Test
    public void springAspectTest() {
        Dao dao = new Dao();
        Session session = OneToManyTest.getSession();
        Group group = new Group("Group", "Ganre");
        Album album = new Album("Album 1", group);
        group.getAlbumSet().add(album);
        Album album1 = new Album("Album 2", group);
        group.getAlbumSet().add(album1);

        List<Group> groups = dao.getAll(group);

    }

    @Test
    public void selectOrUpdateTest() {
        try {
            log.info("start save ");
            Session session = OneToManyTest.getSession();
            transaction = session.beginTransaction();
            Group group = new Group("Metallica", "Metal");
            Album album = new Album(null, "Master of puppets", group);
            Album secondAlbum = new Album(null, "Metallica", group);
            Album thirdAlbum = new Album(null, "And Justice for All", group);
            Album fourthAlbum = new Album(null, "Death Magnetic", group);
            Album fifthAlbum = new Album(null, "Kill 'Em All", group);
            group.getAlbumSet().add(album);
            group.getAlbumSet().add(secondAlbum);
            group.getAlbumSet().add(thirdAlbum);
            group.getAlbumSet().add(fourthAlbum);
            group.getAlbumSet().add(fifthAlbum);
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
    public void paginationTest() {
        try {
            log.info("pagination test : ");
            Session session = OneToManyTest.getSession();
            Criteria criteria = session.createCriteria(Album.class);
            criteria.setFirstResult(0);
            criteria.setMaxResults(3);
            List result = criteria.list();
            log.info("FIRST RESULT" + result);
            criteria.setFirstResult(3);
            criteria.setMaxResults(5);
            List secondResult = criteria.list();
            log.info(secondResult);
        } catch (HibernateException e) {
            log.error("error pagination " + e);
            transaction.rollback();
        }
    }

    @Test
    public void deleteTest() {
        Session session = OneToManyTest.getSession();
        try {
            log.info("start delete method ");
            transaction = session.beginTransaction();
            Group group = (Group) session.load(Group.class, 1l);
            session.delete(group);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("error in delete Test " + e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Test
    public void transactionTest() {
        Session session = OneToManyTest.getSession();
        try {
            transaction = session.beginTransaction();
            Group group = new Group("Test group", "folk");
            log.info(group);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }


    public static Session getSession() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        return session;
    }


}
