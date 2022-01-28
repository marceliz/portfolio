package com.portfolio;

import java.util.List;

import com.portfolio.service.TweetService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTwitter4jDemoApplicationTest
{
    Log LOGGER = LogFactory.getLog(PortfolioApplication.class);

    @Autowired
    private TweetService tweetService;

    @Autowired
    Twitter twitter;

    @Test
    public void testGetTweets() throws TwitterException
    {
        List<String> tweets = tweetService.getLatestTweets();

        LOGGER.info("TWEET SIZE::::::"+tweets.size());

        for (String tweet : tweets)
        {
            LOGGER.info("TWEET::::::"+tweet);
            //System.err.println("TWEEETING::::"+tweet);
        }
    }

    @Test
    public void showHomeTimeline() {

        List<Status> statuses = null;
        try {
            System.out.println("FIRST::::::"+twitter.getScreenName());
            System.out.println("SECOND::::::"+twitter.timelines().getHomeTimeline().size());

            System.out.println("USER:::: "+twitter.verifyCredentials());


            statuses = twitter.getHomeTimeline();

            System.out.println("Showing home timeline."+ statuses.size());

            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" + status.getText());
                String url= "https://twitter.com/" + status.getUser().getScreenName() + "/status/"
                        + status.getId();
                System.out.println("Above tweet URL : " + url);
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("K2uW4JGtng7BYMpEk9qhOw")
                .setOAuthConsumerSecret("9JWmsiiPpszdKfxj4X88ZbnfX1hPhZRnnPHRxzX9hnw")
                .setOAuthAccessToken("792995125-Pi6u8AvH46sIqVjYTsS8fv6hnRfluSQtL2nSxNta")
                .setOAuthAccessTokenSecret("pJtyFZP47zOmcOQQEwJUren8KbcleApRAmytAJE");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Status miStatus = twitter.updateStatus("Second Simple Tweet for testing api...");//cambia el estado de twitter
        System.out.println("STATUS::::::"+miStatus.getText());

        System.out.println("USER2:::: "+twitter.getHomeTimeline().size());

        twitter.getHomeTimeline().forEach(s -> System.out.println("s.getText() = " + s.getText()));
    }
}
