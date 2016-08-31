-- // create table child
-- Migration SQL that makes the change goes here.

CREATE TABLE domain.child
(
  id            integer     NOT NULL,
  name          varchar(40) NOT NULL,
  birthday      date        NOT NULL,

  CONSTRAINT child_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE SEQUENCE domain.seq_child
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;


-- //@UNDO
-- SQL to undo the change goes here.


DROP TABLE domain.child;
DROP SEQUENCE domain.seq_child;