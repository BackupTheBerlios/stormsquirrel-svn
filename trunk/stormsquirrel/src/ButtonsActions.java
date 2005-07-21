import java.awt.event.*;

class GetMailBL implements ActionListener
{
    GetMailButtonMenu menu = new GetMailButtonMenu();
    public void actionPerformed(ActionEvent e)
    {
	menu.add("Dupa");
	menu.setVisible(true);
    }
}

class NewMessageBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Edytor Tekstu");
    }
}

class AddressBookBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Ksiazka adresowa");
    }
}

class SynchronizeMailBoxesBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Synchronizacja skrzynek");
    }
}



class ExitBL implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.exit(0);
    }
}
