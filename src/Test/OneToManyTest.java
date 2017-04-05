import oneToMany.Album;
import oneToMany.Group;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utill.HibernateUtil;

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
            log.info("start save " + OneToManyTest.log);
            Session session = HibernateUtil.getHibernateUtil().getSession();
            transaction = session.beginTransaction();
            Group group = new Group("Metallica", "Metal");
            Album album = new Album(null, "Master of puppets", group);
            Album secondAlbum = new Album(null, "Metallica", group);
            group.getAlbumSet().add(album);
            group.getAlbumSet().add(secondAlbum);
            album.setGroup(group);
            session.saveOrUpdate(group);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("error save " + OneToManyTest.class);
            transaction.rollback();
        }

    }
}
