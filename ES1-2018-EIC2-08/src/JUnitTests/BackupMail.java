package JUnitTests;

import static org.junit.Assert.*;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class BackupMail {

	
	
	@Test
	public void test() {
		
		
		
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
					if(tempNode.getNodeName().equals("Mail")){
						found=true;
					}
				}
		}catch (Exception e) {
			// TODO: handle exception
		}
		assertTrue(found);

	}

}
