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
public class TicketingResponseDto {
    @NotNull
    @Schema(example = "1L")
    private Long id;
    @NotNull
    @Schema(example = "5L")
    private Long numberTickets;
    @NotNull
    @Schema(example = "500,000")
    private BigDecimal totalPrice;
    @NotNull
    @Schema(example = "2025-06-05 00:22:38.136")
    private String date;
    @NotNull
    @Schema(example = "4L")
    private Long used;
    @NotNull
    @Schema(example = "da4af969-fe96-4869-87e5-4e2b5b745e0b")
    private String uniqueCode;
    @NotNull
    @Schema(example = "4f63ac55-7c3b-4d44-894d-d92851c822b3")
    private String viewIdentifier;
    @NotNull
    @Schema(example = "https://tournament.com/view/?ticketing=db5dcda3-436d-4c5c-a130-2aaed9b80c9b")
    private String url;
    @NotNull
    @Schema(example = "1234567890")
    private String userId;
}
