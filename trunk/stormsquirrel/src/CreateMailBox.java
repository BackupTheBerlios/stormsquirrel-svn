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


import java.io.*;



interface FileErrors
{
    int OK = 0;
    int FILEEXISTS = 1;
}

public class CreateMailBox
{
    String usersHome = System.getenv("HOME");
    File mboxDir = new File (usersHome + "/.stormsquirrel/MailBoxes");
    
    
    CreateMailBox(String name)
    {
	if (!mboxDir.isDirectory())
	    {
		mboxDir.mkdir();
	    }
	
	if ((!(new File(name)).exists()))
	    {
		this.createFile(name);
	    }
    }
    
    
    void createFile(String name)
    {
	File newMBoxFile = new File(usersHome + "/.stormsquirrel/MailBoxes/" + name);
	
	if (!newMBoxFile.exists())
	    {
		this.addWelcomeMessage(name);
	    }
    }
    

    void addWelcomeMessage(String name)
    {
	try
	    {
		PrintWriter newMBoxFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(name)));
		System.out.println("Creating new MBox file: " + name);

		newMBoxFileWriter.println("From StormSquirrel  Mon Jan 24 07:47:55 2005");
		newMBoxFileWriter.println("Return-Path: mco@o2.pl");
		newMBoxFileWriter.println("Date: Mon, 5 Sep 2005 10:10:53 -0100 (PST)");
		newMBoxFileWriter.println("From: Storm Squirrel Developers");
		newMBoxFileWriter.println("To: YOU");
		newMBoxFileWriter.println("Subject: Welcome!");
		newMBoxFileWriter.println("MIME-Version: 1.0");
		newMBoxFileWriter.println("Content-Type: TEXT/PLAIN; charset=US-ASCII");
		newMBoxFileWriter.println("Status: RO");
		newMBoxFileWriter.println("X-Status:");
		newMBoxFileWriter.println("X-Keywords:");
		newMBoxFileWriter.println("X-UID: 3");
		newMBoxFileWriter.println();
		newMBoxFileWriter.println();
		newMBoxFileWriter.println("Hello!");
		newMBoxFileWriter.println("Thanks for using Storm Squirrel!");
		newMBoxFileWriter.println();
		newMBoxFileWriter.println("We hope you will like our software and it will be helpful in your work or fun.");
		newMBoxFileWriter.println();
		newMBoxFileWriter.println("Please remember, that Storm Squirrel is still in PreAlpha stage of development.");
		newMBoxFileWriter.println("So it still lacks of many features, still can have bugs, and even don't work at all");
		newMBoxFileWriter.println("(But if you can see this message it probably worked :-)");
		newMBoxFileWriter.println();
		newMBoxFileWriter.println("Please contact us with any thing you think could help in development: bugs,\n");
		newMBoxFileWriter.println("feature request, suggestion ...");
		newMBoxFileWriter.println();
		newMBoxFileWriter.println("Please note that Storm Squirrel is licensed under General Public License v2.");
		newMBoxFileWriter.println("If this doesn't mean anything for you please read LICENSE file which should be");
		newMBoxFileWriter.println("packed up with this software.");
		newMBoxFileWriter.println();
		newMBoxFileWriter.println("Have fun!");
		newMBoxFileWriter.println("Storm Squirrel Developers.\n");
		newMBoxFileWriter.println();

		newMBoxFileWriter.close();

	    }
	catch (IOException ex)
	    {
		System.err.println("An IOException in welcome message writing");
	    }
    }
    
}
