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
-- Create schema bookstore
--

CREATE DATABASE IF NOT EXISTS bookstore;
USE bookstore;

--
-- Definition of table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `cat_id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `description` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `updated_on` datetime default NULL,
  PRIMARY KEY  (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`cat_id`,`created_on`,`description`,`name`,`updated_on`) VALUES 
 (1,'2013-08-27 00:00:00','Java Programming Books','Java Books',NULL),
 (2,'2013-08-27 00:00:00','MS.NET Programming Books','.NET Books',NULL),
 (3,'2013-08-27 00:00:00','General Books','General Books',NULL);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;


--
-- Definition of table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `cust_id` int(11) NOT NULL auto_increment,
  `addr_line1` varchar(255) default NULL,
  `addr_line2` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `country` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `zip_code` varchar(255) default NULL,
  `created_on` datetime default NULL,
  `email` varchar(255) default NULL,
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `updated_on` datetime default NULL,
  PRIMARY KEY  (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


--
-- Definition of table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `min_threshold_level` decimal(19,2) default NULL,
  `quantity` bigint(20) NOT NULL,
  `updated_on` datetime default NULL,
  `product_id` int(11) default NULL,
  PRIMARY KEY  (`inv_id`),
  KEY `FK8790195CA6AA8A7D` (`product_id`),
  CONSTRAINT `FK8790195CA6AA8A7D` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`inv_id`,`created_on`,`min_threshold_level`,`quantity`,`updated_on`,`product_id`) VALUES 
 (1,'2013-08-27 19:54:56','100.00',50,NULL,1),
 (2,'2013-08-27 19:54:56','100.00',50,NULL,2),
 (3,'2013-08-27 19:54:56','100.00',50,NULL,3),
 (4,'2013-08-27 19:54:56','100.00',50,NULL,4),
 (5,'2013-08-27 19:54:56','100.00',50,NULL,5),
 (6,'2013-08-27 19:54:56','100.00',50,NULL,6),
 (7,'2013-08-27 19:54:56','100.00',50,NULL,7),
 (8,'2013-08-27 19:54:56','100.00',50,NULL,8),
 (9,'2013-08-27 19:54:56','100.00',50,NULL,9),
 (10,'2013-08-27 19:54:56','100.00',50,NULL,10),
 (11,'2013-08-27 19:54:56','100.00',50,NULL,11),
 (12,'2013-08-27 19:54:56','100.00',50,NULL,12),
 (13,'2013-08-27 19:54:56','100.00',50,NULL,13),
 (14,'2013-08-27 19:54:56','100.00',50,NULL,14),
 (15,'2013-08-27 19:54:56','100.00',50,NULL,15);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;


--
-- Definition of table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
  `order_item_id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `quantity` int(11) NOT NULL,
  `updated_on` datetime default NULL,
  `product_id` int(11) default NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY  (`order_item_id`),
  KEY `FK75109F8FD1BE6DD` (`order_id`),
  KEY `FK75109F8FA6AA8A7D` (`product_id`),
  CONSTRAINT `FK75109F8FA6AA8A7D` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `FK75109F8FD1BE6DD` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_items`
--

/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;


--
-- Definition of table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL auto_increment,
  `created_on` datetime NOT NULL,
  `status` int(11) default NULL,
  `updated_on` datetime default NULL,
  `cust_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FKC3DF62E581DEDF1D` (`payment_id`),
  KEY `FKC3DF62E532DE0E1C` (`recipient_id`),
  KEY `FKC3DF62E52ABA97A2` (`cust_id`),
  CONSTRAINT `FKC3DF62E52ABA97A2` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`cust_id`),
  CONSTRAINT `FKC3DF62E532DE0E1C` FOREIGN KEY (`recipient_id`) REFERENCES `customers` (`cust_id`),
  CONSTRAINT `FKC3DF62E581DEDF1D` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


--
-- Definition of table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `cc_number` varchar(255) default NULL,
  `cvv` varchar(255) default NULL,
  `expiry_date` datetime default NULL,
  `updated_on` datetime default NULL,
  PRIMARY KEY  (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;


--
-- Definition of table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `product_id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `description` varchar(255) default NULL,
  `image_url` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `price` decimal(19,2) default NULL,
  `updated_on` datetime default NULL,
  `cat_id` int(11) default NULL,
  PRIMARY KEY  (`product_id`),
  KEY `FKC42BD16474DE085F` (`cat_id`),
  CONSTRAINT `FKC42BD16474DE085F` FOREIGN KEY (`cat_id`) REFERENCES `categories` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`product_id`,`created_on`,`description`,`image_url`,`name`,`price`,`updated_on`,`cat_id`) VALUES 
 (1,'2013-08-28 00:00:00','Java Persistence with MyBatis 3','MyBatis3.jpg','Java Persistence with MyBatis 3','500.00',NULL,1),
 (2,'2013-08-28 00:00:00','PrimeFaces Beginner\'s Guide: RAW','PFBG_Raw.jpg','PrimeFaces Beginner\'s Guide','680.00',NULL,1),
 (3,'2013-08-28 00:00:00','CleanCode','CleanCode.jpg','CleanCode','4000.00',NULL,1),
 (4,'2013-08-28 00:00:00','FirstLookatC#4.5.jpg','FirstLookatCSharp4.5.jpg','FirstLookatC#4.5.','650.00',NULL,2),
 (5,'2013-08-28 00:00:00','HibernateInAction','HibernateInAction.jpg','HibernateInAction','480.00',NULL,1),
 (6,'2013-08-28 00:00:00','JSF2_Cookbook','JSF2_Cookbook.jpg','JSF2_Cookbook','560.00',NULL,1),
 (7,'2013-08-28 00:00:00','PF_Cookbook','PF_Cookbook.jpg','PF_Cookbook','750.00',NULL,1),
 (8,'2013-08-28 00:00:00','PF_Starter','PF_Starter.jpg','PF_Starter.jpg','150.00',NULL,1),
 (9,'2013-08-28 00:00:00','ProSpring3','ProSpring3.jpg','ProSpring3','450.00',NULL,1),
 (10,'2013-08-28 00:00:00','Spring Recipies','SpringRecipies.jpg','Spring Recipies','2500.00',NULL,1),
 (11,'2013-08-28 00:00:00','Visual Studio 2012 Cookbook','VS2012Cookbook.jpg','Visual Studio 2012 Cookbook','1200.00',NULL,2),
 (12,'2013-08-28 00:00:00','The Monk Who Sold His Ferrari',NULL,'The Monk Who Sold His Ferrari','600.00',NULL,3),
 (13,'2013-08-28 00:00:00','Who Will Cry When You Die?',NULL,'Who Will Cry When You Die?','600.00',NULL,3),
 (14,'2013-08-28 00:00:00','The Alchemist',NULL,'The Alchemist','600.00',NULL,3),
 (15,'2013-08-28 00:00:00','Life is What You Make it',NULL,'Life is What You Make it','600.00',NULL,3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
