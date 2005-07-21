import javax.swing.*;
import java.awt.*;

public class Editor extends JFrame
{
    Editor(String messageText)
    {
	super("-- Message --");

	System.out.println("Loading message editor...");

	setSize(640,600);
	setVisible(true);
	this.setLayout(new GridLayout(1, 4, 0, 1));
	this.add(new JTextArea(splitMessage(messageText, 1)));
    }

    String splitMessage(String message, int part)
    {
	String header;
	String body;

	header = message.substring(0, message.indexOf("X-UID:"));
	body = message.substring(message.indexOf("\n", message.indexOf("X-UID:")), message.length());

	return body;
    }
}

interface WhichPart
{

    int HEADER = 0, BODY = 1;

}
