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

import BDA.Home;
import BDA.SignUp;

public class SignUp_duplicateMail {

	private String duplicate, notDuplicate;
	private Home h;
	
	@Before
	public void setUp() throws Exception {
		h=new Home();
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
						duplicate=((Element) tempNode).getAttribute("Email");
						notDuplicate="notDuplicate"+duplicate;
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
		SignUp a= new SignUp(h.getLauncher());
		boolean t=a.duplicateMail(duplicate);
		assertTrue(t);
		boolean f=a.duplicateMail(notDuplicate);
		assertFalse(f);
	}

}
