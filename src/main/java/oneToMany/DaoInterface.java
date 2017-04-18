package oneToMany;

import java.util.List;

/**
 * Created by Admin on 18.04.2017.
 */
public interface DaoInterface<T> {
    void saveOrUpdate(T t);

    T getObject(long id);

    void delete(T t);

    List<T> getAll(T t);

    void addAlbumInGroup(String string, T entity);
}
