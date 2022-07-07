package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.CategoryEntity;
import pl.coderslab.charity.entity.DonationEntity;
import pl.coderslab.charity.entity.InstitutionEntity;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DefaultCategoryService;
import pl.coderslab.charity.service.DefaultInstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class DonationController {

    private final DefaultCategoryService categoryService;
    private final DefaultInstitutionService institutionService;
    private final DonationRepository donationRepository;

    @GetMapping("/donations")
    public String processView (Model model) {
       model.addAttribute("donation", new DonationEntity()) ;
        List<CategoryEntity> categories = categoryService.loadCategories();
        model.addAttribute("categories", categories);

        List<InstitutionEntity> institutions = institutionService.loadInstitutions();
        model.addAttribute("institutions", institutions);
        return "donation";
    }

    @PostMapping("/donations")
    public String donationData(@ModelAttribute("donation") @Valid DonationEntity donation, BindingResult result) {
        if (result.hasErrors()) {
            return "donation";
        }
        donationRepository.save(donation);
        return "donationConfirm";
    }

}
