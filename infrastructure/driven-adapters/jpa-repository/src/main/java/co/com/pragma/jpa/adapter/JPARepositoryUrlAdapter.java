package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.UrlEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.UrlMapper;
import co.com.pragma.jpa.repository.JPAUrlRepository;
import co.com.pragma.model.ticketing.Url;
import co.com.pragma.model.ticketing.config.ErrorCode;
import co.com.pragma.model.ticketing.config.PragmaException;
import co.com.pragma.model.ticketing.gateways.UrlRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class JPARepositoryUrlAdapter extends AdapterOperations<Url, UrlEntity, Long, JPAUrlRepository>
    implements UrlRepository
{
    protected JPARepositoryUrlAdapter(JPAUrlRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Url.class));
    }

    @Override
    public Url saveUrl(Url url) {
        UrlEntity urlEntity = saveData(UrlMapper.toEntity(url));
        if(Objects.isNull(urlEntity)){
            throw new PragmaException(ErrorCode.B409013);
        }
        return UrlMapper.toDomain(urlEntity);
    }
}
