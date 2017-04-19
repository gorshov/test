package oneToMany.service;

import java.io.Serializable;

/**
 * Created by Admin on 19.04.2017.
 */
public interface ServiceInterface<T> {
    void saveOrUpdate(T t);

    void update(T t);

    T get(Class clas, Serializable id);

    void delete(T t);
}
