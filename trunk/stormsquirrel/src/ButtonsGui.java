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
//Two constructors aviable. First creates button with icon, second without.
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
