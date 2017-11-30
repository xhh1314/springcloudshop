create database userservice default character set utf8;

create table users (
uuid varchar(255) not null ,
email varchar(255) not null,
name varchar(255) not null,
password varchar(255) default null,
primary key(uuid)
);
create unique index  uk_email on users (email(20));