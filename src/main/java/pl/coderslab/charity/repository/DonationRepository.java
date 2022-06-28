package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.DonationEntity;

public interface DonationRepository extends JpaRepository<DonationEntity, Long> {

    @Query("SELECT SUM(donation.quantity) FROM DonationEntity donation")
    Integer sumQuantityOfBags();


    @Query("SELECT COUNT(donate.id) FROM DonationEntity donate")
    Integer countAllDonations();


}
