CREATE TABLE car
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(250) NOT NULL,
    model VARCHAR(250) NOT NULL
);

insert into car(id,name,model) values (1, 'Audi', 'A8');