package org.example;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Random;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class Main {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("src/main/resources/employee.xml");
        File xsdFile = new File("src/main/resources/employee.xsd");
        File xslFile = new File("src/main/resources/employee.xsl");
        File xsltFile = new File("src/main/resources/employee.xslt");
        File htmlFile = new File("src/main/resources/employee.html");
        //XMLWrite.DOMWrite();
        //XMLValidator.validateXML(xsdFile, xmlFile);
        //XMLRead.DOMRead(xmlFile);
        //XPathWork.xpathReadNodes(xmlFile);
        //XSLT(xmlFile, xslFile, htmlFile);
        transformToPdf("src/main/resources/employee.xml", "src/main/resources/employee.xslfo", "src/main/resources/employee.pdf");
        //transformXml("src/main/resources/employee.xml", "src/main/resources/employee.xslt", "src/main/resources/employee_t.xml");

    }

    public static void XSLT(File xmlfile, File xslfile, File htmlfile) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslfile));
        transformer.transform(new StreamSource(xmlfile), new StreamResult(htmlfile));
        System.out.println("Transformation completed.");
    }

    public static void transformXml(String xmlInputPath, String xsltPath, String outputXmlPath) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xsltPath));
        Source xml = new StreamSource(new File(xmlInputPath));
        Result result = new StreamResult(new File(outputXmlPath));

        Transformer transformer = factory.newTransformer(xslt);
        transformer.transform(xml, result);
    }

    public static void transformToPdf(String xmlInputPath, String xslfoPath, String pdfOutputPath) throws Exception {
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        File pdfFile = new File(pdfOutputPath);

        try (FileOutputStream out = new FileOutputStream(pdfFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File(xslfoPath)));
            transformer.transform(new StreamSource(new File(xmlInputPath)), new SAXResult(fop.getDefaultHandler()));
        }
    }


}

