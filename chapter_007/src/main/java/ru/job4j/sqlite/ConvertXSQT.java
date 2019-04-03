package ru.job4j.sqlite;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertXSQT {

    private final File dest;

    private final File scheme;

    private final XmlUsage xmlUsage;

    public ConvertXSQT(File dest, File scheme, XmlUsage xmlUsage) {
        this.dest = dest;
        this.scheme = scheme;
        this.xmlUsage = xmlUsage;
        this.convert();
    }

    /**
     * Конвертирует данные из файла XML в файл другого XML формата.
     *
     * @throws TransformerException
     */
    public void convert() {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(
                    new StreamSource(this.scheme));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.transform(new StreamSource(this.xmlUsage.getTarget()),
                    new StreamResult(this.dest)
            );
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public File getDest() {
        return dest;
    }
}
