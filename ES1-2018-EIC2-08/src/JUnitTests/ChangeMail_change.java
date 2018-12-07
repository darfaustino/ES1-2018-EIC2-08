package JUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import BDA.ChangeMail;

public class ChangeMail_change {

	private String email, newMail;
	private char[] pass;
	

	@Before
	public void setUp() throws Exception {
		try {
			File file = new File("config.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getChildNodes().item(0).getChildNodes();
			for (int count = 0; count < list.getLength(); count++) {
				Node tempNode = list.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					if (tempNode.hasAttributes()) {
						email=((Element) tempNode).getAttribute("Email");
						pass=((Element) tempNode).getAttribute("Password").toCharArray();
						break;
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		ChangeMail a = new ChangeMail(email);
		char[] c= email.toCharArray();
		newMail="teste"+email;
		a.change(newMail, pass); 

		try {
			File file = new File("config.xml");

			// See if its not empty
			assertTrue(file.length() > 0);

			// See if the email was saved
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getChildNodes().item(0).getChildNodes();
			boolean isSaved = false;
			for (int count = 0; count < list.getLength(); count++) {
				Node tempNode = list.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					if (tempNode.hasAttributes()) {
						if (((Element) tempNode).getAttribute("Email").equals(newMail) && ((Element) tempNode).getAttribute("Password").equals(new String(pass))){
							isSaved = true;
						}

					}

				}

			}

			assertTrue(isSaved);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
