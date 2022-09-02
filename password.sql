/*
 Navicat Premium Data Transfer

 Source Server         : duty
 Source Server Type    : MySQL
 Source Server Version : 100424 (10.4.24-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : duty

 Target Server Type    : MySQL
 Target Server Version : 100424 (10.4.24-MariaDB)
 File Encoding         : 65001

 Date: 02/09/2022 09:31:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for password
-- ----------------------------
DROP TABLE IF EXISTS `password`;
CREATE TABLE `password`  (
  `id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `Username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '12345678',
  `level` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of password
-- ----------------------------
INSERT INTO `password` VALUES (0944111, '张三', 'zhangsan123', b'1');
INSERT INTO `password` VALUES (0944122, '李四', 'lisi1234', b'0');
INSERT INTO `password` VALUES (0944133, '王五', 'wangwu12345', b'0');
INSERT INTO `password` VALUES (0944144, '赵六', 'zhaoliu123456', b'0');
INSERT INTO `password` VALUES (0944234, '赵七', 'zhaoqi1234567', b'0');
INSERT INTO `password` VALUES (0944345, '赵八', '12345678', b'0');
INSERT INTO `password` VALUES (0944355, '赵九', 'zhao123456789', b'0');
INSERT INTO `password` VALUES (0944444, '赵四', 'zhao1234', b'0');
INSERT INTO `password` VALUES (0944666, '赵老六', 'liu123456', b'0');
INSERT INTO `password` VALUES (0944777, '赵老七', 'qi1234567', b'0');

SET FOREIGN_KEY_CHECKS = 1;
