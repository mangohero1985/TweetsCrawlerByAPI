
package jp.uclab.TwitterSearchTest;

import twitter4j.*;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Timer;

import jp.uclab.TwitterSearchTest.TimerTest.MyTask;

public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args
     * @throws IOException 
     * @throws TwitterException 
     */
	
    public static void main(String[] args) throws TwitterException, IOException {
   	
    	//new TwitterOauthTestFirstAuthority().start();// run the Twitter client
    	//new TimelineTest().start();
    	 
    	// twitter4j search sample
//        if (args.length < 1) {
//            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
//            System.exit(-1);
//        }
        
        //String pathString ="/Users/mangohero1985/Desktop/twitter/twitterTemporary/test/MenuSplitSource.txt";
        String pathString ="/Users/mangohero1985/Desktop/twitter.txt";
        FileWriter fw = new FileWriter(pathString);
        BufferedWriter bw = new BufferedWriter(fw);
		
		Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query("段差　-RT");
            QueryResult result;
            int i =90;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getCreatedAt() +tweet.getUser().getScreenName() + " - " + tweet.getText());
                    bw.write("@" + tweet.getUser().getScreenName() + " - " + tweet.getCreatedAt() + " - " + tweet.getText());
                    bw.flush();
                    bw.newLine();
                    
                }
                i--;
            } while ((query = result.nextQuery()) != null&&i>0);
            bw.close();
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}

