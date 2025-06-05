package co.com.pragma.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "venta")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TicketingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cantidad_entradas")
    private Long numberTickets;
    @Column(name = "precio_total")
    private BigDecimal price;
    @Column(name = "fecha_compra")
    private LocalDateTime date;
    @Column(name = "usadas")
    private Long used;
    @Column(name = "codigo_unico")
    private String uniqueCode;
    @Column(name = "vista_id")
    private Long viewId;
    @Column(name = "url_id")
    private Long urlId;
    @Column(name = "usuario_id")
    private String userId;
}
