package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.CategoryEntity;
import pl.coderslab.charity.entity.DonationEntity;
import pl.coderslab.charity.entity.InstitutionEntity;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "update")
@Component
@Slf4j
@RequiredArgsConstructor
public class TestDataLoader {
    private final InstitutionRepository institutionRepository;

    private final DonationRepository donationRepository;

    private final CategoryRepository categoryRepository;


    @EventListener
    public void loadData(ContextRefreshedEvent event) {
        log.debug("Loading data...");
        institutionRepository.save(InstitutionEntity.builder()
                .description("Małe słodkie kotki")
                .name("Słodkie kotki")
                .build());
        institutionRepository.save(InstitutionEntity.builder()
                .description("Urocze pieski")
                .name("Pieski")
                .build());
        institutionRepository.save(InstitutionEntity.builder()
                .description("Schronisko w Tatrach")
                .name("Taterniacy")
                .build());
        InstitutionEntity institution = institutionRepository.save(InstitutionEntity.builder()
                .description("Wspieramy Wasze zdrowie")
                .name("Na zdrowie")
                .build());
        CategoryEntity category1 = categoryRepository.save(CategoryEntity.builder()
                .name("zabawki")
                .build());
        CategoryEntity category2 = categoryRepository.save(CategoryEntity.builder()
                .name("misie")
                .build());
        donationRepository.save(DonationEntity.builder()
                .pickUpDate(LocalDate.ofEpochDay(2022 - 10 - 02))
                .pickUpComment("xxx")
                .institution(institution)
                .city("Kraków")
                .categories(List.of(category1,category2))
                .quantity(5)
                        .pickUpTime(LocalTime.ofSecondOfDay(15))
                        .street("abc")
                        .zipCode("12-255")
                .build());


    }
}