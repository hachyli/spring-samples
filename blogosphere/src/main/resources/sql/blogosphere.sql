
--CREATE DATABASE IF NOT EXISTS blogosphere;

--USE blogosphere;

DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS post_tags;
DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS blogs;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email_id varchar(50) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  disabled char(1) DEFAULT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY username_unique (username),
  UNIQUE KEY email_id_unique (email_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Data for the table user */

insert  into users(user_id,email_id,username,password,first_name,last_name,disabled) values (1,'admin@gmail.com','admin','admin','Administrator',NULL,'0');
insert  into users(user_id,email_id,username,password,first_name,last_name,disabled) values (2,'sivaprasadreddy.k@gmail.com','siva','siva','Siva','K','0');

CREATE TABLE blogs 
(
  blog_id int(11) NOT NULL AUTO_INCREMENT,
  blog_name varchar(50) NOT NULL,
  owner_id int(11) NOT NULL,
  created_on datetime DEFAULT NULL,
  PRIMARY KEY (blog_id),
  UNIQUE KEY blog_name_unique (blog_name),
  KEY FK_blog_owner (owner_id),
  CONSTRAINT FK_blog_owner FOREIGN KEY (owner_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into blogs(blog_id,blog_name,owner_id,created_on) values(1,'sivalabs',1,now());

CREATE TABLE tags (
  tag_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tag_name VARCHAR(50) NOT NULL,
  description VARCHAR(512),
  PRIMARY KEY (tag_id),
  UNIQUE INDEX tag_name_unique(tag_name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO tags (tag_id,tag_name,description)	VALUES (1,'java','Java');
INSERT INTO tags (tag_id,tag_name,description)	VALUES (2,'java-ee','JavaEE');
INSERT INTO tags (tag_id,tag_name,description)	VALUES (3,'spring','Spring');
INSERT INTO tags (tag_id,tag_name,description)	VALUES (4,'hibernate','Hibernate');
INSERT INTO tags (tag_id,tag_name,description)	VALUES (5,'ajax','Ajax');
INSERT INTO tags (tag_id,tag_name,description)	VALUES (6,'tomcat','Tomcat');


CREATE TABLE posts (
  post_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(256) NOT NULL,
  content longtext NOT NULL,
  created_on datetime NOT NULL,
  blog_id int(11) NOT NULL,
  PRIMARY KEY (post_id),
  KEY FK_post_blog_id (blog_id),
  CONSTRAINT FK_post_blog_id FOREIGN KEY (blog_id) REFERENCES blogs (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


insert  into posts(post_id,title,content,created_on,blog_id) values (1,'My First Post','This my First post',now(),1);

CREATE TABLE post_tags 
(
  post_id int(11) NOT NULL default '0',
  tag_id int(11) NOT NULL default '0',
  PRIMARY KEY  (post_id,tag_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into post_tags(post_id,tag_id) values(1,1);
insert into post_tags(post_id,tag_id) values(1,3);

CREATE TABLE comments (
  comment_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(256) DEFAULT NULL,
  content longtext NOT NULL,
  created_on datetime NOT NULL,
  created_by int(11) NOT NULL,
  post_id int(11) NOT NULL,
  PRIMARY KEY (comment_id),
  KEY FK_comment_post_id (post_id),
  KEY FK_comment_created_by (created_by),
  CONSTRAINT FK_comment_created_by FOREIGN KEY (created_by) REFERENCES users (user_id),
  CONSTRAINT FK_comment_post_id FOREIGN KEY (post_id) REFERENCES posts (post_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert  into comments(comment_id,title,content,created_on,created_by,post_id) values (1,'RE: My First Post','Keep going',now(),1,1);
