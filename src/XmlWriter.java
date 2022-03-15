import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class XmlWriter {
    private final String FILE_NAME = "data.xml";

    public void write(ArrayList<Step> steps, ArrayList<Player> players, Player winnerPlayer) {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter(FILE_NAME));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("gameplay");

            writer.writeStartElement("player");
            writer.writeAttribute("symbol", String.valueOf(players.get(0).getSign()));
            writer.writeAttribute("name", players.get(0).getName());
            writer.writeAttribute("playerId", String.valueOf(players.get(0).getId()));
            writer.writeEndElement();

            writer.writeStartElement("player");
            writer.writeAttribute("symbol", String.valueOf(players.get(1).getSign()));
            writer.writeAttribute("name", players.get(1).getName());
            writer.writeAttribute("playerId", String.valueOf(players.get(1).getId()));
            writer.writeEndElement();

            writer.writeStartElement("game");
            writer.writeStartElement("steps");
            int num = 1;
            for (Step step : steps) {
                // записываем
                writer.writeStartElement("step");
                writer.writeAttribute("playerId", String.valueOf(step.getPlayerId()));
                writer.writeAttribute("num", String.valueOf(num));
                writer.writeCharacters(String.valueOf("" + step.getX() + step.getY()));
                writer.writeEndElement();
                num++;
            }
            writer.writeEndElement();
            writer.writeEndElement();

            writer.writeStartElement("gameResult");
            writer.writeStartElement("player");
            writer.writeAttribute("id", String.valueOf(winnerPlayer.getId()));
            writer.writeAttribute("name", winnerPlayer.getName());
            writer.writeAttribute("symbol", String.valueOf(winnerPlayer.getSign()));
            writer.writeEndElement();
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
