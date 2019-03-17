--создание базы данных
CREATE DATABASE tracker;

--создание таблицы ролей
create table role(
id serial primary key,
name varchar(100)
);

--создание таблицы права
create table rules(
	id serial primary key,
	name varchar(100)
);

--создание таблицы пользователей
create table users(
	id serial primary key,
	name varchar(100),
	role_id int references role(id)
);

--создание таблицы отношений роль-права
create table role_rules(
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

--создание таблицы категорий
create table category(
	id serial primary key,
	name varchar(100)
);

--создание таблицы состояния
create table state(
	id serial primary key,
	name varchar(100)
);

--создание таблицы заявки
create table item(
	id serial primary key,
	name varchar(100),
	owner int references users(id),
	category_id int references category(id),
	state_id int references state(id)	
);

--создание таблицы комментариев
create table comments(
	id serial primary key,
	description text,
	item_id int references item(id)	
);

--создание таблицы прикрепленных файлов
create table atachs(
	id serial primary key,
	path text,
	item_id int references item(id)	
);

--заполняем начальные данные для системы заявок.
insert into role(name) values('role_1');
insert into role(name) values('role_2');
insert into role(name) values('role_3');

insert into rules(name) values('rule_1');
insert into rules(name) values('rule_2');
insert into rules(name) values('rule_3');

insert into users(name, role_id) values('name_1', 11);
insert into users(name, role_id) values('name_2', 12);
insert into users(name, role_id) values('name_3', 10);

insert into role_rules(role_id, rules_id) values(10, 11);
insert into role_rules(role_id, rules_id) values(12, 12);
insert into role_rules(role_id, rules_id) values(12, 10);

insert into category(name) values('category_1');
insert into category(name) values('category_2');
insert into category(name) values('category_3');

insert into state(name) values('state_1');
insert into state(name) values('state_1');
insert into state(name) values('state_1');

insert into item(name, owner, category_id, state_id) values('item_1', 9 , 5, 6);
insert into item(name, owner, category_id, state_id) values('item_2', 11 , 4, 6);
insert into item(name, owner, category_id, state_id) values('item_3', 10 , 6, 5);

insert into comments(description, item_id) values('coment_1', 9);
insert into comments(description, item_id) values('coment_1', 11);
insert into comments(description, item_id) values('coment_1', 10);

insert into atachs(path, item_id) values('c:project/path_1', 9);
insert into atachs(path, item_id) values('c:project/path_2', 11);
insert into atachs(path, item_id) values('c:project/path_3', 10);