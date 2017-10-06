package dao.interfaces;

public interface CrudDao<E, K> {
    Long create(E entity);

    E read(K id);

    Long update(E entity);

    Long delete(K id);
}
