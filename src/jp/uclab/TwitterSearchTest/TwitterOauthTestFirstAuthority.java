/**
 * 
 */
package jp.uclab.TwitterSearchTest;

/**
 * @author mangohero1985
 * @create-time     Jun 18, 2013   1:38:30 PM   
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public  class TwitterOauthTestFirstAuthority {
	
//    private final static String CONSUMER_KEY = "Z4uDTqWn9r4BIi36WJ3NA";
//    private final static String CONSUMER_KEY_SECRET = "JRk4BBqoSB6ZPYpAInWQWqjUMwSN2tIvssKWFwKUseM";
    private final static String CONSUMER_KEY = "3rJOl1ODzm9yZy63FACdg";
    private final static String CONSUMER_KEY_SECRET = "5jPoQ5kQvMJFDYRNE8bQ4rHuds4xJqhvgNJM4awaE8";

    public void start() throws TwitterException, IOException {
                  
    	         //设置你的consumer_Key 和 Consumer_Key_Secret
				 Twitter twitter = new TwitterFactory().getInstance();
				 twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
				 
				 RequestToken requestToken = twitter.getOAuthRequestToken();
				 System.out.println("Authorization URL: \n" + requestToken.getAuthorizationURL());
				
				 AccessToken accessToken = null;
				
				 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				 while (null == accessToken) {
				     try {
				  System.out.print("Input PIN here: ");
				  String pin = br.readLine();
				
				  accessToken = twitter.getOAuthAccessToken(requestToken, pin);
				
				     } catch (TwitterException te) {
				
				  System.out.println("Failed to get access token, caused by: "
				   + te.getMessage());
				
				  System.out.println("Retry input PIN");
				
				     }
				 }
				
				 System.out.println("Access Token: " + accessToken.getToken());
				 System.out.println("Access Token Secret: "
				  + accessToken.getTokenSecret());
				
				 twitter.updateStatus("I am doing the text for Searching function through Japanese Menu Finder ");

    }
}
