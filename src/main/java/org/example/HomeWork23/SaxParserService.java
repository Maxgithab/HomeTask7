package org.example.HomeWork23;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SaxParserService {

    public String parseAndSade(String xmlSonnetPath) throws Exception {

        List<String> lines = new ArrayList<>();

        final String[] firstName = {null};
        final String[] lastName = {null};
        final String[] title = {null};

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            private boolean isFirstName = false;
            private boolean isLastName = false;
            private boolean isTitle = false;
            private boolean isLine = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                switch (qName) {
                    case "firstName" -> isFirstName = true;
                    case "lastName" -> isLastName = true;
                    case "title" -> isTitle = true;
                    case "line" -> isLine = true;
                }
            }

            public void characters(char[] ch, int start, int length) {
                String text = new String(ch, start, length).trim();
                if (text.isEmpty()) return;

                if (isFirstName) {
                    firstName[0] = text;
                } else if (isLastName) {
                    lastName[0] = text;
                } else if (isTitle) {
                    title[0] = text;
                } else if (isLine) {
                    lines.add(text);
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                switch (qName) {
                    case "firstName" -> isFirstName = false;
                    case "lastName" -> isLastName = false;
                    case "title" -> isTitle = false;
                    case "line" -> isLine = false;
                }
            }
        };

        File xmlSonetFile = new File(xmlSonnetPath);
        saxParser.parse(xmlSonetFile, handler);

        if (firstName[0] == null || lastName[0] == null || title[0] == null) {
            throw new Exception("где-то в файле не нашлось, надо проверить XML");
        }

        String fileSonnetName = "Sax_Parser_" + firstName[0] + "_" + lastName[0] + "_" + title[0] + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileSonnetName))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
        return fileSonnetName;
    }
}
