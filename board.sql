create database board;

create table member (
  id varchar(20) not null primary key,
  pw varchar(20) not null,
  name varchar(40) not null,
  email varchar(40) not null
);

create table bbs (
  bbsid int auto_increment primary key,
  bbstitle varchar(80) not null,
  bbscontent varchar(1000),
  bbsdate datetime default CURRENT_TIMESTAMP,
  bbshit int default 0,
  bbscategoty varchar(40),
  id varchar(20)
);
