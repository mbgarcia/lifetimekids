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

ALTER TABLE                     domain.event OWNER TO admin_life;
GRANT ALL ON TABLE              domain.event TO admin_life;
GRANT SELECT, UPDATE ON TABLE   domain.event TO role_life_aplic;
GRANT SELECT ON TABLE           domain.event TO role_life_users;

CREATE SEQUENCE domain.seq_event
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;
ALTER TABLE                     domain.seq_event OWNER TO admin_life;
GRANT ALL ON TABLE              domain.seq_event TO admin_life;
GRANT SELECT, UPDATE ON TABLE   domain.seq_event TO role_life_aplic;
GRANT SELECT ON TABLE           domain.seq_event TO role_life_users;
