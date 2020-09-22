create table users(
    id int not null,
    firstname varchar_ignorecase(50) not null,
    lastname varchar_ignorecase(50) not null,
    email varchar_ignorecase(50) not null,
    address varchar_ignorecase(50) not null,
    country varchar_ignorecase(50) not null,
    phone varchar_ignorecase(50) not null,
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(500) not null,
    authorities varchar_ignorecase(500) not null,
    enabled boolean not null
);
