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
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Address Book");
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
