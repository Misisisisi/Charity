package pl.coderslab.charity.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString(exclude = "password")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginForm {


    @Email
    private String email;
    @NotBlank(message = "Podaj hasło")
    private String password;

}