package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class DonationEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int quantity;
    @OneToMany
    private List <CategoryEntity> categories;
    @OneToOne
    private InstitutionEntity institution;
    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    private String zipCode;
    @NotNull
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;

}
