#!/bin/bash

echo "Compilation interface :"
javac -d classes -classpath .:classes src/Info_itf.java
cd classes
jar cvf ../libs/Info_itf.jar Info_itf.class
cd ..

javac -d classes -classpath .:classes src/Hello.java
cd classes
jar cvf ../libs/Hello.jar Hello.class
echo "Fin compile"
cd ..

echo "Compilation object distant :"
javac -d classes -classpath .:classes src/InfoImpl.java
cd classes
jar cvf ../libs/InfoImpl.jar InfoImpl.class
cd ..

javac -d classes -classpath .:classes src/HelloImpl.java
cd classes
jar cvf ../libs/HelloImpl.jar HelloImpl.class


echo "Fin compilation"

cd ..

echo "Compilation serveur :"
javac -d classes -cp .:classes:libs/Hello.jar:libs/HelloImpl.jar src/HelloServer.java

echo "Compilation Client :"
javac -d classes -cp .:classes:libs/Hello.jar:libs/HelloImpl.jar:libs/Info_itf.jar:libs/InfoImpl.jar src/HelloClient.java
