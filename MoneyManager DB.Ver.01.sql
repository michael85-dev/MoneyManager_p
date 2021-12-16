use money_manager;

select user();
select database();

drop table client_table;
create table client_table (
	c_number bigint auto_increment,
    c_id varchar(30) NOT NULL,
    c_password varchar(30) NOT NULL,
    c_name varchar(20) NOT NULL, 
    c_nickname varchar(30) NOT NULL,
    c_email varchar(30),
    c_photoname varchar(100),
    constraint unique(c_id),
    constraint primary key(c_number)
);
select * from client_table;