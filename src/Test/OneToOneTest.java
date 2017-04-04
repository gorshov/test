import entity.Artist;
import entity.Website;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import utill.HibernateUtil;

/**
 * Created by Admin on 04.04.2017.
 */
public class OneToOneTest {
    public static HibernateUtil util = null;
    public static Transaction transaction = null;
    private static Logger log = Logger.getLogger(OneToOneTest.class);
    Artist artist = new Artist(null, "Tim", "HardRock");

    Website website = new Website("mypage" + "." + artist.getName(), artist);


    @Test
    public void saveOrUpdate() {
        artist.setWebsite(website);
        try {
            log.info("start saveOrUpdate");
            Session session = HibernateUtil.getHibernateUtil().getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(artist);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("error" + OneToOneTest.class + " " + e + OneToOneTest.log);
            transaction.rollback();
        }

    }

    @Test
    public void getArtistTest() {
        try {
            log.info("start get");
            Session session = HibernateUtil.getHibernateUtil().getSession();
            transaction = session.beginTransaction();
            Long id = 3l;
            artist = (Artist) session.get(Artist.class, id);
            log.info("artist name " + artist.getName());
            transaction.commit();

        } catch (HibernateException e) {
            log.error("error" + OneToOneTest.class + " " + e + OneToOneTest.log);
            transaction.rollback();
        }
        Assert.assertEquals("Bill", artist.getName());
        Assert.assertEquals("Metall", artist.getGenre());
        long id = artist.getId();
        Assert.assertEquals("expected", 3l, id);
        Assert.assertNotNull("Not null", artist);
    }

    @Test
    public void deleteTest() {

        Session session = HibernateUtil.getHibernateUtil().getSession();
        transaction = session.beginTransaction();
        Artist artist = (Artist) session.get(Artist.class, 4l);
        session.delete(artist);
        transaction.commit();
    }


}
