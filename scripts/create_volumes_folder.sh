#!/bin/bash

if []
mkdir /volumes
cd /volumes && chmod 777 -R .

#docker container cp dump.sql cnp_database:/var/lib/mysql/lportal.sql
 
#docker container exec cnp_database bash -c "mysql -u root -proot lportal < /var/lib/mysql/lportal.sql"