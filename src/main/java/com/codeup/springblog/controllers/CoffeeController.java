package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {
    @GetMapping("/coffee")
    public String coffeeInfo(){
        return "views-lec/coffee";
    }
    @GetMapping("/coffee/{roast}")
    public String roastSelection(@PathVariable String roast, Model model) {
//        model.addAttribute("roast", roast);
//        boolean choseDark = false;
//        if (roast.equals("dark")) {
//            choseDark = true;
//        }
//        model.addAttribute("choseDark", choseDark);
        Coffee selection = new Coffee(roast, "Cool Beans");
        Coffee selection2 = new Coffee(roast, "Yummy Dummys");

        selection.setRoast(roast);
        if (roast.equals("dark")) {
            selection.setOrigin("Columbia");
            selection.setOrigin("Brazil");

        } else if (roast.equals("medium")) {
            selection.setOrigin("New Guinea");
            selection.setOrigin("Sumatra");

        } else {
            selection.setOrigin("Kenya");
            selection.setOrigin("Ethiopa");

        }
        List<Coffee> selections = new ArrayList<>();
        selections.add(selection);
        selections.add(selection2);
        model.addAttribute("roast", roast);

        model.addAttribute("selections", selections);

        return "views-lec/coffee";
    }
}
