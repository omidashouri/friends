-- add for test
--drop schema if exists friends;
--create schema friends;
--show tables ;
set schema friends;

DROP TABLE IF EXISTS billionaires;

CREATE TABLE billionaires (
      id INT AUTO_INCREMENT  PRIMARY KEY,
      first_name VARCHAR(250) NOT NULL,
      last_name VARCHAR(250) NOT NULL,
      career VARCHAR(250) DEFAULT NULL
);

INSERT INTO billionaires (first_name, last_name, career) VALUES
('Aliko', 'Dangote', 'Billionaire Industrialist'),
('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');

--insert into TBL_FRIEND(ID,FIRST_NAME,LAST_NAME,AGE,MARRIED) values (default, 'omid1','ashouri1',37,FALSE )
