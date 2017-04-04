package MyMain;

import entity.Artist;
import entity.Website;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import utill.HibernateUtil;


/**
 * Created by Admin on 04.04.2017.
 */


public class MyMain {
    public static HibernateUtil util = null;
    public static Transaction transaction = null;
    private static Logger log = Logger.getLogger(MyMain.class);

    public static void main(String[] args) {

        log.info("start hibernate test" + MyMain.class);
        Artist artist = new Artist(null, "Bill", "Metall");

        Website website = new Website(null, "mypage" + artist.getName(), artist);

        try {
            log.info("start saveOrUpdate");
            Session session = HibernateUtil.getHibernateUtil().getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(artist);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("error" + MyMain.class + " " + e + MyMain.log);
            transaction.rollback();
        }
        try {
            log.info("start get");
            Session session = HibernateUtil.getHibernateUtil().getSession();
            transaction = session.beginTransaction();
            Long id = 6l;
            artist = (Artist) session.get(Artist.class, id);
            log.info("artist name " + artist.getName());
            System.out.println("artist name " + artist.getName());
            session.flush();
            transaction.commit();

        } catch (HibernateException e) {
            log.error("error" + MyMain.class + " " + e + MyMain.log);
            transaction.rollback();
        }

    }
}
