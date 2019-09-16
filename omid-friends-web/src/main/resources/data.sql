-- add for test
--drop schema if exists friends;
--create schema friends;
--show tables ;

DROP TABLE IF EXISTS friends.billionaires;

CREATE TABLE friends.billionaires (
      id INT AUTO_INCREMENT  PRIMARY KEY,
      first_name VARCHAR(250) NOT NULL,
      last_name VARCHAR(250) NOT NULL,
      career VARCHAR(250) DEFAULT NULL
);

INSERT INTO friends.billionaires (first_name, last_name, career) VALUES
('Aliko', 'Dangote', 'Billionaire Industrialist'),
('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
