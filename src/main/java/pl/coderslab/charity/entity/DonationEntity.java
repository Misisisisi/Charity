package pl.coderslab.charity.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.rmi.MarshalException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull (message = "Podaj właściwą ilość worków")
    private int quantity;
    @ManyToMany
    @JoinColumn(name = "categories_id")
    private List<CategoryEntity> categories;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private InstitutionEntity institution;
    @NotNull(message = "Podaj nazwę ulicy")
    private String street;
    @NotNull(message = "Podaj nazwę miasta")
    private String city;
    @NumberFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Podaj prawidłowy kod pocztowy")
    private String zipCode;
    @NumberFormat(pattern = "d{9}")
    @NotNull(message = "Podaj numer telefonu")
    private String phone;
    @NotNull (message = "Podaj datę odbioru przesyłki")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull
    @DateTimeFormat (pattern = "hh:mm")
    private LocalTime pickUpTime;

    private String pickUpComment;

}
