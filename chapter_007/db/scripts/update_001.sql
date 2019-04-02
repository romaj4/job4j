create table if not exists items(
    id serial primary key,
    name varchar(100),
    description varchar(500),
    created bigint
  );