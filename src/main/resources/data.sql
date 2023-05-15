INSERT INTO roles (role_id, role_name) VALUES (1, 'ADMIN');
INSERT INTO roles (role_id, role_name) VALUES (2, 'USER');

INSERT INTO category (category_id, category_name) VALUES (1, 'living thing');
INSERT INTO category (category_id, category_name) VALUES (2, 'machine');
INSERT INTO category (category_id, category_name) VALUES (3, 'nature');

INSERT INTO `person` (`first_name`,`email`,`pwd`,`role_id`,`created_at`, `created_by`) VALUES ('admin','admin','admin123', 1 ,CURDATE(),'admin');
INSERT INTO `person` (`first_name`,`email`,`pwd`,`role_id`,`created_at`, `created_by`) VALUES ('Yousif','yousif','12345', 2 ,CURDATE(),'admin');