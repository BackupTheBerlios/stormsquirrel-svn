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
import java.util.*;

class ConfigFile
{
    List configList = Collections.synchronizedList (new ArrayList());
    List mailFilesList = Collections.synchronizedList (new ArrayList());
    String usersHome = System.getenv("HOME");
    File fileWithConfig = new File(usersHome + "/.stormsquirrel/config.conf");
    File configDir = new File (usersHome + "/.stormsquirrel");
    File mboxDir = new File (usersHome + "/.stormsquirrel/MailBoxes");

    ConfigFile()
    {
	this.checkForFile();
	this.readFile();
	System.out.println("Reading config file...");
	//TEMPORARY - CHANGE THAT
	new CreateMailBox(mboxDir+"/inbox.mbox");
    }

    void readFile()
    {
	
	try
	    {
		BufferedReader configFile = new BufferedReader(new FileReader(fileWithConfig));
		String temp;		
		
		temp = configFile.readLine();
		
		try
		    {
			while (temp !=null)
			    {
				if (temp.startsWith("inbox="))
				    {
					temp = temp.substring(6); //CHANGE TO RELATIVE VALUE
					mailFilesList.add(temp);
				    }
				else
				    {
					configList.add(temp);
				    }
				
				temp = configFile.readLine();
			    }
		    }
		catch (Exception ex) {}
		
		configFile.close();
	    }
	
	catch(IOException ex)
	    {
		ex.printStackTrace();
	    }
    }
    
    static List getFiles()
    {
	ConfigFile configFile = new ConfigFile();
	return configFile.mailFilesList;
    }

    void checkForFile()
    {
	
	if (!fileWithConfig.exists())
	    {
		System.err.println("YOU DON'T HAVE THE CONFIG FILE! CREATING A NEW ONE!");
		
		if (!configDir.isDirectory())
		    {
			configDir.mkdir();
			System.out.println("Creating Config directory.");
		    }
			
		this.createConfigFile();
	    }
    }
    
    
    void createConfigFile()
    {
	//Opens config file for writing and writes mailboxFile=.stormsquirrel/personal.mbox
	try
	    {
	    PrintWriter configFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileWithConfig)));

	    configFileWriter.print("inbox="+mboxDir+"/inbox.mbox");

	    configFileWriter.close();

	    }
	catch (IOException ex)
	    {
		System.err.println("An IOException in createConfigFile");
	    }
    }
    
}

