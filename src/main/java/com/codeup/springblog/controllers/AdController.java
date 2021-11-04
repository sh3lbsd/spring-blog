package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adRepository;

    public AdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @GetMapping("/dads")
    @ResponseBody
    public List<Ad> showAds() {
        System.out.println(adRepository.findAll());
//        return ("yeah!");


//        return "Showing all the dads";
    }

    @GetMapping("/dads/{id}")
    @ResponseBody
    public String showSingleDad(@PathVariable long id) {
        return "Showing dad: " + id;
    }

    @GetMapping("/ads/{title}")
    public Ad getByTitle(@PathVariable String title) {
        return (Ad) adRepository.findByTitle(title);
    }
    @GetMapping("/ads/{desc}")
    public Ad getByDescription(@PathVariable String desc) {
        return (Ad) adRepository.findByDescription(desc);
    }

    @GetMapping("/ads/{titlePart}")
    public Ad getByTitlePart(@PathVariable String titlePart) {
        return (Ad) adRepository.findByTitleLike(titlePart);
    }

    @PostMapping ("/dads")
    @ResponseBody
    public String createAds(@RequestBody Ad newAd) {
        adRepository.save(newAd);
        return String.format("Ad created with an ID of: %s", newAd.getId());
//        return "Creating a dad";
    }
}