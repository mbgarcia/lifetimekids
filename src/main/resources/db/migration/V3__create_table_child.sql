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

ALTER TABLE                     domain.child OWNER TO admin_life;
GRANT ALL ON TABLE              domain.child TO admin_life;
GRANT SELECT, UPDATE ON TABLE   domain.child TO role_life_aplic;
GRANT SELECT ON TABLE           domain.child TO role_life_users;

CREATE SEQUENCE domain.seq_child
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;
ALTER TABLE                     domain.seq_child OWNER TO admin_life;
GRANT ALL ON TABLE              domain.seq_child TO admin_life;
GRANT SELECT, UPDATE ON TABLE   domain.seq_child TO role_life_aplic;
GRANT SELECT ON TABLE           domain.seq_child TO role_life_users;
