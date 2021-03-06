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

DESTDIR="/"
PROGRAMDIR="stormsquirrel"
EXECUTABLEDIR=$DESTDIR"usr/local/bin"
INSTALLDIR=$DESTDIR"usr/local/lib/$PROGRAMDIR"
STORMSQUIRREL_CLASSPATH=$INSTALLDIR"/stormsquirrel.jar"
ANSWER="NO"
ANSWEREXEC="NO"

#Check if user is root

    if [ $(id -u) != "0" ]; then
    echo "Sorry you must be root to install Storm Squirrel"
    exit 1
    fi
    

#Check if install dir exists

if [ -d "$INSTALLDIR" ]; then
    echo "Install directory already exists!"
    echo -n "If you still want to install type YES here >"
    read ANSWER
    
    if [ "$ANSWER" != "YES" ]; then
    echo "Sorry. Check INSTALLDIR variable in install.sh script"
    exit 1
    fi

fi

#Check if executable exists

if [ -f "$EXECUTABLEDIR/stormsquirrel" ]; then
    echo "Executable already exists!"
    echo -n "If you still want to install (it will be overwriten) type YES here >"
    read ANSWEREXEC
    
    if [ "$ANSWEREXEC" != "YES" ]; then
    echo "Sorry. Check EXECUTABLEDIR variable in install.sh script"
    exit 0
    fi

fi

#Compile Storm Squirrel using Apache-Ant and Sun's JDK

echo "Compiling Storm Squirrel..."

ant clean
ant

echo "Great Storm Squirrel compiled. Now trying to install..."

if [ -d "$INSTALLDIR" ]; then
    echo "Installing in old directory..."    
else
    echo "Creating INSTALLDIR..."
    mkdir "$INSTALLDIR"
fi

if [ -f "$INSTALLDIR/stormsquirrel.jar" ]; then
    echo "Removing old files"
    rm $INSTALLDIR/stormsquirrel.jar
fi

if [ -f "$INSTALLDIR/README" ]; then
    rm $INSTALLDIR/README
fi

if [ -f "$INSTALLDIR/LICENSE" ]; then
    rm $INSTALLDIR/LICENSE
fi

echo "Copying stormsquirrel.jar to INSTALLDIR"
cp dist/stormsquirrel.jar $INSTALLDIR/stormsquirrel.jar
cp README $INSTALLDIR/README
cp LICENSE $INSTALLDIR/LICENSE

echo "Great everything is copied. Now creating executable script..."

if [ -f "$EXECUTABLEDIR/stormsquirrel" ]; then
    rm $EXECUTABLEDIR/stormsquirrel
fi

touch $EXECUTABLEDIR/stormsquirrel
echo "#!/bin/sh" > $EXECUTABLEDIR/stormsquirrel
echo "java -cp "$STORMSQUIRREL_CLASSPATH" -jar "$INSTALLDIR"/stormsquirrel.jar" >> $EXECUTABLEDIR/stormsquirrel
chmod +x $EXECUTABLEDIR/stormsquirrel

echo "If you have not seen any errors, than Storm Squirrel should work. Thanks for trying Storm Squirrel."
echo
