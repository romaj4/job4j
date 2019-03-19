--Написать запрос получение всех продуктов с типом "СЫР"

select * from product
where type_id in (select id from type where name = 'cheese');

--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

select * from product
where name like '%мороженное%';

--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

select * from product
where expired_date between current_date and (current_date + 31);

--Написать запрос, который выводит самый дорогой продукт.

select * from product
where price = (select max(price) from product);

--Написать запрос, который выводит количество всех продуктов определенного типа.

select t.name, count(*)
from product as pr
join type as t on pr.type_id = t.id
group by t.name;

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

select * from product
where type_id in (select id from type where name = 'cheese' or name = 'milk');

--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  

select t.name, count(*) as c1
from product as pr
join type as t on pr.type_id = t.id
group by t.name
having count(*) < 10;

--Вывести все продукты и их тип.

select pr.*, t.name as product_type
from product as pr
join type as t on pr.type_id = t.id;