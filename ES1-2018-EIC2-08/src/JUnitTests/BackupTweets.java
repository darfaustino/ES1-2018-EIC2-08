package JUnitTests;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import BDA.TwitterApp;

public class BackupTweets {

	@Test
	public void test() {
		
		TwitterApp.BackupTweets();
		boolean found=false;
		try {
			
			File file = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			
				NodeList list = doc.getChildNodes().item(0).getChildNodes();
				for (int count = 0; count < list.getLength(); count++) {

					Node tempNode = list.item(count);
					if(tempNode.getNodeName().equals("Twitter")){
						found=true;
					}
				}
		}catch (Exception e) {
			
		}
			assertTrue(found);	
		
	}

}
