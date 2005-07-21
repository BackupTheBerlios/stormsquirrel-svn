import java.io.*;
import java.util.*;

class ConfigFile
{
    List configList = Collections.synchronizedList (new ArrayList());
    List mailFilesList = Collections.synchronizedList (new ArrayList());
    String usersHome = System.getenv("HOME");


    ConfigFile()
    {
	System.out.println("Reading config file...");
	this.readFile();
    }

    void readFile()
    {
	
	try
	    {
		BufferedReader configFile = new BufferedReader(new FileReader("/home/marcus/.StormSquirrel/config.conf"));
		String temp;		
		
		temp = configFile.readLine();
		
		try
		    {
			while (temp !=null)
			    {
				if (temp.startsWith("mailFile="))
				    {
					temp = temp.substring(9);
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
}
