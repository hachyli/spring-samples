
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id int(10) unsigned NOT NULL auto_increment,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  firstname varchar(45) NOT NULL,
  lastname varchar(45) default NULL,
  email_id varchar(45) default NULL,
  disabled tinyint(1) default NULL,
  PRIMARY KEY  (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO users (user_id,username,password,firstname,lastname,email_id,disabled) VALUES 
 (1,'admin','admin','Administrator',NULL,'admin@gmail.com',0),
 (2,'siva','siva','Siva','Katamreddy','siva@gmail.com',0),
 (3,'guest','guest','Guest',NULL,'guest@gmail.com',1);
