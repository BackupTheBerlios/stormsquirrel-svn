import javax.swing.*;
import java.awt.*;

//class creating a top button and setting it's style
class TopButton extends JButton
{
    TopButton(String name, String tooltip, ImageIcon icon)
    {
	super(name, icon);
	this.setToolTipText(tooltip);
	this.setHorizontalTextPosition(SwingConstants.CENTER);
	this.setVerticalTextPosition(SwingConstants.BOTTOM);
	this.setIconTextGap(0);
	this.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
    }
}

//class creating a bottom button and setting it's style

class BottomButton extends JButton
{
    
    BottomButton(String name, String tooltip, ImageIcon icon)
    {
	super(name, icon);
	this.setToolTipText(tooltip);
	this.setHorizontalTextPosition(SwingConstants.TRAILING);
	this.setVerticalTextPosition(SwingConstants.CENTER);
	this.setIconTextGap(0);
	this.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
    }

    BottomButton(String name, String tooltip)
    {
	super(name);
	this.setToolTipText(tooltip);
	this.setHorizontalTextPosition(SwingConstants.TRAILING);
	this.setVerticalTextPosition(SwingConstants.CENTER);
	this.setIconTextGap(0);
	this.setMargin(new Insets(0, 0, 2, 2)); //- sets button border
    }
}
