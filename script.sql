create table users(id integer primary key, name varchar(255));
create table info(id integer primary key, numb_of_visitors integer, info varchar(200));

insert into users values(1,'first');
insert into users values(2,'second');

insert into info values(1, 1, 'first info');
insert into info values(2, 1, 'second info');
