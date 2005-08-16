#!/bin/sh

TODAY=$(date +%Y%m%d)
ANSWER="NO"
ANSWER2="NO"

ant clean
ant

if [ -d "./.Temp" ]; then

    echo ".Temp alredy exists!!! Check it!!!"
    exit 1

else

    mkdir ./.Temp
    mkdir ./.Temp/stormsquirrel
    cp ./dist/stormsquirrel.jar ./.Temp/stormsquirrel
    cp ./README ./.Temp/stormsquirrel
    cp ./LICENSE ./.Temp/stormsquirrel
    cp ./src/Install.sh ./.Temp/stormsquirrel

    if [ -d "./snapshots" ]; then

	echo "./snapshots exists. Today's snapshot will be overwriten!"
	echo -n "Continue? (YES/NO) > "
	read ANSWER
	
	if [ "$ANSWER" != "YES" ]; then
	    
	    exit 1
	
	fi

    else

	mkdir ./snapshots

    fi

    cd ./.Temp
    tar -cvvf ../snapshots/stormsquirrel-$TODAY.tar ./stormsquirrel
    cd ../
    bzip2 -zvf -9 ./snapshots/stormsquirrel-$TODAY.tar
    
    rm ./.Temp/stormsquirrel/*
    rmdir ./.Temp/stormsquirrel
    rmdir ./.Temp

    echo "Great! Snapshot created"
    echo
    echo -n "Do you wish to publish it at developer.berlios.de ? (YES/NO) > "
    read ANSWER2

    if [ "$ANSWER2" != "YES" ]; then
	
	exit 1
	
    else

	echo -n "Enter your developer.berlios.de login > "
	read BERLIOS_USER

	scp ./snapshots/stormsquirrel-$TODAY.tar.bz2 $BERLIOS_USER@shell.berlios.de:/home/groups/ftp/pub/stormsquirrel/stormsquirrel-$TODAY.tar.bz2
	scp ./snapshots/stormsquirrel-$TODAY.tar.bz2 $BERLIOS_USER@shell.berlios.de:/home/groups/ftp/pub/stormsquirrel/stormsquirrel-snap-latest.tar.bz2

    fi 
fi
