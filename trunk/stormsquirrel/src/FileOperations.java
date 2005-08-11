import java.io.*;
import java.util.*;
import javax.mail.*;

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


