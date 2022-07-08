package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table (name = "users")
@ToString(exclude = "password")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Email
    @NotBlank (message = "Podaj prawidłowy email")
    private String email;
    @Size(min = 8, max = 20, message = "Hasło musi mieć minimum 8 znaków")
    private String password;
    @Size(min = 8, max = 20)
    private String password2;
    private String username;

    private String role;
}
