create database servletdb;
use servletdb;

create table employee(name varchar(15) not null,
email varchar(40) not null,
password varchar(10) not null,
country varchar(10) not null);

select * from employee;

show databases;
