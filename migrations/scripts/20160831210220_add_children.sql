-- // add children
-- Migration SQL that makes the change goes here.

insert into domain.child (id, name, birthday) values (nextval('domain.seq_child'), 'Ayrton Senna'           , '1960-03-21');
insert into domain.child (id, name, birthday) values (nextval('domain.seq_child'), 'Margaret Hilda Thatcher', '1925-10-13');
insert into domain.child (id, name, birthday) values (nextval('domain.seq_child'), 'Ayn Rand'               , '1905-02-02');

-- //@UNDO
-- SQL to undo the change goes here.


delete from domain.child;