package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketingRequestDto {
    @NotNull
    @Schema(example = "5L")
    private Long numberTickets;
    @NotNull
    @Schema(example = "500,000")
    private BigDecimal totalPrice;
    @NotNull
    @Schema(example = "4L")
    private Long used;
    @NotNull
    @Schema(example = "4f63ac55-7c3b-4d44-894d-d92851c822b3")
    private String viewIdentifier;
    @NotNull
    @Schema(example = "1234567890")
    private String userId;

}
