package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.ViewMapper;
import co.com.pragma.jpa.repository.JPAViewRepository;
import co.com.pragma.model.ticketing.View;
import co.com.pragma.model.ticketing.config.ErrorCode;
import co.com.pragma.model.ticketing.config.PragmaException;
import co.com.pragma.model.ticketing.gateways.ViewRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.function.Function;
@Repository
public class JPARepositoryViewAdapter extends AdapterOperations<View, ViewEntity, Long, JPAViewRepository> implements ViewRepository {

    public JPARepositoryViewAdapter(JPAViewRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, View.class));
    }

    @Override
    public View findByIdentifierView(String identifier) {
        ViewEntity viewEntity = repository.findByIdentifier(identifier);
        if(Objects.isNull(viewEntity)){
            throw new PragmaException(ErrorCode.B409008);
        }
        return ViewMapper.toDomain(viewEntity);
    }
}
