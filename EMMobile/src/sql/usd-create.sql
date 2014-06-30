/*==============================================================*/
/* Database name:  usd                                          */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/12/23 16:25:45                          */
/*==============================================================*/


drop database if exists usd;

/*==============================================================*/
/* Database: usd                                                */
/*==============================================================*/
create database usd;

use usd;

/*==============================================================*/
/* Table: blog                                                  */
/*==============================================================*/
create table blog
(
   id                   int unsigned not null auto_increment,
   customer_id          int unsigned not null,
   title                varchar(32),
   content              varchar(256) comment '��������',
   emotion              int(1),
   create_time          datetime not null,
   update_time          datetime,
   blog_media_id        int unsigned default 0,
   media_type           tinyint,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: blog_comment                                          */
/*==============================================================*/
create table blog_comment
(
   id                   int unsigned not null auto_increment,
   blog_id              int unsigned not null,
   content              varchar(256),
   create_time          datetime,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   int unsigned not null auto_increment,
   name                 varchar(64),
   password             varchar(128),
   mail                 varchar(64),
   gender               tinyint comment '1- male
                        2- female',
   phone                varchar(32) not null,
   profile_img          varchar(128),
   birth_start          date,
   birth_end            date,
   sys_user_id          int unsigned,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: customer_relation                                     */
/*==============================================================*/
create table customer_relation
(
   id                   int unsigned not null auto_increment,
   hospital_code        varchar(128) not null comment '��ӦE-app�� hospital',
   customer_id          int unsigned,
   patient_code         varchar(128) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: gallery                                               */
/*==============================================================*/
create table gallery
(
   id                   int unsigned not null auto_increment,
   title                varchar(64) not null,
   customer_id          int unsigned,
   create_time          datetime not null,
   gallery_type         tinyint not null,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: gallery_media                                         */
/*==============================================================*/
create table gallery_media
(
   id                   int unsigned not null auto_increment,
   gallery_id           int unsigned not null,
   media_id             int unsigned not null,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: media                                                 */
/*==============================================================*/
create table media
(
   id                   int unsigned not null auto_increment,
   blog_id              int unsigned,
   customer_id          int unsigned not null,
   media_url            varchar(128) not null,
   media_type           tinyint not null comment '1 - ��Ƭ
                        2 - ɨ��
                        3 - ��Ƶ
                        4 - ��Ƶ',
   primary key (id)
);

/*==============================================================*/
/* Table: notice                                                */
/*==============================================================*/
create table notice
(
   id                   int unsigned not null auto_increment,
   hospital_code        varchar(256),
   content              varchar(256),
   create_user_id       int unsigned not null,
   create_time          datetime not null,
   send_user_id         int unsigned default NULL,
   send_time            datetime,
   status               tinyint not null comment '1 - δ����
                        2 - �ѷ���',
   comments             varchar(256),
   primary key (id)
)
auto_increment=10000;

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
/* Table: remind                                                */
/*==============================================================*/
create table remind
(
   id                   int unsigned not null auto_increment,
   customer_id          int unsigned not null,
   remind_type          tinyint not null comment '1 - ���',
   title                varchar(32),
   content              varchar(256) not null,
   create_time          datetime not null,
   remind_time          datetime not null,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: sms_verify                                            */
/*==============================================================*/
create table sms_verify
(
   id                   int unsigned not null auto_increment,
   start_time           datetime not null,
   phone                varchar(11) not null,
   code                 int(4) not null,
   primary key (id)
);

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

