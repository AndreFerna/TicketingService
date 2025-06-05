package co.com.pragma.model.ticketing;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Url {
    private Long id;
    private String value;
    private boolean status;
}
