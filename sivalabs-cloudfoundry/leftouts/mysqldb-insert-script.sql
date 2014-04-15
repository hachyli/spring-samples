
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id int(10) unsigned NOT NULL auto_increment,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  firstname varchar(45) NOT NULL,
  lastname varchar(45) default NULL,
  PRIMARY KEY  (user_id),
  UNIQUE KEY Index_2 (username)
);


INSERT INTO users (user_id,username,password,firstname,lastname) VALUES (1,'siva','siva','Siva Prasad Reddy','Katamreddy');
INSERT INTO users (user_id,username,password,firstname,lastname) VALUES (2,'admin','admin','Administrator','Mr');
INSERT INTO users (user_id,username,password,firstname,lastname) VALUES (3,'test','test','Guest','Mr');
