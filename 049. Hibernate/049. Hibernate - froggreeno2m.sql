CREATE DATABASE `froggreeno2m` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

CREATE TABLE froggreeno2m.persondetail (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

CREATE TABLE froggreeno2m.person (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `personDetailID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`personDetailID`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`personDetailID`) REFERENCES `persondetail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

CREATE TABLE froggreeno2m.car (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carName` varchar(128) DEFAULT NULL,
  `personID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`carName`),
  KEY `FK_person_idx` (`personID`),
  CONSTRAINT `FK_person` FOREIGN KEY (`personID`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE froggreeno2m.rating (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `star` int(11) DEFAULT NULL,
  `carID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_ID_idx` (`carID`),
  CONSTRAINT `FK_COURSE` FOREIGN KEY (`carID`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;