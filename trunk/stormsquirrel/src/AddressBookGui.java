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


public class AddressBookGui extends JFrame
{
    AddressBookGui()
    {
	super("-- Address Book --");
	setVisible(true);
	System.out.println("Loading address book gui...");
	getContentPane().add(new AddressBookBox(), BorderLayout.NORTH);
	setSize(640,480);
    }
}


class AddressBookBox extends Box
{
    AddressBookBox()
    {
	super(BoxLayout.Y_AXIS);
	this.add(new AddressBookTopButtons());
    }
}

class AddressBookTopButtons extends JPanel
{
    AddressBookTopButtons()
    {
	this.setLayout(new GridLayout(1,4,1,0));

	TopButton addContactButton = new TopButton("Add Contact", "Add new contact.", new ImageIcon(getClass().getResource("img/getmail-icon.png")));

	TopButton editContactButton = new TopButton("Edit Contact", "Edit contact.", new ImageIcon(getClass().getResource("img/getmail-icon.png")));

	TopButton deleteContactButton = new TopButton("Delete Contact", "Delete contact.", new ImageIcon(getClass().getResource("img/getmail-icon.png")));

	TopButton sendToSelectedButton = new TopButton("Send to selected", "Send new email to selected contacts..", new ImageIcon(getClass().getResource("img/getmail-icon.png")));

	this.add(addContactButton);
	this.add(editContactButton);
	this.add(deleteContactButton);
	this.add(sendToSelectedButton);
    }
}
