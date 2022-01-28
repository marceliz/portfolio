package com.portfolio.controller;

import com.portfolio.PortfolioApplication;
import com.portfolio.entity.Portfolio;
import com.portfolio.service.PortfolioService;
import com.portfolio.service.TweetService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfileController {

    Log LOGGER = LogFactory.getLog(ProfileController.class);

    @Autowired
    TweetService tweetService;

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/")
    public String tweets(Model model) {
        List<String> tweets = tweetService.getLatestTweets();

        Portfolio portfolio=portfolioService.getPortfolio(1L);
        model.addAttribute("tweets", tweets);
        model.addAttribute("portfolio", portfolio);
        return "profile";
    }

}
