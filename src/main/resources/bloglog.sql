
create database bloglog;
use bloglog;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '文章内容',
  `pubtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `read_number` int(11) DEFAULT '0',
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `content2` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ghcl8vj985gdv3mp4ragthfoc` (`type_id`),
  KEY `FK_tcgc5bv7iarylc19wy17n3r6c` (`user_id`),
  CONSTRAINT `FK_ghcl8vj985gdv3mp4ragthfoc` FOREIGN KEY (`type_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_tcgc5bv7iarylc19wy17n3r6c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(11) NOT NULL,
  `type_name` varchar(255) DEFAULT NULL COMMENT '类型名称（专业课，后端开发，算法学习，生活点滴  四选一）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '专业课');
INSERT INTO `category` VALUES ('2', '后端开发');
INSERT INTO `category` VALUES ('3', '算法学习');
INSERT INTO `category` VALUES ('4', '生活点滴');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `content` text COMMENT '内容',
  `article_id` bigint(20) DEFAULT '20',
  `review_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT '95',
  PRIMARY KEY (`id`),
  KEY `FK_qcs11flwx2d930p5pbefo5mj4` (`article_id`),
  KEY `FK_jdnb3cnup5vq6opj19kbm8w4d` (`user_id`),
  KEY `FK_r5l24vpi1wf35q8h3e7lejuar` (`review_id`),
  CONSTRAINT `FK_jdnb3cnup5vq6opj19kbm8w4d` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_qcs11flwx2d930p5pbefo5mj4` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `FK_r5l24vpi1wf35q8h3e7lejuar` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mark` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '管理员', 'ADMIN');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK_njajel6a2q8tr36emb9l8vw7n` (`user_id`),
  KEY `FK_1p4td69hdcg4iaau4pvj20m3h` (`role_id`),
  CONSTRAINT `FK_1p4td69hdcg4iaau4pvj20m3h` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_njajel6a2q8tr36emb9l8vw7n` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('1', '149');

-- ----------------------------
-- Table structure for temporary_article
-- ----------------------------
DROP TABLE IF EXISTS `temporary_article`;
CREATE TABLE `temporary_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `save_time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nxkrxtv9wk5dheqt3yn82v30c` (`user_id`),
  CONSTRAINT `FK_nxkrxtv9wk5dheqt3yn82v30c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temporary_article
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `password` varchar(15) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `roles_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ntc01ead2d77ypev4qkp2x7si` (`roles_id`),
  CONSTRAINT `FK_ntc01ead2d77ypev4qkp2x7si` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('93', 'kklo', '123456', null, null, null);
INSERT INTO `user` VALUES ('149', 'Admin', 'Admin', null, null, '1');
INSERT INTO `user` VALUES ('155', 'bhb', '666666', null, '', null);
SET FOREIGN_KEY_CHECKS=1;
