import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Locale;

public class XmlLoader {
    private final String fileName;

    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader("data.xml");
    }

    public XmlLoader(String fileName) {
        this.fileName = fileName;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        Player player1;
        Player player2;
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("data.xml"));
            // проходим по всем элементам xml файла
            while (reader.hasNext()) {
                // получаем событие(элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();
                player1 = new Player();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("Player")) {
                        Attribute signAttr = startElement.getAttributeByName(new QName("symbol"));
                        if (signAttr != null) {
                            player1.setSign(signAttr.getValue().charAt(0)); // можно исправить и передавать в метод String
                        }
                        Attribute nameAttr = startElement.getAttributeByName(new QName("name"));
                        if (nameAttr != null) {
                            player1.setName(nameAttr.getValue());
//                            System.out.println(player1.getName());
                        }
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            player1.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }
                }
                System.out.println(player1.getId() + player1.getSign() + player1.getName());
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
//                    .createXMLStreamReader(fileName, new FileInputStream(fileName));
//            while (xmlStreamReader.hasNext()) {
//                xmlStreamReader.next();
//                if (xmlStreamReader.isStartElement()) {
//                    System.out.println(xmlStreamReader.getLocalName());
//                    System.out.println(xmlStreamReader.getNamespaceContext().getNamespaceURI("name"));
//                }  else if (xmlStreamReader.isEndElement()) {
//                    System.out.println("/" + xmlStreamReader.getLocalName());
//                } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 0) {
//                    System.out.println("     " + xmlStreamReader.getText());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
