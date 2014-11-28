/**
 * 
 */
package jp.uclab.TwitterStreamingTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.FilterQuery;

/**
 * @author mangohero1985
 * @create-time Jun 19, 2013 7:50:03 PM
 */
public class streamingTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		
		StatusListener listener = new StatusListener() {

			//String pathString = "/Users/mangohero1985/Desktop/twitterSearchResult/StreamingResult.txt";
			String pathString = "/Users/mangohero1985/Desktop/twitterSearchResult.txt";
			FileWriter fw = new FileWriter(pathString);
			BufferedWriter bw = new BufferedWriter(fw);
 
			public void onStatus(Status status) {
				System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
				try {
					bw.write("@" + status.getUser().getScreenName() + " - "+ status.getText());
					bw.flush();
					bw.newLine();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			public void onDeletionNotice(
					StatusDeletionNotice statusDeletionNotice) {
				System.out.println("Got a status deletion notice id:"
						+ statusDeletionNotice.getStatusId());
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				System.out.println("Got track limitation notice:"
						+ numberOfLimitedStatuses);
			}

			public void onScrubGeo(long userId, long upToStatusId) {
				System.out.println("Got scrub_geo event userId:" + userId
						+ " upToStatusId:" + upToStatusId);
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}
		};

		
		twitterStream.addListener(listener);
		//twitterStream.sample();
		
		FilterQuery filterQuery = new FilterQuery();
		String[] keyWord = { "車いす" };
		filterQuery.track(keyWord);
		twitterStream.filter(filterQuery);

	}

}
