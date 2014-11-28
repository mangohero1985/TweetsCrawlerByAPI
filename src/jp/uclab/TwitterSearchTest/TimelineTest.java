/**
 * 
 */
package jp.uclab.TwitterSearchTest;

/**
 * @author mangohero1985
 * @create-time     Jun 18, 2013   2:54:02 PM   
 */

import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TimelineTest {
 
	private final static String CONSUMER_KEY = "Z4uDTqWn9r4BIi36WJ3NA";
    private final static String CONSUMER_KEY_SECRET = "JRk4BBqoSB6ZPYpAInWQWqjUMwSN2tIvssKWFwKUseM";

    public void start() throws TwitterException, IOException {

 Twitter twitter = new TwitterFactory().getInstance();
 twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

 // here's the difference
 String accessToken = getSavedAccessToken();
 String accessTokenSecret = getSavedAccessTokenSecret();
 AccessToken oathAccessToken = new AccessToken(accessToken,
  accessTokenSecret);

 twitter.setOAuthAccessToken(oathAccessToken);
 // end of difference

 twitter.updateStatus("test");

 System.out.println("\nMy Timeline:");

 // I'm reading your timeline
 ResponseList<Status> list = twitter.getHomeTimeline();
 for (Status each : list) {

     System.out.println("Sent by: @" + each.getUser().getScreenName()
      + " - " + each.getUser().getName() + "\n" + each.getText()
      + "\n");
 }

    }

    private String getSavedAccessTokenSecret() {
 // consider this is method to get your previously saved Access Token
 // Secret
 return "TEP0sqVCTHiwPkSzaSmnktHDb6TXRkfA4BQ2SbhXyc";
    }

    private String getSavedAccessToken() {
 // consider this is method to get your previously saved Access Token
 return "388750683-HEUIm7eNNFcQitoAHTACnGWveqD7XEZPwkQT6EUX";
    }

}
