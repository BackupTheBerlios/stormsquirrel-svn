###########################################################################
#   Copyright (C) 2005 by Marek Piechut                                   #
#   mco (at) o2 (dot) pl                                                  #
#                                                                         #
#   This program is free software; you can redistribute it and/or modify  #
#   it under the terms of the GNU General Public License as published by  #
#   the Free Software Foundation; either version 2 of the License, or     #
#   (at your option) any later version.                                   #
#                                                                         #
#   This program is distributed in the hope that it will be useful,       #
#   but WITHOUT ANY WARRANTY; without even the implied warranty of        #
#   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         #
#   GNU General Public License for more details.                          #
#                                                                         #
#   You should have received a copy of the GNU General Public License     #
#   along with this program; if not, write to the                         #
#   Free Software Foundation, Inc.,                                       #
#   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             #
###########################################################################

#!/bin/sh

STORMSQUIRREL_CLASSPATH="dist/stormsquirrel.jar:/usr/share/java/activation.jar:/usr/share/java/gnu-crypto.jar:/gnumail-providers.jar:/usr/share/java/gnumail.jar:/usr/share/java/inetlib.jar:/usr/share/java/javax-crypto.jar:/usr/share/java/javax-net.jar:/usr/share/java/javax-security-cert.jar:/usr/share/java/javax-security.jar:/usr/share/java/org-metastatic-jessie.jar"

ant clean
ant
java -cp $STORMSQUIRREL_CLASSPATH -jar dist/stormsquirrel.jar
