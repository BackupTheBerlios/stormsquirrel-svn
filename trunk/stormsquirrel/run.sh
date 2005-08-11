#!/bin/sh

STORMSQUIRREL_CLASSPATH="dist/stormsquirrel.jar"

ant clean
ant
java -cp $STORMSQUIRREL_CLASSPATH -jar dist/stormsquirrel.jar