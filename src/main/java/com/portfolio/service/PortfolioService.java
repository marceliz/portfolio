package com.portfolio.service;

import com.portfolio.entity.Portfolio;
import com.portfolio.repository.PortfolioRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {
    private final Log LOG = LogFactory.getLog(PortfolioService.class);

    private PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Portfolio getPortfolio(Long id){
        return portfolioRepository.getById(id);
    }

    public Portfolio savePortfolio(Portfolio portfolio){
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getAllPortfolioList(){
        return portfolioRepository.findAll();
    }

    public Portfolio updatePortfolio(Portfolio newPortfolio, Long id){
        return portfolioRepository.findById(id)
                .map(
                        portfolio->{
                            portfolio.setEmail(newPortfolio.getEmail());
                            portfolio.setExperiencie(newPortfolio.getExperience());
                            portfolio.setImagePath(newPortfolio.getImagePath());
                            portfolio.setName(newPortfolio.getName());
                            portfolio.setTwitterUser(newPortfolio.getTwitterUser());
                            portfolio.setEmail(newPortfolio.getEmail());
                            portfolio.setAddress(newPortfolio.getAddress());
                            portfolio.setPhone(newPortfolio.getPhone());
                            portfolio.setZipCode(newPortfolio.getZipCode());
                            return portfolioRepository.save(portfolio);
                        }).get();
    }
}
