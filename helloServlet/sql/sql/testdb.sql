drop database if exists indexdb;
create database indexdb;
use indexdb;
create table index_table(
user_id int,
user_name varchar(255),
password varchar(255)
);

insert into index_table values(1, "kentaro", "123");
insert into index_table values(2, "jiro", "456");
insert into index_table values(3, "taro", "789");