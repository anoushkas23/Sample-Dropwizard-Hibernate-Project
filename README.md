# Sample-Dropwizard-Hibernate-Project

In App configuration, set program arguments as -> server configuration.yml

To run-> In external libraries, Go to H2 folder,right click on .jar file, open with java launcher and click connect.

Create Tables in database using->
CREATE TABLE Book ( 
   ID int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   name VARCHAR(255), 
   fk_author_Id int, 
   FOREIGN KEY (fk_author_Id) REFERENCES Author(id) 
);
