CREATE DATABASE IF NOT EXISTS `froggreenspringbootthymeleafcrud`;

DROP TABLE IF EXISTS froggreenspringbootthymeleafcrud.person;
CREATE TABLE froggreenspringbootthymeleafcrud.person (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

INSERT INTO froggreenspringbootthymeleafcrud.person VALUES 
	(1,'Lucas','Zimmerman','lucas.zimmerman@gmail.com'),
	(2,'Dominik','Theiss','dominik.theiss@gmail.com'),
	(3,'Eric','Huber','eric.huber@gmail.com'),
	(4,'Manuela','Bosch','manuela.bosch@gmail.com'),
	(5,'Barbara','Fink','barbara.fink@gmail.com'),
	(6,'Klaudia','Fiedler','klaudia.fiedler@gmail.com');