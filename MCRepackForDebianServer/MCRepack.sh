#!/bin/bash

echo "########################################"
echo "########################################"
echo "#### MCRepack Debian Server Edition ####"
echo "########################################"
echo "########################################"
echo -e "\n"

echo "prepare your system to run WoW Realms <1>"
echo "add new Realm <2>"
echo "manage Realms <3>"
read -p "" -n1 opt

if [ "$opt" = "1" ]; then
apt-get install screen -y
clear
screen -AmdS install apt-get -y install build-essential autoconf libtool gcc g++ make cmake git-core patch wget links zip unzip unrar
echo "install build-essential"
sleep 1
echo "install autoconf"
sleep 1
echo "install libtool"
sleep 1
echo "install gcc"
sleep 1
echo "install g++"
sleep 1
echo "install make"
sleep 1
echo "install cmake"
sleep 1
echo "install git-core"
sleep 1
echo "install patch"
sleep 1
echo "install wget"
sleep 1
echo "install links"
sleep 1
echo "install zip"
sleep 1
echo "install unzip"
sleep 1
echo "install unrar"
sleep 1

screen -AmdS install2 apt-get install -y openssl libssl-dev libmysqlclient15-dev libmysql++-dev libreadline6-dev zlib1g-dev libbz2-dev mysql-client
echo "install mysql-client"
sleep 1
echo "install openssl libs"
sleep 1
echo "install mysql libs"
sleep 1

echo "Download ACE Lib"
mkdir /opt/temp
cd /opt/temp
wget http://download.dre.vanderbilt.edu/previous_versions/ACE-6.0.0.tar.gz
tar xvzf ACE-6.0.0.tar.gz
cd ACE_wrappers/
mkdir build
cd build

read -p "Press any key to install ACE. DO NOT ESCAPE THE INSTALLATION!" -n1
../configure --disable-ssl
make
make install

cd /opt/temp/
wget http://openssl.org/source/openssl-0.9.8o.tar.gz
tar -xvf openssl-0.9.8o.tar.gz
cd openssl-0.9.8o

read -p "Press any key to install OpenSSL. DO NOT ESCAPE THE INSTALLATION!" -n1

./config shared
make
make install

echo "Installation of Libs was successful!"
read -p "Do you want to install a MySQL Database Server? (is needed for WoW Server) <Yes | No>" mysqlinstall

if [ "$mysqlinstall" = "Yes" ]; then
apt-get install mysql-server
fi
fi
