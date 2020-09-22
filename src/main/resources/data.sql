INSERT INTO users
VALUES (1,'roy','adams','radams1v@xinhuanet.com','2872 Marquette Street','United States','1-(235)314-9823','roy','password','ROLE_USER',true);

INSERT INTO users
VALUES (2,'betty','anderson','banderson14@digg.com','3538 Scofield Drive','United States','1-(291)830-0405','betty','password','ROLE_USER',true);

INSERT INTO users
VALUES (3,'roger','alvarez','ralvarezk@blogs.com','3 Green Plaza','Spain','6-(980)036-6105','roger','password','ROLE_ADMIN',true);

--INSERT INTO users(id,username,password,enabled,accountnonexpired,credentialsnonexpired,accountnonlocked)
--VALUES ('1','roy','password',true,true,true,true) ;
--
--INSERT INTO users(id,username,password,enabled,accountnonexpired,credentialsnonexpired,accountnonlocked)
--VALUES ('2','betty','password',true,true,true,true) ;
--
--INSERT INTO users(id,username,password,enabled,accountnonexpired,credentialsnonexpired,accountnonlocked)
--VALUES ('3','roger','password',true,true,true,true) ;
--
--INSERT INTO authorities(username,authority)
--VALUES ('roy','ROLE_USER');
--
--INSERT INTO authorities(username,authority)
--VALUES ('betty','ROLE_USER');
--
--INSERT INTO authorities(username,authority)
--VALUES ('roger','ROLE_ADMIN');

--create table users(
--    id int not null,
--    firstname varchar_ignorecase(50) not null,
--    lastname varchar_ignorecase(50) not null,
--    email varchar_ignorecase(50) not null,
--    address varchar_ignorecase(50) not null,
--    country varchar_ignorecase(50) not null,
--    phone varchar_ignorecase(50) not null,
--    username varchar_ignorecase(50) not null primary key,
--    password varchar_ignorecase(500) not null,
--    enabled boolean not null
--    authorities varchar_ignorecase(500) not null,
--);

--create table users(
--    id varchar_ignorecase(3) not null,
--    username varchar_ignorecase(50) not null primary key,
--    password varchar_ignorecase(500) not null,
--    enabled boolean not null,
--    accountnonexpired boolean not null,
--    credentialsnonexpired boolean not null,
--    accountnonlocked boolean not null
--);

--create table authorities (
--    username varchar_ignorecase(50) not null,
--    authority varchar_ignorecase(50) not null,
--    constraint fk_authorities_users foreign key(username) references users(username)
--);
--create unique index ix_auth_username on authorities (username,authority);

