import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame
{ 
   public Gui()
    {
	super("Storm Squirrel");

	System.out.println("Loading GUI...");

	getContentPane().add(new MainBox(), BorderLayout.NORTH);
	getContentPane().add(new BottomTabbedPane(), BorderLayout.CENTER);
	setSize(640,480);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setVisible(true);
    }
}


class MainBox extends Box //Container for other JPanels setting everything in vertical order
{
      MainBox()
    {
	super(BoxLayout.Y_AXIS);
	this.add(new TopMenu());
	this.add(new MainButtons());
    }
}


//****************//
//Main (Top) Buttons related classes


class MainButtons extends JPanel
{
    private GetMailBL getMailBL = new GetMailBL();
    private NewMessageBL newMessageBL = new NewMessageBL();
    private AddressBookBL addressBookBL = new AddressBookBL();
    private SynchronizeMailBoxesBL synchronizeMailBoxesBL = new SynchronizeMailBoxesBL();    

    public MainButtons()
    {
	JButton getMailButton = new JButton("Get Mail", new ImageIcon(getClass().getResource("/img/getmail-icon.png")));
	getMailButton.setToolTipText("Gets your new mail with your custom set command");
	getMailButton.setHorizontalTextPosition(SwingConstants.CENTER);
	getMailButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	getMailButton.setIconTextGap(0);
	getMailButton.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
	getMailButton.addActionListener(getMailBL);

	JButton newMessageButton = new JButton("New Message", new ImageIcon(getClass().getResource("/img/newmessage-icon.png")));
	newMessageButton.setToolTipText("Opens the message editor");
	newMessageButton.setHorizontalTextPosition(SwingConstants.CENTER);
	newMessageButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	newMessageButton.setIconTextGap(0);
	newMessageButton.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
	newMessageButton.addActionListener(newMessageBL);

	JButton addressBookButton = new JButton("Address Book", new ImageIcon(getClass().getResource("/img/addressbook-icon.png")));
	addressBookButton.setToolTipText("Opens your Address Book");
	addressBookButton.setHorizontalTextPosition(SwingConstants.CENTER);
	addressBookButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	addressBookButton.setIconTextGap(0);
	addressBookButton.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
	addressBookButton.addActionListener(addressBookBL);

	JButton synchronizeButton = new JButton("Synchronize", new ImageIcon(getClass().getResource("/img/synchronize-icon.png")));
	synchronizeButton.setToolTipText("Synchronizes Mail Boxes");
	synchronizeButton.setHorizontalTextPosition(SwingConstants.CENTER);
	synchronizeButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	synchronizeButton.setIconTextGap(0);
	synchronizeButton.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
	synchronizeButton.addActionListener(synchronizeMailBoxesBL);
	
	JButton configureButton = new JButton("Configure", new ImageIcon(getClass().getResource("/img/configure-icon.png")));
	configureButton.setToolTipText("Configure Storm Squirrel");
	configureButton.setHorizontalTextPosition(SwingConstants.CENTER);
	configureButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	configureButton.setIconTextGap(0);
	configureButton.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
	//configureButton.addActionListener(synchronizeMailBoxesBL);


	this.setLayout(new GridLayout(1,4,1,0));

	//adds buttons to MainButtons JPanel//
	this.add(getMailButton);
	this.add(newMessageButton);
	this.add(addressBookButton);
	this.add(configureButton);
	this.add(synchronizeButton);

    }
}


//****************//
//Top Menu related classes


class TopMenu extends JMenuBar
{
    private GetMailBL getMailBL = new GetMailBL();
    private ExitBL exitBL = new ExitBL();

    private JMenuBar topMenuBar = new JMenuBar();
    private JMenu[] topMenus = {new JMenu("File"), new JMenu("Edit"), new JMenu("Help")};
    private JMenuItem[] fileMenuItems = {new JMenuItem ("Open Mailbox"), new JMenuItem("Save Mailbox"), new JMenuItem("Exit")};
    
    TopMenu()
    {
	//Adding Submenus//
	for (int i = 0; i < topMenus.length; i++)
	    {
	  this.add(topMenus[i]);
	    }
	
	for (int i =0; i < fileMenuItems.length; i++)
	    {
		topMenus[0].add(fileMenuItems[i]);
	    }

	//Adding Action listeners for File Menu//

	fileMenuItems[0].addActionListener(getMailBL);
	fileMenuItems[1].addActionListener(getMailBL);
	fileMenuItems[2].addActionListener(exitBL);


	this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }
}


//****************//
//Messages List realted classes


class InboxPanel extends JScrollPane
{
    private DefaultListModel lItems = new DefaultListModel();
    private JList messagesList = new JList(lItems);
    	
    InboxPanel()
    {
	addElementsToList();
	this.setViewportView(messagesList);
	messagesList.setDragEnabled(true); //enables draging for Drag'n Drop - will work some day :P//
	this.setPreferredSize(new Dimension(300, 100));
	
	////Displays Message when double clicked////
	
	MouseListener mouseListener1 = new MouseAdapter() 
	    {
		public void mouseClicked(MouseEvent e) 
		{
		    if (e.getClickCount() == 2) 
			{
			    int index = messagesList.locationToIndex(e.getPoint());
			    Editor viewer = new Editor((String)(MailBoxFile.getFile((String)(ConfigFile.getFiles()).get(0)).get(index)));
			}
		}
	    };
	
	messagesList.addMouseListener(mouseListener1);
	
    }
    
	    
    void addElementsToList()
    {
	for (int i = 0; i<(MailBoxFile.getFile((String)(ConfigFile.getFiles()).get(0))).size(); i++)
	    {
		String temp = (String)MailBoxFile.getFile((String)(ConfigFile.getFiles()).get(0)).get(i);
		lItems.addElement(temp.substring(5, temp.indexOf("\n")));
	    }    
    }

}


class BottomTabbedPane extends JTabbedPane
{
    BottomTabbedPane()
    {
	super(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
	this.add("Inbox", new InboxPanel());
	this.add("Outbox", new InboxPanel());
	this.add("Draft", new InboxPanel());
	this.add("Saved", new InboxPanel());
	this.add("MY", new InboxPanel());
	this.add("Trash", new InboxPanel());
    }
}



//Buttons Popup Menus related classes

class GetMailButtonMenu extends JPopupMenu
{
    GetMailButtonMenu()
    {
	super("Select Mailbox File:");
	this.setLocation(30,30);
	this.setVisible(false);
    }
}
