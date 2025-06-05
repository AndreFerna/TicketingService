package co.com.pragma.api.dto;

import lombok.Builder;
import lombok.Getter;
import org.wildfly.common.annotation.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Builder
public class ResponseErrorDto {
    @NotNull
    @Schema(example = "4XX-XXX")
    private String code;
    @NotNull
    @Schema(example = "Mensaje de la excepcion")
    private String message;
}
