package JUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

import BDA.FacePost;
import BDA.Facebook;

public class BackupFPosts {

	private FacebookClient fbClient;
	private String accessToken;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fbClient=new DefaultFacebookClient(accessToken);
	}
	
	
	@Test
	public void test() {
		
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		int counter = 0;
		
		ArrayList<FacePost> lista= new ArrayList<FacePost>();
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "ISCTE"
				if (aPost.getMessage() != null /*&& aPost.getMessage().contains("ISCTE")*/) {
					lista.add((new FacePost(aPost, counter)));
					counter++;
				}
				
			}
		}
		Facebook.BackupFPosts(lista);
		boolean found=false;
		try {
			
			File file = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			@SuppressWarnings("unused")
			Element root=doc.getDocumentElement();
			
				NodeList list = doc.getChildNodes().item(0).getChildNodes();
				for (int count = 0; count < list.getLength(); count++) {

					Node tempNode = list.item(count);
					if(tempNode.getNodeName().equals("Facebook")){
						found=true;
					}
				}
		}catch (Exception e) {
			
		}
			assertTrue(found);	
		
		
	}

}
