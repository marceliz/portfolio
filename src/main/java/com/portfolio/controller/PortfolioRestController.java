package com.portfolio.controller;

import com.portfolio.entity.Portfolio;
import com.portfolio.usecase.GetProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/portfolio")
public class PortfolioRestController {

    private GetProfile getProfile;

    public PortfolioRestController(GetProfile getProfile) {
        this.getProfile = getProfile;
    }

    @GetMapping("/")
    List<Portfolio> get(){
        return getProfile.getProfileList();
    }

    @GetMapping("/{id}")
    ResponseEntity<Portfolio> getProfile(@PathVariable Long id){
        return new ResponseEntity<>(getProfile.getProfile(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Portfolio> updateProfile(@RequestBody Portfolio portfolio, @PathVariable Long id){
        return new ResponseEntity<>(getProfile.updatePortfolio(portfolio, id), HttpStatus.OK);
    }
}
