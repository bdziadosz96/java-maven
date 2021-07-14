drop table if exists cars;
create table cars(
    id long primary key auto_increment,
    model varchar(100) not null,
    name varchar(100) not null
)