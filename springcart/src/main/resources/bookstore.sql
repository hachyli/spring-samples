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
-- Definition of table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
CREATE TABLE `addresses` (
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `addrLine1` varchar(255) default NULL,
  `addrLine2` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `country` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `zipCode` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addresses`
--

/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;


--
-- Definition of table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `description` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`id`,`created_on`,`updated_on`,`description`,`name`) VALUES 
 (1,'2013-03-10 00:00:00',NULL,'Java Books','Java Books'),
 (2,'2013-03-10 00:00:00',NULL,'DotNet Books','Dot Net Books');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;


--
-- Definition of table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `email` varchar(255) default NULL,
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `addr_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK6268C35CBE94943` (`addr_id`),
  CONSTRAINT `FK6268C35CBE94943` FOREIGN KEY (`addr_id`) REFERENCES `addresses` (`id`)
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
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `min_threshold_level` bigint(20) default NULL,
  `quantity` bigint(20) NOT NULL,
  `product_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK2DA8293CAAC4C080` (`product_id`),
  CONSTRAINT `FK2DA8293CAAC4C080` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`id`,`created_on`,`updated_on`,`min_threshold_level`,`quantity`,`product_id`) VALUES 
 (1,'2013-03-10 00:00:00',NULL,50,340,1),
 (2,'2013-03-10 00:00:00',NULL,25,50,2),
 (3,'2013-03-10 00:00:00',NULL,100,400,3),
 (4,'2013-03-10 00:00:00',NULL,150,500,4);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;


--
-- Definition of table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `quantity` int(11) NOT NULL,
  `product_id` int(11) default NULL,
  `order_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK2BFF474F341C1A0` (`order_id`),
  KEY `FK2BFF474FAAC4C080` (`product_id`),
  CONSTRAINT `FK2BFF474F341C1A0` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK2BFF474FAAC4C080` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
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
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime NOT NULL,
  `updated_on` datetime default NULL,
  `status` int(11) default NULL,
  `cust_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK8B7256E585F91520` (`payment_id`),
  KEY `FK8B7256E5A9E721FF` (`cust_id`),
  KEY `FK_orders_3` (`recipient_id`),
  CONSTRAINT `FK8B7256E585F91520` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`id`),
  CONSTRAINT `FK8B7256E5A9E721FF` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `FK_orders_3` FOREIGN KEY (`recipient_id`) REFERENCES `customers` (`id`)
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
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `creditCardNumber` varchar(255) default NULL,
  `cvv` varchar(255) default NULL,
  `expiryDate` datetime default NULL,
  PRIMARY KEY  (`id`)
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
  `id` int(11) NOT NULL auto_increment,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `description` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `price` decimal(19,2) default NULL,
  `cat_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKF2D1C164F40A92BC` (`cat_id`),
  CONSTRAINT `FKF2D1C164F40A92BC` FOREIGN KEY (`cat_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`,`created_on`,`updated_on`,`description`,`name`,`price`,`cat_id`) VALUES 
 (1,'2013-03-10 00:00:00',NULL,'Pro Spring 3','Pro Spring 3','500.00',1),
 (2,'2013-03-10 00:00:00',NULL,'Clean Code','Clean Code','750.00',1),
 (3,'2013-03-10 00:00:00',NULL,'First Look at C# 4.5','First Look at C# 4.5','560.00',2),
 (4,'2013-03-12 00:00:00',NULL,'Hibernate In Action','Hibernate In Action','360.00',1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
