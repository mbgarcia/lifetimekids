-- // create table event
-- Migration SQL that makes the change goes here.

CREATE TABLE domain.event
(
  id            integer      NOT NULL,
  message       varchar(144) NOT NULL,
  "date"        date         NOT NULL,
  child_id      integer      NOT NULL,
  
  CONSTRAINT event_pkey PRIMARY KEY (id),
  CONSTRAINT fk1_event FOREIGN KEY (child_id)
      REFERENCES domain.child (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT  
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE domain.seq_event
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE    domain.event;
DROP SEQUENCE domain.seq_event;
