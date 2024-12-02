package org.example;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import java.io.File;

public class XPathWork {
    public static void xpathReadNodes(File file) throws Exception
    {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        document.normalize();

        NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//Employee").evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }
}
