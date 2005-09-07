import javax.swing.*;
import java.awt.*;

public class AddressBookGui extends JFrame
{
    AddressBookGui()
    {
	super("-- Address Book --");
	setVisible(false);
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
