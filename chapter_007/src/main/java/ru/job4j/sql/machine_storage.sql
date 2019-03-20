--Создать таблицы: Кузов. Двигатель, Коробка передач.
--Создать структуру Машина. Машина не может существовать без данных из п.1.

create table body_car(
	id serial primary key,
	name varchar(100)
);

create table engine(
	id serial primary key,
	name varchar(100)
);

create table transmission(
	id serial primary key,
	name varchar(100)
);

create table car(
	id serial primary key,
	model varchar(100),
	body_id int references body_car(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

--Заполнить таблицы через insert. 

insert into body_car(name)
values
('седан'),
('универсал'),
('хэтчбек');

insert into engine(name)
values
('бензиновый'),
('дизельный'),
('электро');

insert into transmission(name)
values
('механика'),
('автомат'),
('робот');

insert into car(model, body_id, engine_id, transmission_id)
values
('Ford Focus', 2, 1, 3),
('Tesla S', 1, 3, 3),
('Kia Rio', 3, 1, 2),
('Lada Granta', 1, 1, 1);

--1. Вывести список всех машин и все привязанные к ним детали.

select car.model, engine.name as name_engine, body_car.name as car_body, transmission.name as transmssion_name
from car
left join engine on car.engine_id = engine.id
left join body_car on car.body_id = body_car.id
left join transmission on car.transmission_id = transmission.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки
select engine.name from car
right join engine on car.engine_id = engine.id where car.model is null;

select body_car.name from car
right join body_car on car.body_id= body_car.id where car.model is null;

select transmission.name from car
right join transmission on car.body_id= transmission.id where car.model is null;