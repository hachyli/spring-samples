
USE jbb;


DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS topics;
DROP TABLE IF EXISTS forums;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;


/*Table structure for table users */


CREATE TABLE users 
(
  user_id int(11) NOT NULL AUTO_INCREMENT,
  created_on datetime DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  updated_on datetime DEFAULT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY username (username),
  UNIQUE KEY email (email)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table users */

insert  into users(user_id,created_on,email,name,password,updated_on,username) values (1,now(),'admin@gmail.com','Administrator','admin',NULL,'admin');
insert  into users(user_id,created_on,email,name,password,updated_on,username) values (2,now(),'siva@gmail.com','Siva Prasad','siva',NULL,'siva');


CREATE TABLE roles (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  rolename varchar(255) NOT NULL,
  user_id int(11) NOT NULL,
  PRIMARY KEY (role_id),
  KEY FK67A8EBD712B8129 (user_id),
  CONSTRAINT FK67A8EBD712B8129 FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table roles */


insert  into roles(role_id,rolename,user_id) values (1,'ROLE_USER',1);
insert  into roles(role_id,rolename,user_id) values (2,'ROLE_ADMIN',1);
insert  into roles(role_id,rolename,user_id) values (3,'ROLE_USER',2);

/*Table structure for table categories */

CREATE TABLE categories (
  category_id int(11) NOT NULL AUTO_INCREMENT,
  category_name varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  display_order int(11) DEFAULT NULL,
  parent_category_id int(11) DEFAULT NULL,
  PRIMARY KEY (category_id),
  UNIQUE KEY category_name (category_name),
  KEY FK4D47461CFBE088B4 (parent_category_id),
  CONSTRAINT FK4D47461CFBE088B4 FOREIGN KEY (parent_category_id) REFERENCES categories (category_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table categories */

insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (1,'Java','Java Programming',1,NULL);
insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (2,'JavaSE','CoreJava Programming',1,1);
insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (3,'JavaEE','Java Enterprise Development',2,1);
insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (4,'Frameworks','Frameworks',2,NULL);
insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (5,'Databases','Databases',3,NULL);
insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (6,'SQL','Structured Query Language',1,5);
insert  into categories(category_id,category_name,description,display_order,parent_category_id) values (7,'NoSQL','NoSQL Databases',2,5);

/*Table structure for table forums */

CREATE TABLE forums (
  forum_id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  display_order int(11) DEFAULT NULL,
  forum_name varchar(255) NOT NULL,
  category_id int(11) NOT NULL,
  PRIMARY KEY (forum_id),
  UNIQUE KEY forum_name (forum_name),
  KEY FKB46017728992D0C9 (category_id),
  CONSTRAINT FKB46017728992D0C9 FOREIGN KEY (category_id) REFERENCES categories (category_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table forums */
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (1,'Core Java',1,'CoreJava',2);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (2,'Threads',2,'Threads',2);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (3,'Servlets and JSP',1,'ServletsJSP',3);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (4,'Enterprise Java Beans',2,'EJB',3);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (5,'Hibernate',2,'Hibernate',4);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (6,'Spring Framework',1,'Spring',4);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (7,'Oracle Database',1,'Oracle',6);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (8,'MySQL Database',2,'MySQL',6);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (9,'MongoDB NoSQL Database',1,'MongoDB',7);
insert  into forums(forum_id,description,display_order,forum_name,category_id) values (10,'Neo4J Graph Database',2,'Neo4J',7);

/*Table structure for table topics */

CREATE TABLE topics (
  topic_id int(11) NOT NULL AUTO_INCREMENT,
  created_on datetime DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  updated_on datetime DEFAULT NULL,
  created_by int(11) NOT NULL,
  forum_id int(11) NOT NULL,
  updated_by int(11) DEFAULT NULL,
  PRIMARY KEY (topic_id),
  KEY FKCC42D924CB943C28 (created_by),
  KEY FKCC42D92468542575 (updated_by),
  KEY FKCC42D924E00494AB (forum_id),
  CONSTRAINT FKCC42D924E00494AB FOREIGN KEY (forum_id) REFERENCES forums (forum_id),
  CONSTRAINT FKCC42D92468542575 FOREIGN KEY (updated_by) REFERENCES users (user_id),
  CONSTRAINT FKCC42D924CB943C28 FOREIGN KEY (created_by) REFERENCES users (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table topics */

insert  into topics(topic_id,created_on,title,updated_on,created_by,forum_id,updated_by) 
values (1,now(),'This is First Topic',now(),1,1,1);


/*Table structure for table posts */

CREATE TABLE posts (
  post_id int(11) NOT NULL AUTO_INCREMENT,
  created_on datetime DEFAULT NULL,
  message varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  updated_on datetime DEFAULT NULL,
  created_by int(11) NOT NULL,
  topic_id int(11) NOT NULL,
  updated_by int(11) DEFAULT NULL,
  PRIMARY KEY (post_id),
  KEY FK65E7BD3CB943C28 (created_by),
  KEY FK65E7BD38B02F1EB (topic_id),
  KEY FK65E7BD368542575 (updated_by),
  CONSTRAINT FK65E7BD368542575 FOREIGN KEY (updated_by) REFERENCES users (user_id),
  CONSTRAINT FK65E7BD38B02F1EB FOREIGN KEY (topic_id) REFERENCES topics (topic_id),
  CONSTRAINT FK65E7BD3CB943C28 FOREIGN KEY (created_by) REFERENCES users (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table posts */

insert  into posts(post_id,created_on,message,title,updated_on,created_by,topic_id,updated_by) 
values (1,now(),'First msg text in First Topic','First msg in First Topic',now(),1,1,1);



