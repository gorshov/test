package oneToMany.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 18.04.2017.
 */
public interface DaoInterface<T> {
    void saveOrUpdate(T t);

    void update(T t);

    T get(Class clas, Serializable id);

    void delete(T t);

    List<T> getAll(T t);
}
