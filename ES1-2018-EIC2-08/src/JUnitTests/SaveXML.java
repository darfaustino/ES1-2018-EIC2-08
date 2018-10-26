package JUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import BDA.SignUp;

public class SaveXML {

	@Test
	public void test() {
		try {
			String email = "test@iscte-iul.pt";
			char[] password = new char[5];
			password = "test1".toCharArray();
			String name = "Test";
			boolean isSaved = false;
			SignUp.SaveXML(email, password, name, email, password);

			File file = new File("config.xml");

			// See if its not empty
			assertTrue(file.length() > 0);

			// See if the account was saved
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

						if (((Element) tempNode).getAttribute("Email").equals(email)
								&& ((Element) tempNode).getAttribute("Name").equals(name)) {
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
