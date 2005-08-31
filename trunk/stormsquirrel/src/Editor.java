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
import javax.swing.border.*;
import java.awt.*;


public class Editor extends JFrame
{
    Editor(String messageText)
    {
	super("-- Message --");
	System.out.println("Loading message editor...");

	getContentPane().add(new TopBox(), BorderLayout.NORTH);
	getContentPane().add(new MessageViewport(messageText));
	setSize(640,600);
	setVisible(true);
    }
}

class TopBox extends Box
{
    TopBox()
    {
	super(BoxLayout.Y_AXIS);

	//adds top JTextFields with mail sender...
	this.add(new TopArea());
    }
}


class MessageViewport extends JScrollPane
{
    MessageViewport(String messageText)
    {
	//adds Text area with message to JScrollPanel to support scrolling
	JTextPane messagePart = new JTextPane();
	messagePart.setText(messageText);
	this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	this.setViewportView(messagePart);
    }
}


class TopArea extends JPanel
{

    TopArea()
    {
	this.setLayout(new GridLayout(4,1,0,1));
	this.add(new JTextField(" - From - "));
	this.add(new JTextField(" - To - "));
	this.add(new JTextField(" - Date - "));
	this.add(new JTextField(" - Subject - "));
    }
}

