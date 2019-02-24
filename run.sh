#!/bin/bash

##
# Build, test and run a poker game
##

JARFILE=target/five-card-draw.jar

# only build if the jar doesn't exist
if [ ! -f $JARFILE ]; then
    mvn clean package
fi    


# validate that the jar built correctly
if [ ! -f $JARFILE ]; then
    echo "====================================================================="
    echo "ERROR: Jar file $JARFILE was not found. Did the build succeed?"
    echo "====================================================================="
    exit
fi

java -cp $JARFILE io.advance.poker.PokerRunner
