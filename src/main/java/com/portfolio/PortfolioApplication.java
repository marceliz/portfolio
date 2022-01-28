package com.portfolio;

import com.portfolio.entity.Portfolio;
import com.portfolio.service.PortfolioService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(PortfolioApplication.class);

	private PortfolioService portfolioService;


	public PortfolioApplication(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//portfolioService.getAllPortfolioList().stream().forEach(portfolio -> LOGGER.info("PORTFOLIO::::"+portfolio));
	}
}
