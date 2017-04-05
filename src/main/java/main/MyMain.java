package main;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
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

    }
}
