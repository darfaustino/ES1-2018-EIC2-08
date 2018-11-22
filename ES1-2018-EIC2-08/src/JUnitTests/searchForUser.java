//package JUnitTests;
//
//import static org.junit.Assert.*;
//import java.util.List;
//import org.junit.Test;
//
//import BDA.TwitterApp;
//import twitter4j.Status;
//
//public class searchForUser {
//	
//	@Test
//	public void test() {
//		TwitterApp ta=new TwitterApp();
//		
//		List<Status> statuses = ta.statuses;
//		assertNotNull(statuses);
//		
//		String s = "NAMI";
//		assertNotNull(s);	
//		
//		int counter = 0;
//		assertEquals(counter,0);
//		
//		int counterTotal = 0;
//		assertEquals(counterTotal,0);
//		
//		boolean found=false;
//		
//		for (Status status : statuses) {
//			if (status.getUser().getName() != null && status.getUser().getName().contains(s)) {
////				System.out.println(status.getUser().getName() + ":" + status.getText());
//				found=true;
//				counter++;
//			}
//			counterTotal++;
//		}
////		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
//		
//		assertTrue(found);
//	
//	}
//
//	
//
//}