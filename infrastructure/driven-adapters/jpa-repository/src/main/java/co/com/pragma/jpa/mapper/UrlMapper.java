package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.UrlEntity;
import co.com.pragma.model.ticketing.Url;

public class UrlMapper {

    public static UrlEntity toEntity(Url url){
        return UrlEntity.builder()
                .value(url.getValue())
                .status(url.isStatus())
                .build();
    }

    public static Url toDomain(UrlEntity urlEntity){
        return Url.builder()
                .id(urlEntity.getId())
                .value(urlEntity.getValue())
                .status(urlEntity.isStatus())
                .build();
    }
}
