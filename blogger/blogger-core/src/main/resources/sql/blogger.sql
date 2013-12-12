

DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS blogs;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  firstname varchar(50) NOT NULL,
  lastname varchar(50) DEFAULT NULL,
  email varchar(50) NOT NULL,
  phone varchar(20) DEFAULT NULL,
  dob date DEFAULT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY UK_USER_EMAIL (email),
  UNIQUE KEY UK_USERNAME (username)
);


CREATE TABLE blogs (
  blog_id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  description varchar(150) DEFAULT NULL,
  user_id int(10) NOT NULL,
  created_on datetime DEFAULT NULL,
  updated_on datetime DEFAULT NULL,
  PRIMARY KEY (blog_id),
  CONSTRAINT FK_BLOG_USER FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID)
);


CREATE TABLE posts (
  post_id int(10) NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  message varchar(45) NOT NULL,
  blog_id int(10) NOT NULL,
  posted_by int(10) DEFAULT NULL,
  created_on datetime DEFAULT NULL,
  updated_on varchar(45) DEFAULT NULL,
  PRIMARY KEY (post_id),
  CONSTRAINT FK_POST_BLOG FOREIGN KEY (BLOG_ID) REFERENCES BLOGS (BLOG_ID),
  CONSTRAINT FK_POST_POSTEDBY FOREIGN KEY (POSTED_BY) REFERENCES USERS (USER_ID)
);


CREATE TABLE comments (
  comment_id int(10) NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  message varchar(45) NOT NULL,
  post_id int(10) NOT NULL,
  posted_by int(10) DEFAULT NULL,
  created_on datetime DEFAULT NULL,
  updated_on datetime DEFAULT NULL,
  PRIMARY KEY (comment_id),
  CONSTRAINT FK_COMMENT_POST FOREIGN KEY (POST_ID) REFERENCES POSTS (POST_ID)
);


 INSERT INTO users (user_id,username,password,firstname,lastname,email,phone,dob) VALUES 
 (1,'admin','admin','Administrator',NULL,'admin@gmail.com',NULL,NULL),
 (2,'siva','siva','Siva','Prasad','sivaprasadreddy.k@gmail.com','90000000','1983-06-25');


INSERT INTO blogs (blog_id,name,description,user_id,created_on,updated_on) VALUES 
 (1,'SivaLabs','My Experiments on Technology',2,'2012-12-12 00:00:00',NULL);
 
 INSERT INTO posts (post_id,title,message,blog_id,posted_by,created_on,updated_on) VALUES 
 (1,'Test Post1','Hello, This is Test Post1',1,2,'2012-12-12 00:00:00',NULL),
 (2,'Test Post2','Hello, This is Test Post2',1,1,'2012-12-12 00:00:00',NULL);
 
INSERT INTO comments (comment_id,title,message,post_id,posted_by,created_on,updated_on) VALUES 
 (1,'Test Comment1','This is Test Comment1',1,1,'2013-12-12 00:00:00',NULL);
 