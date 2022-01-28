package com.portfolio.usecase;

import com.portfolio.entity.Portfolio;
import com.portfolio.service.PortfolioService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetProfile {

    private PortfolioService portfolioService;

    public GetProfile(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    public List<Portfolio> getProfileList(){
        return portfolioService.getAllPortfolioList();
    }

    public Portfolio getProfile(Long id){
        return portfolioService.getPortfolio(id);
    }

    public Portfolio updatePortfolio(Portfolio newPortfolio, Long id){
        return portfolioService.updatePortfolio(newPortfolio, id);
    }

}
