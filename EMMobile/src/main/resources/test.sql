/*==============================================================*/
/* Database name:  usd                                          */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/11/22 14:09:54                          */
/*==============================================================*/
drop database if exists zhoujia;

/*==============================================================*/
/* Database: usd                                                */
/*==============================================================*/
create database zhoujia;

use zhoujia;

/*==============================================================*/
/* Table: blog                                                  */
/*==============================================================*/
create table blog
(
   id                   bigint not null auto_increment,
   customer_id          bigint not null,
   title                varchar(32),
   content              varchar(256) comment '��������',
   emotion              int(1),
   create_time          datetime not null,
   update_time          datetime,
   blog_media_id        bigint,
   media_type           tinyint,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: blog_comment                                          */
/*==============================================================*/
create table blog_comment
(
   id                   bigint not null auto_increment,
   blog_id              bigint not null,
   content              varchar(256),
   create_time          datetime,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: blog_media                                            */
/*==============================================================*/
create table blog_media
(
   id                   bigint not null auto_increment,
   blog_id              bigint not null,
   media_id             bigint not null,
   seq                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   password             varchar(128) not null,
   mail                 varchar(64),
   gender               tinyint comment '1- male
            2- female',
   phone                varchar(32) not null,
   profile_img          varchar(128),
   birth_start          date,
   birth_end            date,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: customer_relation                                     */
/*==============================================================*/
create table customer_relation
(
   id                   bigint not null auto_increment,
   hospital_code        varchar(128) not null comment '对应E-app的 hospital',
   customer_id          bigint,
   patient_code         varchar(128) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: gallery                                               */
/*==============================================================*/
create table gallery
(
   id                   bigint not null auto_increment,
   title                varchar(64),
   customer_id          bigint not null,
   gallery_type         tinyint not null, 
   create_time          datetime not null,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: gallery_media                                         */
/*==============================================================*/
create table gallery_media
(
   id                   bigint not null auto_increment,
   gallery_id           bigint not null,
   media_id             bigint not null,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: media                                                 */
/*==============================================================*/
create table media
(
   id                   bigint not null auto_increment,
   blog_id              bigint,
   customer_id          bigint not null,
   media_url            varchar(128) not null,
   media_type           tinyint not null comment '1 - 照片
            2 - 扫描
            3 - 视频
            4 - 音频',
   primary key (id)
);

/*==============================================================*/
/* Table: notice                                                */
/*==============================================================*/
create table notice
(
   id                   bigint not null auto_increment,
   hospital_code        varchar(256),
   content              varchar(256),
   create_user_id       bigint not null,
   create_time          datetime not null,
   send_user_id         bigint,
   send_time            datetime,
   status               tinyint not null comment '1 - δ����
            2 - �ѷ���',
   comments             varchar(256),
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: remind                                                */
/*==============================================================*/
create table remind
(
   id                   bigint not null auto_increment,
   customer_id          bigint not null,
   remind_type          tinyint not null,
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
   id                   bigint not null auto_increment,
   start_time           datetime not null,
   phone                varchar(11) not null,
   code                 int(4) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: resource                                              */
/*==============================================================*/
create table pub_resource
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   url                  varchar(128),
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table pub_role
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: role_res                                              */
/*==============================================================*/
create table pub_role_res
(
   id                   bigint not null auto_increment,
   role_id              bigint,
   res_id               bigint,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table pub_user
(
   id                   bigint not null auto_increment,
   username             varchar(128) not null,
   password             varchar(128) not null,
   phone                varchar(11),
   email                varchar(128),
   isenable             tinyint not null default 1,
   primary key (id)
)
auto_increment=10000;

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table pub_user_role
(
   id                   bigint not null auto_increment,
   user_id              bigint,
   role_id              bigint,
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