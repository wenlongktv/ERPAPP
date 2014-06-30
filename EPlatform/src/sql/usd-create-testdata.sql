truncate table pub_user; 
INSERT INTO pub_user (id, username, password, phone, email, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) values
(1, 'test', 'e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91', '12345', '123@ge.com', 1, 1, 1, 1),
(2, '13300000000', 'e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91', '12345', '123@ge.com', 1, 1, 1, 1),
(3, '13400000000', 'e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91', '12345', '123@ge.com', 1, 1, 1, 1),
(4, '13500000000', 'e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91', '12345', '123@ge.com', 1, 1, 1, 1);

truncate table pub_role;
INSERT INTO pub_role (id, name) VALUES 
(1,'ROLE_ADMIN'),
(2,'ROLE_CUSTOMER'),
(3,'ROLE_TEST');

truncate table pub_role_res;
INSERT INTO pub_role_res (id, role_id, res_id) VALUES 
(1, 1, 20),
(3, 2, 80),
(4, 2, 90),
(5, 2, 100),
(6, 2, 110),
(7, 2, 120),
(8, 2, 130),
(9, 2, 140),
(10, 2, 150),
(11, 2, 160),
(12, 2, 170),
(13, 2, 180),
(14, 2, 190),
(15, 2, 200),
(16, 2, 210),
(17, 2, 220),
(18, 2, 230),
(19, 2, 240);

truncate table pub_user_role;
INSERT INTO `pub_user_role` VALUES 
(1,1,1),
(2,2,1),
(3,3,1);



truncate table pub_resource;
INSERT INTO `pub_resource` VALUES 
(1,'login','login.jsp'),
(2,'/','index.jsp'),
(20,'admin','/**'),
(30, 'user', '/user/**'),
(40, 'role', '/role/**'),
(50, 'resource', '/resource/**'),
(60, 'notification management', '/notificationMgt/**'),
(70, 'customer management', '/cusMgt**'),
(80, 'customer', '/customer/**'),
(90, 'gallery', '/gallery/**'),
(110, 'usd', '/usd/**'),
(120, 'blog', '/blog/**'),
(130, 'blogComment', '/blogComment/**'),
(140, 'editBlog', '/editBlog/**'),
(160, 'profile', '/profile/**'),
(170, 'password', '/password/**'),
(180, 'report', '/report/**'),
(190, 'reminder', '/reminder/**'),
(200, 'calendar', '/calendar/**'),
(210, 'login', '/login/**'),
(220, 'logout', '/logout/**'),
(230, 'notice', '/notice/**'),
(240, 'usdmedia', '/usdmedia/**');


truncate table customer;
INSERT INTO `customer` (id, name, password, mail, gender, phone, profile_img, birth_start, birth_end, sys_user_id) VALUES 
(1,'张三','e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91','zs@ge.com',1,'13300000000','/usdmedia/media/1/head.png','2013-10-01','2013-10-07',2),
(2,'李四','e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91','ls@ge.com',1,'13400000000','/usdmedia/media/2/head.png','2013-10-01','2013-10-07',3),
(3,'王五','e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91','ww@ge.com',2,'13500000000','/usdmedia/media/3/head.png','2013-10-01','2013-10-07',4);

truncate table blog;
INSERT INTO `blog` (id, customer_id, title, content, emotion, create_time, update_time, blog_media_id, media_type) VALUES 
(1,1,'日记1','日记1内容',1,'2013-11-11 00:00:00',NULL,NULL,0),
(2,1,'日记2','日记2内容',1,'2013-11-11 00:00:00',NULL,NULL,1),
(3,2,'日记2','日记2内容',1,'2013-11-11 00:00:00',NULL,NULL,2),
(4,3,'日记3','日记3内容',1,'2013-11-11 00:00:00',NULL,NULL,0);

