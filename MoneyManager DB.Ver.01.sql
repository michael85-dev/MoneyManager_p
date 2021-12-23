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
    c_pName varchar(100),
    constraint unique(c_id),
    constraint primary key(c_number)
);
select * from client_table;

drop table account_table;
create table account_table(
	a_number bigint auto_increment,
    c_number bigint,
    a_bank varchar(50) NOT NULL,
    a_info varchar(100),
    a_memo varchar(1000),
    a_pName varchar(50),
    a_tAsset bigint default 0,
    a_pAsset bigint default 0,
    a_mAsset bigint default 0,
    constraint primary key(a_number),
    constraint unique(a_bank),
    constraint foreign key(c_number) references client_table(c_number)
);
select * from account_table;

drop table card_table;
create table card_table (
	d_number bigint auto_increment,
    c_number bigint,
    d_cCompany varchar(50) NOT NULL,
    d_info varchar(100),
    d_memo varchar(1000),
    d_pName varchar(50),
    d_tAsset bigint default 0,
    d_pAsset bigint default 0,
    d_mAsset bigint default 0,
    constraint primary key(d_number),
    constraint unique(d_cCompany),
    constraint foreign key(c_number) references client_table(c_number)
);
select * from card_table;

drop table cash_table;
create table cash_table(
	s_number bigint auto_increment,
    c_number bigint,
    s_cash varchar(50) NOT NULL,
    s_info varchar(100),
    s_memo varchar(1000),
    s_pName varchar(50),
    s_tAsset bigint default 0,
    s_pAsset bigint default 0,
    s_mAsset bigint default 0,
    constraint primary key(s_number),
    constraint unique(s_cash),
    constraint foreign key(c_number) references client_table(c_number)
);
select * from cash_table;

drop table accountInfo_table;
create table accountInfo_table (
	ai_number bigint auto_increment,
    a_number bigint,
    a_bank varchar(50),
    ai_name varchar(50) NOT NULL,
    ai_nName varchar(50),
    ai_info varchar(100),
    ai_memo varchar(1000),
    ai_iRate double,
    ai_pName varchar(50),
    ai_tAsset bigint default 0,
    ai_pAsset bigint default 0,
    ai_mAsset bigint default 0,
    constraint primary key(ai_number),
    constraint foreign key(a_bank) references account_table(a_bank)
);

select * from accountInfo_table;

drop table cardInfo_table;
create table cardInfo_table (
	di_number bigint auto_increment,
    d_cCompany varchar(50),
    d_number bigint,
    a_bank varchar(50),
    di_name varchar(50) NOT NULL,
    di_nName varchar(50),
    di_info varchar(100),
    di_memo varchar(1000),
    di_pName varchar(50),
    di_tAsset bigint default 0,
    di_pAsset bigint default 0,
    di_mAsset bigint default 0,
    constraint primary key(di_number),
    constraint foreign key(d_cCompany) references card_table(d_cCompany),
    constraint foreign key(a_bank) references account_table(a_bank),
    constraint foreign key(d_number) references card_table(d_number)
);

select * from cardInfo_table;

drop table cashInfo_table;
create table cashInfo_table (
	si_number bigint auto_increment,
    s_cash varchar(50),
    s_number bigint,
    si_name varchar(50),
    si_nName varchar(50),
    si_info varchar(100),
    si_memo varchar(1000),
    si_pName varchar(50),
    si_tAsset bigint default 0,
    si_pAsset bigint default 0,
    si_mAsset bigint default 0,
    constraint primary key(si_number),
    constraint foreign key(s_cash) references cash_table(s_cash),
    constraint foreign key(s_number) references cash_table(s_number)
);

select * from cardInfo_table;

drop table accountContents_table;
create table accountContents_table (
	ai_number bigint,
    ac_number bigint auto_increment,
    a_bank varchar(30),
    ac_info varchar(200),
    ac_useCon varchar(100),
    ac_useAcc varchar(100),
    ac_name varchar(50),
    ac_nName varchar(50),
    ac_iRate double default 0,
    ac_pName varchar(100),
    ac_tAsset bigint default 0,
    ac_mAsset bigint default 0,
    ac_pAsset bigint default 0,
    constraint primary key(ac_number),
    constraint foreign key(ai_number) references accountInfo_table(ai_number)
);