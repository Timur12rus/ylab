import org.w3c.dom.Attr;
import org.w3c.dom.Text;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class XmlLoader {
    private final String fileName;

    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader("data.xml");
    }

    public XmlLoader(String fileName) {
        this.fileName = fileName;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Step> steps = new ArrayList<>();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("data.xml"));
            // проходим по всем элементам xml файла
//            ArrayList<Player> players = new ArrayList<>();
            Player player = null;
            Step step = null;
            while (reader.hasNext()) {
                // получаем событие(элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "Player":
                            player = new Player();
                            Attribute signAttr = startElement.getAttributeByName(new QName("symbol"));
                            if (signAttr != null) {
                                player.setSign(signAttr.getValue().charAt(0)); // можно исправить и передавать в метод тип String
                            }
                            Attribute nameAttr = startElement.getAttributeByName(new QName("name"));
                            if (nameAttr != null) {
                                player.setName(nameAttr.getValue());
                            }
                            Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                            if (idAttr != null) {
                                player.setId(Integer.parseInt(idAttr.getValue()));
                            }
                            break;
                        case "Step":
                            step = new Step();
                            Attribute playerIdAttr = startElement.getAttributeByName(new QName("playerId"));
                            if (playerIdAttr != null) {
                                step.setPlayerId(Integer.parseInt(playerIdAttr.getValue()));
                            }
                            Attribute numAttr = startElement.getAttributeByName(new QName("num"));
                            if (numAttr != null) {
                                step.setNum(Integer.parseInt(numAttr.getValue()));
                            }
                            xmlEvent = reader.nextEvent();
                            step.setValue(Integer.parseInt((xmlEvent.asCharacters().getData().replaceAll(" ", ""))));
                            break;
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Player")) {
                        players.add(player);
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Step")) {
                        steps.add(step);
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Player player : players) {
            System.out.println("sign = " + player.getSign() + "; name = " +
                    player.getName() + "; id = " + player.getId());

        }
        for (Step step : steps) {
            System.out.println("playerId = " + step.getPlayerId() + "; num = " +
                    step.getNum() + "; value = " + step.getValue());
        }
    }
}
