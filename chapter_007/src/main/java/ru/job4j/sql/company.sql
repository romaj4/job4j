CREATE TABLE company
(
id integer NOT NULL,
name character varying(100),
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

-- names of all persons that are NOT in the company with id = 5
-- company name for each person
select person.name as person_name, company.name as company_name
from person left join company
on person.company_id=company.id
where person.company_id!=5;

-- Select the name of the company with the maximum number of persons + number of persons in this company
select company.name as company_name, count(*)
from person left join company
on person.company_id=company.id
group by company.id
order by count(*) desc
limit 1;