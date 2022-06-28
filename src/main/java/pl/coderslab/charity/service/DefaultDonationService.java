package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;
@Service
@RequiredArgsConstructor
public class DefaultDonationService implements DonationService{

    private final DonationRepository donationRepository;


    @Override
    public Integer sumOfBags() {
        return donationRepository.sumQuantityOfBags();
    }

    @Override
    public Integer countDonations() {
        return donationRepository.countAllDonations();
    }
}
