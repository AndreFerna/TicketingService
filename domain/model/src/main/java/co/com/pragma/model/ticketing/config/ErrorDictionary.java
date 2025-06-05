package co.com.pragma.model.ticketing.config;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDictionary {
    private String id;
    private String message;
    private Integer httpStatus;
}
