package co.com.pragma.model.ticketing.gateways;

import co.com.pragma.model.ticketing.View;

public interface ViewRepository {
    View findByIdentifierView(String identifier);
}
