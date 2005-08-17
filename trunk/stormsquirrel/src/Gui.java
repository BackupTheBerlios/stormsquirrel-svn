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
import java.awt.event.*;


public class Gui extends JFrame
{ 
   public Gui()
    {
	super("Storm Squirrel");

	System.out.println("Loading GUI...");

	getContentPane().add(new MainBox(), BorderLayout.NORTH);
	getContentPane().add(new BottomTabbedPane(), BorderLayout.CENTER);
	setSize(640,480);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setVisible(true);
    }
}


class MainBox extends Box //Container for other JPanels setting everything in vertical order
{
      MainBox()
    {
	super(BoxLayout.Y_AXIS);
	this.add(new TopMenu());
	this.add(new MainButtons());
    }
}


//****************//
//Main (Top) Buttons related classes


class MainButtons extends JPanel
{
    //Button Listeners for top buttons bar
    private GetMailBL getMailBL = new GetMailBL();
    private ChangeFileBL changeFileBL = new ChangeFileBL();
    private NewMessageBL newMessageBL = new NewMessageBL();
    private AddressBookBL addressBookBL = new AddressBookBL();
    private ConfigureBL configureBL = new ConfigureBL();
    private SynchronizeMailBoxesBL synchronizeMailBoxesBL = new SynchronizeMailBoxesBL();


    public MainButtons()
    {
	TopButton getMailButton = new TopButton("Get Mail", "Get mail from server", new ImageIcon(getClass().getResource("img/getmail-icon.png")));
	getMailButton.addActionListener(getMailBL);

	TopButton changeFileButton = new TopButton("Select File", "Change your current MBox file.", new ImageIcon(getClass().getResource("img/getmail-icon.png")));
	changeFileButton.addActionListener(changeFileBL);

	TopButton newMessageButton = new TopButton("New Message", "Write a new email message.", new ImageIcon(getClass().getResource("img/newmessage-icon.png")));
	newMessageButton.addActionListener(newMessageBL);

	TopButton addressBookButton = new TopButton("Address Book", "Open personal address book.", new ImageIcon(getClass().getResource("img/addressbook-icon.png")));	
	addressBookButton.addActionListener(addressBookBL);

	TopButton configureButton = new TopButton("Configure", "Change Storm Squirrel settings.", new ImageIcon(getClass().getResource("img/configure-icon.png")));	
	configureButton.addActionListener(configureBL);

	TopButton synchronizeButton = new TopButton("Synchronize", "Synchronize MBox files.", new ImageIcon(getClass().getResource("img/synchronize-icon.png")));	
	synchronizeButton.addActionListener(synchronizeMailBoxesBL);
	

	this.setLayout(new GridLayout(1,4,1,0));

	//adds buttons to MainButtons JPanel//
	this.add(getMailButton);
	this.add(changeFileButton);
	this.add(newMessageButton);
	this.add(addressBookButton);
	this.add(configureButton);
	this.add(synchronizeButton);

    }
}


//****************//
//Top Menu related classes


class TopMenu extends JMenuBar
{
    //Menu items Action Listeners
    private ExitBL exitBL = new ExitBL();
    private ChangeFileBL changeFile = new ChangeFileBL();

    private JMenuBar topMenuBar = new JMenuBar();
    private JMenu[] topMenus = {new JMenu("File"), new JMenu("Edit"), new JMenu("Help")};
    private JMenuItem[] fileMenuItems = {new JMenuItem("Open Mailbox"), new JMenuItem("Save Mailbox"), new JMenuItem("Exit")};
    
    TopMenu()
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

	//Adding Action listeners for File Menu//

	fileMenuItems[1].addActionListener(exitBL);
	fileMenuItems[1].addActionListener(exitBL);


	this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }
}


//****************//
//Messages List realted classes


class InboxPanel extends JScrollPane
{
    private DefaultListModel lItems = new DefaultListModel();
    private JList messagesList = new JList(lItems);
    	
    InboxPanel()
    {
	addElementsToList();
	this.setViewportView(messagesList);
	messagesList.setDragEnabled(true); //enables draging for Drag'n Drop - will work some day :P//
	this.setPreferredSize(new Dimension(300, 100));
	
	////Displays Message when double clicked////
	
	MouseListener mouseListener1 = new MouseAdapter() 
	    {
		public void mouseClicked(MouseEvent e) 
		{
		    if (e.getClickCount() == 2) 
			{
			    int index = messagesList.locationToIndex(e.getPoint());
			    Editor viewer = new Editor((String)(MailBoxFile.getFile((String)(ConfigFile.getFiles()).get(0)).get(index)));
			}
		}
	    };
	
	messagesList.addMouseListener(mouseListener1);
	
    }
    
	    
    void addElementsToList()
    {
	for (int i = 0; i<(MailBoxFile.getFile((String)(ConfigFile.getFiles()).get(0))).size(); i++)
	    {
		String temp = (String)MailBoxFile.getFile((String)(ConfigFile.getFiles()).get(0)).get(i);
		lItems.addElement(temp.substring(5, temp.indexOf("\n")));
	    }    
    }

}


class BottomTabbedPane extends JTabbedPane
{
    BottomTabbedPane()
    {
	super(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
	this.add("Inbox", new InboxPanel());
	this.add("Outbox", new InboxPanel());
	this.add("Draft", new InboxPanel());
	this.add("Saved", new InboxPanel());
	this.add("MY", new InboxPanel());
	this.add("Trash", new InboxPanel());
    }
}



//Buttons Popup Menus related classes

class GetMailButtonMenu extends JPopupMenu
{
    GetMailButtonMenu()
    {
	super("Select Mailbox File:");
	this.setLocation(30,30);
	this.setVisible(false);
    }
}

//class creating a top button and setting it style
class TopButton extends JButton
{
    TopButton(String name, String tooltip, ImageIcon icon)
    {
	super(name, icon);
	this.setToolTipText(tooltip);
	this.setHorizontalTextPosition(SwingConstants.CENTER);
	this.setVerticalTextPosition(SwingConstants.BOTTOM);
	this.setIconTextGap(0);
	this.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
    }
}
