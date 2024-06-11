package ar.edu.utn.frc.tup.lc.iii.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("email")
    @Email
    private String email;
}
