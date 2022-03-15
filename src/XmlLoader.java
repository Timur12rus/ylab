import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XmlLoader {
    private final String FILE_NAME = "data.xml";
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Step> steps = new ArrayList<>();


    public void load() {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("data.xml"));
            // проходим по всем элементам xml файла
            Player player = null;
            Step step = null;
            while (reader.hasNext()) {
                // получаем событие(элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "player":
                            player = new Player();
                            Attribute signAttr = startElement.getAttributeByName(new QName("symbol"));
                            if (signAttr != null) {
                                player.setSign(signAttr.getValue().charAt(0));
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
                        case "step":
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
                            step.setValue(Integer.parseInt((xmlEvent.asCharacters().getData())));
                            break;
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("player")) {
                        players.add(player);
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("step")) {
                        steps.add(step);
                    }
                }
            }
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
