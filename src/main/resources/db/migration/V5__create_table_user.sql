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

ALTER TABLE                     security.user OWNER TO admin_life;
GRANT ALL ON TABLE              security.user TO admin_life;
GRANT SELECT, UPDATE ON TABLE   security.user TO role_life_aplic;
GRANT SELECT ON TABLE           security.user TO role_life_users;