truncate table gallery;
INSERT INTO `gallery` (id, title, customer_id, create_time, gallery_type) VALUES 
(1,'2011-11-11',1,'2011-11-11 00:00:00',2),
(2,'2011-11-11',1,'2011-12-01 00:00:00',2),
(3,'2011-11-11',1,'2011-12-02 00:00:00',2),
(4,'2011-11-11',1,'2011-12-01 00:00:00',1),
(5,'2011-11-11',2,'2011-12-03 00:00:00',2);

truncate table media;
INSERT INTO media (id, blog_id, customer_id, media_url, media_type) values 
(1,2,1,'/usdmedia/media/1/20121211.jpg',1),
(2,2,1,'/usdmedia/media/1/20122312.jpg',1),
(3,NULL,2,'/usdmedia/usdpic/hsp001/pat001/2/1.png',2),
(4,NULL,2,'/usdmedia/usdpic/hsp001/pat001/2/2.png',2),
(5,NULL,1,'/usdmedia/usdpic/hsp001/pat001/1/1.png',2),
(6,NULL,1,'/usdmedia/usdpic/hsp001/pat001/3/1.png',2),
(7,NULL,1,'/usdmedia/usdpic/hsp001/pat001/3/2.png',2),
(8,NULL,1,'/usdmedia/usdpic/hsp001/pat001/3/3.png',2);

truncate table gallery_media;
INSERT INTO gallery_media (id, gallery_id, media_id) values
(1, 4, 1 ),
(2, 4, 2 ),
(3, 1, 5 ),
(4, 2, 3 ),
(5, 2, 4 ),
(6, 3, 6 ),
(7, 3, 7 ),
(8, 3, 8 );

truncate table remind;
INSERT INTO `remind` VALUES (1,2,1,'李四的提醒','李四的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(3,1,1,'张三的提醒1','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(4,1,1,'张三的提醒2','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(5,1,1,'张三的提醒3','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(6,1,1,'张三的提醒4','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(7,1,1,'张三的提醒5','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(8,1,1,'张三的提醒6','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(9,1,1,'张三的提醒7','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(10,1,1,'张三的提醒8','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(11,1,1,'张三的提醒9','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(12,1,1,'张三的提醒10','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(13,1,1,'张三的提醒11','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(14,1,1,'张三的提醒12','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(15,1,1,'张三的提醒13','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(16,1,1,'张三的提醒14','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(17,1,1,'张三的提醒15','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(18,1,1,'张三的提醒16','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(19,1,1,'张三的提醒17','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(20,1,1,'张三的提醒18','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(21,1,1,'张三的提醒19','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(22,1,1,'张三的提醒20','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(23,1,1,'张三的提醒21','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(24,1,1,'张三的提醒22','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(25,1,1,'张三的提醒23','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00'),
(26,1,1,'张三的提醒24','张三的提醒内容','2013-11-12 00:00:00','2013-11-13 00:00:00');

truncate table notice;
insert into notice (id, hospital_code, content, create_user_id, create_time, send_user_id, send_time, status, comments) values 
(1, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息1'),
(2, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息2'),
(3, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息3'),
(4, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息4'),
(5, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息5'),
(6, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息6'),
(7, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息7'),
(8, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息8'),
(9, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息9'),
(10, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息10'),
(11, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息11'),
(12, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息12'),
(13, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息13'),
(14, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息14'),
(15, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息15'),
(16, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息16'),
(17, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息17'),
(18, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息18'),
(19, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息19'),
(20, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息20'),
(21, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息21'),
(22, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息22'),
(23, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息23'),
(24, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息24'),
(25, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息25'),
(26, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息26'),
(27, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息27'),
(28, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息28'),
(29, 'hsp001', 'pat001', 1, now(), null, null, 1, '消息29'),
(30, 'hsp001', 'pat001', 1, now(), 1, null, 1, '消息30');

truncate table customer_relation;
insert into customer_relation (id, hospital_code, customer_id, patient_code) values
(1, 'hsp001', 1, 'pat001'),
(2, 'hsp003', 1, 'pat031'),
(3, 'hsp002', 2, 'pat002'),
(4, 'hsp002', 3, 'pat003');
