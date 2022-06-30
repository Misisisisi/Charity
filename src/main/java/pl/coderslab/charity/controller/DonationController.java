package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.CategoryEntity;
import pl.coderslab.charity.service.DefaultCategoryService;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class DonationController {

    private final DefaultCategoryService categoryService;

    @GetMapping("donations")
    public String processView (Model model) {
        List<CategoryEntity> categories = categoryService.loadCategories();
        model.addAttribute("categories", categories);
        return "donation";
    }

    @GetMapping("donations/step2")
    public String step2 (Model model) {

        return "donation";
    }

}
