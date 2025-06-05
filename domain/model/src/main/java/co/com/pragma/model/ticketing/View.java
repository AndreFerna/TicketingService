package co.com.pragma.model.ticketing;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class View {
    private Long id;
    private String url;
    private String date;
    private Boolean free;
    private Long idTournament;
    private Long aforo;
    private String identifier;
    private BigDecimal ticketPrice;
}

