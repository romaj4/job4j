package ru.job4j.sqlite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ParseXml {

    private int sum;

    private ConvertXSQT convertXSQT;

    public ParseXml(ConvertXSQT convertXSQT) {
        this.convertXSQT = convertXSQT;
        System.out.println(this.sumOfElements());
    }

    /**
     * Вычисляет сумму значений атрибутов.
     *
     * @return sum.
     */
    public int sumOfElements() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("entry")) {
                        String field = attributes.getValue("field");
                        sum += Integer.parseInt(field);
                    }
                }
            };
            saxParser.parse(this.convertXSQT.getDest(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public int getSum() {
        return sum;
    }
}