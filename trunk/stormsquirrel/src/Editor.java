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
 	getContentPane().add(new TopBox(messageText), BorderLayout.NORTH);
	getContentPane().add(new MessageViewport(messageText));
	getContentPane().add(new BottomButtonsPanel(), BorderLayout.SOUTH);
	setSize(640,600);
	setVisible(true);
    }   
}

class TopBox extends Box
{
    //adds top labels with header info and little free space between it and message
    TopBox(String messageText)
    {
	super(BoxLayout.Y_AXIS);
	//adds editor's top menu
	this.add(new EditorTopMenu());
	//adds top JTextFields with mail sender...
	this.add(new TopLabels("from", "date", "subject"));
	this.add(Box.createVerticalStrut(2));
    }
}


class MessageViewport extends JScrollPane
{
    MessageViewport(String messageText)
    {
	//adds Text area with message to JScrollPanel to support scrolling
	JTextPane messagePart = new JTextPane();
	messagePart.setEditable(false);
	messagePart.setText(messageText);
	this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	this.setViewportView(messagePart);
    }
}


//****************//
//Top labels related classes


class TopLabels extends Box
{

/*
This class creates a Box (container with box layout) and adds 
labels and text fields to it.
*/

    TopLabels(String from, String date, String subject)
    {
	super(BoxLayout.Y_AXIS);
	//Creates new Box and adds TopLabel;free space;TopLabel...
	Box fromAndDateLine = new Box(BoxLayout.X_AXIS);
	fromAndDateLine.add(Box.createHorizontalStrut(13));
	fromAndDateLine.add(new TopLabel("From:", from));
	fromAndDateLine.add(Box.createHorizontalStrut(3));
	fromAndDateLine.add(new TopLabel("Date:", date));

	Box subjectLine = new Box(BoxLayout.X_AXIS);
	subjectLine.add(new TopLabel("Subject:", subject));

	this.add(fromAndDateLine);
	this.add(subjectLine);
    }
}

class TopLabel extends Box
{
//Creates a line with label, free space and text box 

    TopLabel(String label, String text)
    {
	super(BoxLayout.X_AXIS);
      	this.add(new JLabel(label));
	this.add(Box.createHorizontalStrut(4));
	this.add(new JTextField(text));
    }
}


//****************//
//Top menu related classes


class EditorTopMenu extends JMenuBar
{
    //Menu and submenu items declarations

    private JMenuBar topMenuBar = new JMenuBar();
    private JMenu[] topMenus = {new JMenu("File"), new JMenu("Edit"), new JMenu("Help")};
    private JMenuItem[] fileMenuItems = {new JMenuItem("Save File")};
    
    EditorTopMenu()
    {
	//Adding Submenus//
	for (int i = 0; i < topMenus.length; i++)
	    {
	  this.add(topMenus[i]);
	    }
	
	for (int i =0; i < fileMenuItems.length; i++)
	    {
		topMenus[0].add(fileMenuItems[i]);
	    }

	this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }
}

//****************//
//Bottom buttons related classes

class BottomButtonsPanel extends JPanel
{
    BottomButton removeMailButton = new BottomButton("Remove", "Remove message.");
    BottomButton replyMailButton = new BottomButton("Reply", "Reply to sender.");
    BottomButton replyAllMailButton = new BottomButton("Reply to all", "Reply to all.");


    BottomButtonsPanel()
    {
	this.setLayout(new GridLayout(1,4,1,0));
	this.add(removeMailButton);
	this.add(replyMailButton);
	this.add(replyAllMailButton);
    }
}
