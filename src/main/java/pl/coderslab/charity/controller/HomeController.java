package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.InstitutionEntity;
import pl.coderslab.charity.service.DefaultDonationService;
import pl.coderslab.charity.service.DefaultInstitutionService;

import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final DefaultInstitutionService institutionService;

    private final DefaultDonationService donationService;

    @GetMapping
    public String homeAction(Model model) {
        List<InstitutionEntity> institutions = institutionService.loadInstitutions();
        model.addAttribute("institutions", institutions);

        Integer sumOfBags = donationService.sumOfBags();
        model.addAttribute("sumOfBags", sumOfBags);

        Integer sumOfDonations = donationService.countDonations();
        model.addAttribute("sumOfDonations", sumOfDonations);
        return "index";
    }

}
