package spring.layer.template.domain.port.out.repository;

public interface BaseRepository<T> {

    T save(T entity);

    T delete(T entity);

    T update(T entity);
}
