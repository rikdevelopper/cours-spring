create table if not exists maison (
    id serial primary key,
    nom varchar(255) unique not null,
    prix decimal not null,
    adresse varchar(255) not null,
    caution decimal
);

create table if not exists client (
    id serial primary key,
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    address varchar(255) not null
);

create table if not exists reservation(
    id serial primary key,
    start_date date not null ,
    end_date date not null ,
    monthly_cost decimal not null ,
    deposit decimal not null,
    client_id int not null,
    maison_id int not null,
    foreign key (client_id) references client(id),
    foreign key (maison_id) references maison(id)
);