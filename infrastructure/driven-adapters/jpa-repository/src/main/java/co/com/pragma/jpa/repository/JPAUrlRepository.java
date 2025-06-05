package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.UrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAUrlRepository extends CrudRepository<UrlEntity, Long>, QueryByExampleExecutor<UrlEntity> {
}
