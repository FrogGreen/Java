DROP DATABASE  IF EXISTS `froggreenSpringSecurity`;

CREATE DATABASE  IF NOT EXISTS `froggreenSpringSecurity`;
USE `froggreenSpringSecurity`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
('none','{bcrypt}$2a$04$yJGNlObU8X.1wXWX6OML2eGZlSKZmUp7hyAlpuLwr2k8K4LKG1AAy',1),
('user','{bcrypt}$2a$04$X/65EfwGYlxqQjgXu6TpneFE68yhnSeC2td9ctZb24prCa6SVEhiK',1),
('admin','{bcrypt}$2a$04$Z5DrjjZ8FA1Fx3ECqeIoIukYbtysOpje2abgojgvXyob1yxIOdpOa',1),
('tester','{bcrypt}$2a$04$74JrEDjKdXv0mszmTr./8OzB9IQHEceE8ysgB/dqgnmqNLQ85tiyW',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES
('none','ROLE_none'),
('user','ROLE_none'),
('admin','ROLE_none'),
('tester','ROLE_none'),
('user','ROLE_user'),
('admin','ROLE_user'),
('tester','ROLE_user'),
('admin','ROLE_admin'),
('tester','ROLE_admin'),
('tester','ROLE_tester');