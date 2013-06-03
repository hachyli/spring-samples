



DROP TABLE IF EXISTS config_params;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS topics;
DROP TABLE IF EXISTS forums;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;

CREATE TABLE config_params 
(
  param_id bigint(20) NOT NULL auto_increment,
  param_name varchar(255) NOT NULL,
  param_value varchar(255) NOT NULL,
  description varchar(255) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (param_id),
  UNIQUE KEY param_name (param_name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE users 
(
  user_id bigint(20) NOT NULL auto_increment,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  disabled tinyint(1) NOT NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (user_id),
  UNIQUE KEY email (email),
  UNIQUE KEY username (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE categories 
(
  cat_id bigint(20) NOT NULL auto_increment,
  name varchar(255) NOT NULL,
  description varchar(255) default NULL,
  cat_order int(11) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE forums 
(
  forum_id bigint(20) NOT NULL auto_increment,
  cat_id bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
  description varchar(255) default NULL,
  forum_order int(11) default NULL,
  last_post_date datetime default NULL,
  last_post_id bigint(20) default NULL,
  last_post_user_id bigint(20) default NULL,
  last_post_username varchar(255) default NULL,
  last_topic_id bigint(20) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (forum_id),
  KEY FK7BF30B72293A0A8 (cat_id),
  CONSTRAINT FK7BF30B72293A0A8 FOREIGN KEY (cat_id) REFERENCES categories (cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE topics 
(
  topic_id bigint(20) NOT NULL auto_increment,
  forum_id bigint(20) NOT NULL,
  title varchar(255) NOT NULL,
  user_id bigint(20) NOT NULL,
  last_post_date datetime default NULL,
  last_post_id bigint(20) default NULL,
  last_post_user_id bigint(20) default NULL,
  last_post_username varchar(255) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (topic_id),
  KEY FK93D5CD24C8639660 (user_id),
  KEY FK93D5CD246FCF2654 (forum_id),
  CONSTRAINT FK93D5CD246FCF2654 FOREIGN KEY (forum_id) REFERENCES forums (forum_id),
  CONSTRAINT FK93D5CD24C8639660 FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE posts 
(
  post_id bigint(20) NOT NULL auto_increment,
  topic_id bigint(20) default NULL,
  title varchar(255) NOT NULL,
  content varchar(255) default NULL,
  user_id bigint(20) NOT NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (post_id),
  KEY FK48C83B3C8639660 (user_id),
  KEY FK48C83B31ACD8394 (topic_id),
  CONSTRAINT FK48C83B31ACD8394 FOREIGN KEY (topic_id) REFERENCES topics (topic_id),
  CONSTRAINT FK48C83B3C8639660 FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into config_params(param_id, param_name, param_value, description, created_on, updated_on) VALUES
(1,'forum_name','SivaLabs Forum','SivaLabs Forum Software','2013-06-01 00:00:00',NULL),
(2,'forum_caption','Learn and Share','A place to learn things and share knowledge','2013-06-01 00:00:00',NULL);

INSERT INTO users (user_id,created_on,disabled,email,name,password,updated_on,username) VALUES 
 (1,'2013-06-01 00:00:00',0,'admin@gmail.com','Administrator','admin',NULL,'admin'),
 (2,'2013-06-02 00:00:00',0,'sivaprasadreddy.k@gmail.com','Siva Prasad Reddy','siva',NULL,'siva'),
 (3,'2013-06-01 00:00:00',1,'neha@gmail.com','Neha','neha',NULL,'neha'),
 (4,'2013-06-01 00:00:00',1,'test@gmail.com','Test','test',NULL,'test'),
 (5,'2013-06-01 00:00:00',1,'guest@gmail.com','Guest','guest',NULL,'guest');

 
INSERT INTO categories (cat_id,created_on,description,name,cat_order,updated_on) VALUES 
 (1,'2013-06-01 00:00:00','Java Programming Language','Java',1,NULL),
 (2,'2013-06-01 00:00:00','Database Systems','Databases',2,NULL),
 (3,'2013-06-02 00:00:00','Books','Books',3,NULL);

INSERT INTO forums (forum_id,created_on,description,last_post_date,last_post_id,last_post_user_id,last_post_username,last_topic_id,name,forum_order,updated_on,cat_id) VALUES 
 (1,'2013-06-01 00:00:00','Java Standard Edition',NULL,NULL,NULL,NULL,NULL,'Java SE',1,NULL,1),
 (2,'2013-06-01 00:00:00','Java Enterprise Edition',NULL,NULL,NULL,NULL,NULL,'Java EE',2,NULL,1),
 (3,'2013-06-02 00:00:00','Spring Framework',NULL,NULL,NULL,NULL,NULL,'Spring Framework',3,NULL,1),
 (4,'2013-06-02 00:00:00','Hibernate',NULL,NULL,NULL,NULL,NULL,'Hibernate ORM Frmaework',4,NULL,1),
 (5,'2013-06-02 00:00:00','MySQL',NULL,NULL,NULL,NULL,NULL,'MySQL',1,NULL,2),
 (6,'2013-06-01 00:00:00','Oracle',NULL,NULL,NULL,NULL,NULL,'Oracle',2,NULL,2),
 (7,'2013-06-01 00:00:00','Mongo',NULL,NULL,NULL,NULL,NULL,'Mongo',3,NULL,2),
 (8,'2013-06-01 00:00:00','Spring Recipes 2nd edition',NULL,NULL,NULL,NULL,NULL,'Spring Recipes 2nd edition',1,NULL,3),
 (9,'2013-06-01 00:00:00','Java Persistence with MyBatis3',NULL,NULL,NULL,NULL,NULL,'Java Persistence with MyBatis3',2,NULL,3);


 INSERT INTO topics (topic_id,forum_id,title,user_id,last_post_date,last_post_id,last_post_user_id,last_post_username,created_on,updated_on) VALUES 
 (1,1,'Why do we need to override equals() and hashCode()?',2,NULL,NULL,NULL,NULL,'2013-06-01 00:00:00',NULL),
 (2,1,'What is the use of serialVersionId?',3,NULL,NULL,NULL,NULL,'2013-06-01 00:00:00',NULL),
 (3,2,'What is difference b/w Spring IOC and JavaEE CDI?',2,NULL,NULL,NULL,NULL,'2013-06-01 00:00:00',NULL),
 (4,3,'How to use Spring PostProcessors?',1,NULL,NULL,NULL,NULL,'2013-06-01 00:00:00',NULL),
 (5,7,'How transactions work in Mongodb?',2,NULL,NULL,NULL,NULL,'2013-06-01 00:00:00',NULL);
 
 
 INSERT INTO posts (post_id,topic_id,title,content,user_id,created_on,updated_on) VALUES 
 (1,1,'Why do we need to override equals() and hashCode()?','Why do we need to override equals() and hashCode()?',2,'2013-06-01 00:00:00',NULL),
 (2,2,'What is the use of serialVersionId?','What is the use of serialVersionId?',3,'2013-06-01 00:00:00',NULL),
 (3,3,'What is difference b/w Spring IOC and JavaEE CDI?','What is difference b/w Spring IOC and JavaEE CDI?',2,'2013-06-01 00:00:00',NULL),
 (4,4,'How to use Spring PostProcessors?','How to use Spring PostProcessors?',1,'2013-06-01 00:00:00',NULL),
 (5,5,'How transactions work in Mongodb?','How transactions work in Mongodb?',2,'2013-06-01 00:00:00',NULL),
 (6,3,'RE: What is difference b/w Spring IOC and JavaEE CDI?','Context based injection.',1,'2013-06-02 00:00:00',NULL);
