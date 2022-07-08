package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class RegisterController {

    private final UserRepository userRepository;

    @GetMapping("/register")
    public String register (Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String saveRegister (@ModelAttribute ("user") @Valid UserEntity userEntity, BindingResult result) {
        if (result.hasErrors()) {
            return "register";

        } else {
            userRepository.save(userEntity);
            return "redirect:/donations";
        }
    }
}
