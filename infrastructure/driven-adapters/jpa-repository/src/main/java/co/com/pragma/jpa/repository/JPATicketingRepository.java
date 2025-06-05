package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.TicketingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPATicketingRepository extends CrudRepository<TicketingEntity, Long>, QueryByExampleExecutor<TicketingEntity> {
}
