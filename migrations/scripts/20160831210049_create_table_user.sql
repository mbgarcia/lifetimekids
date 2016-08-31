-- // create table user
-- Migration SQL that makes the change goes here.

CREATE TABLE security.user
(
  username      varchar(20) NOT NULL,
  fullname      varchar(40) NOT NULL,
  password      varchar(40) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (username)
)
WITH (
  OIDS=FALSE
);


-- //@UNDO
-- SQL to undo the change goes here.


DROP TABLE security.user;