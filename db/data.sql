CREATE TABLE `test_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `age` int(11) NOT NULL DEFAULT '-1' COMMENT 'age',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'userName',
  `password` varchar(20) NOT NULL DEFAULT '123456',
  `created_at` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createdAt',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='test_model';

-- 数据
INSERT INTO `test_model` VALUES (1, 18, 'Apple', '123456', '2019-7-2 14:06:15', '2019-7-2 14:06:18');
INSERT INTO `test_model` VALUES (2, 22, 'ubuntu', '000000', '2019-7-2 14:06:40', '2019-7-2 14:06:42');
INSERT INTO `test_model` VALUES (3, 25, 'admin', '123456', '2019-7-2 14:06:40', '2019-7-2 14:06:42');
INSERT INTO `test_model` VALUES (4, 28, 'console', '123456', '2019-7-2 14:06:40', '2019-7-2 14:06:42');