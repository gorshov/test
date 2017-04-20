package oneToMany;

import oneToMany.dao.DaoInterface;
import oneToMany.entity.Album;
import oneToMany.entity.Group;
import oneToMany.service.ServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Admin on 20.04.2017.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.info(Main.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("my-config.xml");
        ServiceInterface<Group> groupService = (ServiceInterface<Group>) context.getBean("groupService");
        ServiceInterface<Album> albumService = context.getBean("groupService", ServiceInterface.class);
        Group group = new Group("DEATH", "METAL");
        Album album = new Album("FIRST", group);
        Album album1 = new Album("SECOND", group);
        Album album2 = new Album("THIRD", group);
        /*group.getAlbumSet().add(album);
        group.getAlbumSet().add(album1);
        group.getAlbumSet().add(album2);*/
        log.info(group);
        /*groupService.saveOrUpdate(group);*/
        albumService.saveOrUpdate(album);
        /*Group group1 = groupService.get(Group.class, 3l);*/
        /*log.info(group1);*/
    }
}
