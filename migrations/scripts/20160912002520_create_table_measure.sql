-- // create table measure
-- Migration SQL that makes the change goes here.

CREATE TABLE domain.measure
(
  id            bigint       NOT NULL,
  height        decimal(5,2)         ,
  weight        decimal(5,2)         ,
  "date"        date         NOT NULL,
  child_id      bigint       NOT NULL,
  
  CONSTRAINT measure_pkey PRIMARY KEY (id),
  CONSTRAINT fk1_measure FOREIGN KEY (child_id)
      REFERENCES domain.child (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT  
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE domain.seq_measure
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE    domain.measure;
DROP SEQUENCE domain.seq_measure;