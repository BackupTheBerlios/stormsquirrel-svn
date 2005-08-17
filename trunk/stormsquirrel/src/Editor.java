/***************************************************************************
 *   Copyright (C) 2005 by Marek Piechut                                   *
 *   mco (at) o2 (dot) pl                                                  *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

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
