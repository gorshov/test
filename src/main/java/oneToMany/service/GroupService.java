package oneToMany.service;

import oneToMany.dao.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Admin on 18.04.2017.
 */
@Service

public class GroupService<T> implements ServiceInterface<T> {
    private Logger log = Logger.getLogger(GroupService.class);

    private BaseDao<T> baseDao;

    public void saveOrUpdate(T t) {
        baseDao.saveOrUpdate(t);
    }

    public void update(T t) {
        baseDao.update(t);
    }

    public T get(Class clas, Serializable id) {
        return baseDao.get(clas, id);
    }

    public void delete(T t) {
        baseDao.delete(t);
    }
}
