package org.example;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XMLValidator {
    public static void validateXML(File xsdFile, File xmlFile) {
        try {
            Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
