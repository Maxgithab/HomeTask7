package org.example.HomeWork23;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DomParserService {

    public String parseAndSade(String xmlSonnetPath) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

        File fileXml = new File(xmlSonnetPath);
        Document document = builder.parse(fileXml);

        document.getDocumentElement().normalize();

        NodeList firstNameNodes = document.getElementsByTagName("firstName");
        String firstName = firstNameNodes.item(0).getTextContent();

        NodeList lastNameNodes = document.getElementsByTagName("lastName");
        String lastName = lastNameNodes.item(0).getTextContent();

        NodeList titleNodes = document.getElementsByTagName("title");
        String title = titleNodes.item(0).getTextContent();

        if (firstName == null || lastName == null || title == null) {
            throw new Exception("где-то в файле не нашлось, надо проверить XML");
        }

        String fileSonnetName = "Dom_Parser_" +  firstName + "_" + lastName + "_" + title + ".txt";

        NodeList nodeList = document.getElementsByTagName("line");
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            String line = nodeList.item(i).getTextContent();
            lines.add(line);
        }

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileSonnetName))) {
            for (String line: lines) {
                printWriter.println(line);
            }
        }

        return fileSonnetName;
    }
}
