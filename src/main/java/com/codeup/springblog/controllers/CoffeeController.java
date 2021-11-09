package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.repositories.CoffeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {
    @GetMapping("/coffee")
    public String coffeeInfo() {
        return "views-lec/coffee";
    }

    @GetMapping("/coffee/{roast}")
    public String roastSelection(@PathVariable String roast, Model model) {
//        Coffee selection = new Coffee(roast, "Cool Beans");
//        Coffee selection2 = new Coffee(roast, "Jolting Joe");
//        if (roast.equals("dark")) {
//            selection.setOrigin("Colombia");
//            selection2.setOrigin("Brazil");
//        } else if (roast.equals("medium")) {
//            selection.setOrigin("New Guinea");
//            selection2.setOrigin("Sumatra");
//        } else {
//            selection.setOrigin("Kenya");
//            selection2.setOrigin("Ethiopia");
//        }
//        List<Coffee> selections = new ArrayList<>();
//        selections.add(selection);
//        selections.add(selection2);
//        model.addAttribute("roast", roast);
//        model.addAttribute("selections", selections);
        model.addAttribute("selections", CoffeeRepository.findByRoast(roast));
        return "coffees/coffee";

    }

    @GetMapping("/coffee/create")
    public String showCreateCoffeeForm(Model model){
        model.addAttribute("coffee", new Coffee());
        return "/coffees/create";
    }

    @PostMapping("/coffee/create")
    public String createCoffee(@ModelAttribute Coffee coffee){
    coffeeRepository.save(coffee);
    return "redirect:coffee";
    }

    @PostMapping("/coffee")
    public String newsletterSignup(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        emailService.prepareAndSend(email, "You have signed up for coffee emails! Thank you!");
        return "coffee/coffee";
    }
}
