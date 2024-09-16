import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Main {
    public static void main(String[] args) throws Exception {

        
		parseData();
	}



    
	private static void parseData() throws Exception {
		FileInputStream is = new FileInputStream("bookList.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(is);

		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("//list");
		NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());

		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			System.out.println(element.getTagName());
			System.out.println(element.getTextContent());



			XPathExpression expr2 = xpath.compile("//hoge/fuga");
			NodeList nodeList2 = (NodeList) expr2.evaluate(element, XPathConstants.NODESET);
			System.out.println("***********");
			for (int j = 0; j < nodeList2.getLength(); j++) {
				Element element2 = (Element) nodeList2.item(j);
				System.out.println(element2.getTagName());
				System.out.println(element2.getTextContent());
			}
			System.out.println("***********");
		}
	}
}
