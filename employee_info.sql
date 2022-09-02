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

 Date: 02/09/2022 10:22:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info`  (
  `id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT '1970-01-01',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '13800000000',
  `email` varchar(320) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `employee_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `password` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES (0944111, '张三', '男', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944122, '', '女', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944133, '', '男', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944144, '', '男', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944234, '', '女', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944345, '', '男', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944355, '', '女', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944444, '', '男', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944666, '', '女', '1970-01-01', '13800000000', NULL, NULL);
INSERT INTO `employee_info` VALUES (0944777, '', '男', '1970-01-01', '13800000000', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
