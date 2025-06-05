package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.TicketingEntity;
import co.com.pragma.jpa.mapper.TicketingMapper;
import co.com.pragma.jpa.repository.JPATicketingRepository;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.model.ticketing.Ticketing;
import co.com.pragma.model.ticketing.config.ErrorCode;
import co.com.pragma.model.ticketing.config.PragmaException;
import co.com.pragma.model.ticketing.gateways.TicketingRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class JPARepositoryTicketingAdapter extends AdapterOperations<Ticketing, TicketingEntity, Long, JPATicketingRepository>
    implements TicketingRepository
{

    public JPARepositoryTicketingAdapter(JPATicketingRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Ticketing.class));
    }


    @Override
    public Ticketing saveTicketing(Ticketing ticketing, Long viewId, Long urlId) {
        TicketingEntity ticketingEntity = saveData(TicketingMapper.toEntity(ticketing, viewId, urlId));
        if (Objects.isNull(ticketingEntity)) {
            throw new PragmaException(ErrorCode.B409012);
        }
        return TicketingMapper.toDomain(ticketingEntity, ticketing.getIdentifier(), ticketing.getUrl());
    }
}
