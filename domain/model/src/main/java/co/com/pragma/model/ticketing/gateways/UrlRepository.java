package co.com.pragma.model.ticketing.gateways;

import co.com.pragma.model.ticketing.Url;

public interface UrlRepository {
    Url saveUrl(Url url);
}
