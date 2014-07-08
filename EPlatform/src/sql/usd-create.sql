
drop database if exists erpapp;

/*==============================================================*/
/* Database: erpapp                                             */
/*==============================================================*/
create database erpapp;

use erpapp;

/*==============================================================*/
/* Table: pub_resource                                          */
/*==============================================================*/
create table pub_resource
(
   id                   int unsigned not null auto_increment,
   name                 varchar(64),
   url                  varchar(128),
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: pub_role                                              */
/*==============================================================*/
create table pub_role
(
   id                   int unsigned not null auto_increment,
   name                 varchar(64),
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: pub_role_res                                          */
/*==============================================================*/
create table pub_role_res
(
   id                   int unsigned not null auto_increment,
   role_id              int unsigned,
   res_id               int unsigned,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: pub_user                                              */
/*==============================================================*/
create table pub_user
(
   id                   int unsigned not null auto_increment,
   username             varchar(128) not null,
   password             varchar(128) not null,
   phone                varchar(11),
   email                varchar(128),
   enabled              tinyint not null default 1,
   accountNonExpired    tinyint,
   accountNonLocked     tinyint,
   credentialsNonExpired tinyint,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: pub_user_role                                         */
/*==============================================================*/
create table pub_user_role
(
   id                   int unsigned not null auto_increment,
   user_id              int unsigned not null,
   role_id              int unsigned not null,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
drop table if exists sys_log;
create table sys_log
(
   id                   bigint not null auto_increment,
   user_id              bigint,
   record_time          datetime,
   log_type             tinyint not null,
   content              varchar(255),
   primary key (id)
)
auto_increment=10000;

