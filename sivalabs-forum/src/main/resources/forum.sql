-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema forum
--

CREATE DATABASE IF NOT EXISTS forum;
USE forum;

--
-- Definition of table `forums`
--

DROP TABLE IF EXISTS `forums`;
CREATE TABLE `forums` (
  `forum_id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `forum_name` varchar(255) default NULL,
  PRIMARY KEY  (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forums`
--

/*!40000 ALTER TABLE `forums` DISABLE KEYS */;
INSERT INTO `forums` (`forum_id`,`description`,`forum_name`) VALUES 
 (1,'Spring framework discussions.','Spring'),
 (2,'Hibernate replated discussions','Hibernate');
/*!40000 ALTER TABLE `forums` ENABLE KEYS */;


--
-- Definition of table `posts`
--

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `post_id` bigint(20) NOT NULL auto_increment,
  `message` varchar(255) default NULL,
  `posted_by` bigint(20) default NULL,
  `posted_on` datetime default NULL,
  `title` varchar(255) default NULL,
  `topic_id` bigint(20) default NULL,
  PRIMARY KEY  (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `posts`
--

/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`post_id`,`message`,`posted_by`,`posted_on`,`title`,`topic_id`) VALUES 
 (1,'Hello Spring gurus, have fun on JBulletinBoard :-)',1,'2011-07-22 00:00:00','My first topic in Spring forum',1),
 (2,'Hello Hibernate',1,'2011-07-22 00:00:00','My first Hibernate post',2),
 (3,'How to use <one-to-one>',2,'2011-07-21 00:00:00','How to use <one-to-one> in hibernate?',3);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;


--
-- Definition of table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(25) NOT NULL default '',
  `description` varchar(100) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`role_id`,`role_name`,`description`) VALUES 
 (1,'SUPER_ADMIN','Super Administrator'),
 (2,'ADMIN','Administrator'),
 (3,'USER','Normal User');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


--
-- Definition of table `topics`
--

DROP TABLE IF EXISTS `topics`;
CREATE TABLE `topics` (
  `topic_id` bigint(20) NOT NULL auto_increment,
  `forum_id` bigint(20) default NULL,
  `posted_on` datetime default NULL,
  `started_by` bigint(20) default NULL,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `topics`
--

/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` (`topic_id`,`forum_id`,`posted_on`,`started_by`,`title`) VALUES 
 (1,1,'2011-07-22 00:00:00',1,'My first Topic on Spring Forum'),
 (2,2,'2011-07-22 00:00:00',1,'Need help on Hibernate Criteria usage.'),
 (3,2,'2011-07-21 00:00:00',2,'How to use <one-to-one> mapping in Hibernate?');
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL auto_increment,
  `active` bit(1) default NULL,
  `dob` datetime default NULL,
  `email_id` varchar(255) default NULL,
  `firstname` varchar(255) default NULL,
  `lastname` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `role_id` bigint(20) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`,`active`,`dob`,`email_id`,`firstname`,`lastname`,`password`,`phone`,`role_id`,`username`) VALUES 
 (1,0x01,'1983-06-25 00:00:00','sadmin@sivalabs.com','SuperAdministrator',NULL,'sadmin','9000510456',1,'sadmin'),
 (2,0x01,NULL,'admin@sivalabs.com','Administrator','','admin','1234564561',2,'admin'),
 (3,0x01,NULL,'test@gmail.com','TestUser',NULL,'test','0000000',3,'test'),
 (4,0x00,NULL,'siva@gmail.com','Siva','Prasad','siva',NULL,0,'siva'),
 (5,0x00,'2004-06-16 00:00:00','','teswt','','test',NULL,0,'test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
