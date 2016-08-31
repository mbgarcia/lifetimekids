-- // add users
-- Migration SQL that makes the change goes here.

insert into security.user (username, fullname, password) values ('admin@mail.com', 'Administrator', 'admin');
insert into security.user (username, fullname, password) values ('guest@mail.com', 'Guest User'   , 'guest');

-- //@UNDO
-- SQL to undo the change goes here.


delete from security.user;