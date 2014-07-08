truncate table pub_user; 
INSERT INTO pub_user (id, username, password, phone, email, enabled) values
(1, 'test',        'e85576b4c7e09df31bd1eee367c38486b2a7e0b7b79ed942cd670fce8038e20c0cea8e6b82632d91', '12345', '123@ge.com', 1);

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


