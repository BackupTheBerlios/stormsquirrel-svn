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

import java.awt.event.*;

class GetMailBL implements ActionListener
{
    GetMailButtonMenu menu = new GetMailButtonMenu();
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Get Mail");    
    }
}

class ChangeFileBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Changing MBox File");
    }
}

class NewMessageBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Text Editor");
    }
}

class AddressBookBL implements ActionListener
{
//    public static AddressBookGui addressBook = new AddressBookGui();

    public void actionPerformed(ActionEvent e)
    {
//	addressBook.setVisible(true);
    }
}

class SynchronizeMailBoxesBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Synchronize");
    }
}

class ConfigureBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Configuration dialog.");
    }
}

class ExitBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.exit(0);
    }
}
