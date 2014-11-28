/**
 * 
 */
package jp.uclab.TwitterSearchTest;

import java.io.IOException; 
import java.util.Timer; 
import twitter4j.*;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
/**
 * @author mangohero1985
 * @create-time     Jun 19, 2013   10:38:59 PM   
 */
public class TimerTest {
	
	public static void main(String[] args){ 
		Timer timer = new Timer(); 
		timer.schedule(new MyTask(), 1000, 2*1000);//在1秒后执行此任务,每次间隔60秒,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.  
		} 

		static class MyTask extends java.util.TimerTask{ 
		@Override 
		public void run() { 
		
			    String pathString ="/Users/mangohero1985/Desktop/twitterSearchResult/TimerNOResult.txt";
		        FileWriter fw = null;
				try {
					fw = new FileWriter(pathString,true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        BufferedWriter bw = new BufferedWriter(fw);
				
				Twitter twitter = new TwitterFactory().getInstance();
		        try {
		            Query query = new Query("の -RT");
		            QueryResult result;
		                result = twitter.search(query);
		                List<Status> tweets = result.getTweets();
		                for (Status tweet : tweets) {
		                    System.out.println("@" + tweet.getCreatedAt() +tweet.getUser().getScreenName() + " - " + tweet.getText());
		                    bw.write("@" + tweet.getUser().getScreenName() + " - " + tweet.getCreatedAt() + " - " + tweet.getText());
		                    bw.flush();
		                    bw.newLine();
		                }
		            bw.close();
		        } catch (TwitterException te) {
		            te.printStackTrace();
		            System.out.println("Failed to search tweets: " + te.getMessage());
		            System.exit(-1);
		        } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          System.out.println("haha");
		} 
		} 

}
