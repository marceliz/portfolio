package com.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TweetService
{
    int LIMIT_TWEETS=5;
    private Twitter twitter;

    public TweetService(Twitter twitter) {
        this.twitter = twitter;
    }

    public List<String> getLatestTweets()
    {
        int tweetCounter=0;
        List<String> tweets = new ArrayList<>();
        try {
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            for (Status status : homeTimeline)
            {
                if(tweetCounter<LIMIT_TWEETS) {
                    tweets.add(status.getText());
                }else{
                    break;
                }
                tweetCounter++;
            }
        }
        catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        return tweets;
    }

}
