package co.com.pragma.model.ticketing;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class User {

    private String id;
    private String name;
    private String email;
    private String password;
    private int id_role;
}
