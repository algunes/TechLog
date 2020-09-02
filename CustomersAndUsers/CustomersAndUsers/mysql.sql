Mysql 8 - CREATE DATABASE techlog CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
Mysql 7 - CREATE DATABASE techlog CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

***
for UTF8 character problem add these lines to the /etc/mysql/my.cnf

[mysqld]
collation-server = utf8_unicode_ci
init-connect='SET NAMES utf8'
character-set-server = utf8

Then check the mysql server (after selecting the current database) whether use utf8 or not with this query --> status;

Output should look like

Server characterset:    utf8
Db     characterset:    utf8mb4
Client characterset:    utf8
Conn.  characterset:    utf8


***


    
