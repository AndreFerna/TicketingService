package co.com.pragma.model.ticketing.gateways;

import co.com.pragma.model.ticketing.Ticketing;

public interface TicketingRepository {
    Ticketing saveTicketing(Ticketing ticketing, Long viewId, Long urlId);
}
