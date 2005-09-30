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


class MailBoxFile
{
    List mailList = Collections.synchronizedList (new ArrayList());
    private StringBuffer oneMail = new StringBuffer();


    MailBoxFile(String fileName)
    {
	System.out.println("Reading your mbox files...");
	this.readFile(fileName);
    }
    
    public static List getFile(String file)
    {
	MailBoxFile usersFile = new MailBoxFile(file);
	return usersFile.mailList;
    }

    void readFile(String fileName)
    {
	
	File tryMailFile = new File(fileName);
	if (!tryMailFile.exists())
	    {
		System.err.println("MAIL FILE SPECIFIED IN CONFIG FILE DOES NOT EXIST! CHECK YOUR CONFIGURATION!");
		System.exit(1);
	    }
	    
	try
	    {
		BufferedReader mailFile = new BufferedReader(new FileReader(fileName));
		String temp;
		
		
		temp = mailFile.readLine();
		
		try
		    {
			
////Read mails from file and add them separatly as Strings to ArrayList////

			while (true)
			    {
				do
				    {
					oneMail.append(temp);
					oneMail.append("\n");
					temp = mailFile.readLine();
				    }    			
				while(temp.startsWith("From ") == false);
				
				mailList.add(oneMail.toString());
				oneMail.delete(0, oneMail.length());//czy oby na pewno to jest madre? moze lepiej przypisac nowy obiekt do referencji?
			    }
		    }
		catch (Exception ex) {mailList.add(new String(oneMail.toString()));}
		
		mailFile.close();
		
////Remove leading > in >From ////...OR MAYBE BETTER LEAVE IT?!?
/*
		for (int i = 0; i < mailList.size(); i++)
		    {
			temp = ((String)mailList.get(i)).replace("\n>From " , "\nFrom ");
			mailList.set(i, temp);
		    }
*/

	    }
	
	catch(IOException ex)
	    {
		ex.printStackTrace();
	    }
    }
    
}
