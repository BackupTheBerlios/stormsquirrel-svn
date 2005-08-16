import javax.swing.*;
import java.awt.*;

interface WhichPart
{

    int HEADER = 0, BODY = 1;

}

public class Editor extends JFrame
{
    Editor(String messageText)
    {
	super("-- Message --");

	System.out.println("Loading message editor...");

	setSize(640,600);
	setVisible(true);
	this.setLayout(new GridLayout(1, 2, 0, 1));

	//adds JScrollPane with message content (this way cause scrolling is needed)
	this.add(new MessageViewport(splitMessage(messageText, 1)));
    }

    String splitMessage(String message, int part)
    {
	
	/*		
	String header;
	String body;

	header = message.substring(0, message.indexOf("X-UID:"));
	body = message.substring(message.indexOf("\n", message.indexOf("X-UID:")), message.length());
	*/

	return message; //Change when massage split is done!!!
    }
}

class MessageViewport extends JScrollPane
{
    MessageViewport(String messageText)
    {
	//adds Text area with message to JScrollPanel to support scrolling
	this.setViewportView(new JTextArea(messageText));
    }
}

