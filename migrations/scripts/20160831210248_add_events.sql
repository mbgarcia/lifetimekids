-- // add events
-- Migration SQL that makes the change goes here.

insert into domain.event(id, message, "date", child_id) values (nextval('domain.seq_event'), 'Ayrton drives his first car', '1963-05-05', (select c.id from domain.child c where c.name='Ayrton Senna'));
insert into domain.event(id, message, "date", child_id) values (nextval('domain.seq_event'), 'Ayn emigrated to USA',        '1926-02-10', (select c.id from domain.child c where c.name='Ayn Rand'));

-- //@UNDO
-- SQL to undo the change goes here.


delete from domain.event;