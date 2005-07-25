import java.awt.event.*;

class GetMailBL implements ActionListener
{
    GetMailButtonMenu menu = new GetMailButtonMenu();
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Change mbox");    
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



class ExitBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.exit(0);
    }
}
