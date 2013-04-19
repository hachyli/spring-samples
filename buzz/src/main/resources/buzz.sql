
--
-- Create schema buzz
--

CREATE DATABASE IF NOT EXISTS buzz;
USE buzz;

--
-- Definition of table `posts`
--

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `text` varchar(1024) NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `created_on` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_posts_1` (`user_id`),
  CONSTRAINT `FK_posts_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `posts`
--

/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`id`,`text`,`user_id`,`created_on`) VALUES 
 (1,'Sample Post 1',1,'2013-04-18 21:44:51'),
 (2,'Sample Post 2',1,'2013-04-18 21:45:29');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`) VALUES 
 (1,'siva'),
 (2,'test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

