/*
Navicat MySQL Data Transfer

Source Server         : locahost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : eseal

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-04-30 13:20:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_dicinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_dicinfo`;
CREATE TABLE `tb_dicinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dicCode` varchar(50) DEFAULT NULL,
  `dicDesc` varchar(200) DEFAULT NULL,
  `dicGroup` varchar(50) DEFAULT NULL,
  `dicValue` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dicinfo
-- ----------------------------
INSERT INTO `tb_dicinfo` VALUES ('1', '系统最高', '拥有最高的管理权限。拥有所有操作权限。', 'roleType', '1');
INSERT INTO `tb_dicinfo` VALUES ('2', '管理员', '具有管理权根。可以管理系统日常操作。', 'roleType', '2');
INSERT INTO `tb_dicinfo` VALUES ('3', '普通用户', '普通操作用户。', 'roleType', '3');
INSERT INTO `tb_dicinfo` VALUES ('4', '测试人员', '测试', 'roleType', '4');
INSERT INTO `tb_dicinfo` VALUES ('5', '运营人员', '运营', 'roleType', '5');
INSERT INTO `tb_dicinfo` VALUES ('6', '客户', '第三方客户', 'roleType', '6');

-- ----------------------------
-- Table structure for `tb_function`
-- ----------------------------
DROP TABLE IF EXISTS `tb_function`;
CREATE TABLE `tb_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `functionName` varchar(300) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `tbModule_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5372F28971695874` (`tbModule_fk`),
  KEY `FK5372F289DB5B52F9` (`tbModule_fk`),
  CONSTRAINT `FK5372F289DB5B52F9` FOREIGN KEY (`tbModule_fk`) REFERENCES `tb_module` (`id`),
  CONSTRAINT `tb_function_ibfk_1` FOREIGN KEY (`tbModule_fk`) REFERENCES `tb_module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_function
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_logs`
-- ----------------------------
DROP TABLE IF EXISTS `tb_logs`;
CREATE TABLE `tb_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `logs` varchar(255) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1623 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_logs
-- ----------------------------
INSERT INTO `tb_logs` VALUES ('1581', '2015-04-24 11:08:39', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1583', '2015-04-24 15:02:13', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1584', '2015-04-24 15:18:18', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1585', '2015-04-24 15:32:27', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1586', '2015-04-24 15:34:25', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1587', '2015-04-24 17:46:32', '192.168.4.24', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1588', '2015-04-27 08:52:57', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1589', '2015-04-27 09:18:02', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1590', '2015-04-27 12:00:05', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1591', '2015-04-27 14:00:27', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1596', '2015-04-29 18:04:22', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1597', '2015-04-29 18:06:47', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1598', '2015-04-29 18:09:46', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1599', '2015-04-30 09:24:13', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1600', '2015-04-30 09:33:10', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1601', '2015-04-30 09:33:56', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1602', '2015-04-30 09:42:48', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1603', '2015-04-30 09:47:20', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1604', '2015-04-30 10:06:05', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1605', '2015-04-30 10:20:01', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1606', '2015-04-30 10:21:56', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1607', '2015-04-30 10:27:37', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1608', '2015-04-30 10:34:11', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1609', '2015-04-30 10:42:11', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1610', '2015-04-30 10:45:01', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1611', '2015-04-30 10:53:45', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1612', '2015-04-30 11:03:32', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1613', '2015-04-30 11:14:22', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1614', '2015-04-30 11:26:52', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1615', '2015-04-30 12:52:21', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1616', '2015-04-30 12:52:47', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1617', '2015-04-30 12:54:31', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1618', '2015-04-30 12:55:30', '127.0.0.1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1619', '2015-04-30 12:57:24', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1620', '2015-04-30 12:57:32', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1621', '2015-04-30 13:17:42', '0:0:0:0:0:0:0:1', '登录系统', 'admin');
INSERT INTO `tb_logs` VALUES ('1622', '2015-04-30 13:18:34', '0:0:0:0:0:0:0:1', '登录系统', 'admin');

-- ----------------------------
-- Table structure for `tb_module`
-- ----------------------------
DROP TABLE IF EXISTS `tb_module`;
CREATE TABLE `tb_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expanded` bit(1) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  `iconCls` varchar(20) DEFAULT NULL,
  `leaf` bit(1) DEFAULT NULL,
  `moduleId` varchar(30) DEFAULT NULL,
  `text` varchar(50) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `moduleId` (`moduleId`),
  KEY `FK54F11D5D18397AEF` (`parentId`),
  KEY `FK54F11D5D822B7574` (`parentId`),
  CONSTRAINT `FK54F11D5D822B7574` FOREIGN KEY (`parentId`) REFERENCES `tb_module` (`id`),
  CONSTRAINT `tb_module_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `tb_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_module
-- ----------------------------
INSERT INTO `tb_module` VALUES ('1', null, null, 'icon-hotel', null, 'platformMgr', '平台管理', null);
INSERT INTO `tb_module` VALUES ('2', '', '', 'icon-catalog', '', 'sysManager', '系统管理', '1');
INSERT INTO `tb_module` VALUES ('3', '', '/sysManager/userManager.js', 'details', '', 'userManagerPanel', '用户管理', '2');
INSERT INTO `tb_module` VALUES ('4', '', '/sysManager/moduleManager.js,/sysManager/moduleAddWin.js', 'details', '', 'moduleManagerPanel', '模块管理', '2');
INSERT INTO `tb_module` VALUES ('5', '', '/sysManager/permissionManager.js', 'details', '', 'permissionManagerPanel', '权限管理', '2');
INSERT INTO `tb_module` VALUES ('6', '', '/sysManager/logsManager.js', 'details', '', 'logsManagerPanel', '日志管理', '2');
INSERT INTO `tb_module` VALUES ('7', '', '/sysManager/modifyPwd.js', 'details', '', 'modifyPwdPanel', '修改密码', '2');

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleDesc` varchar(100) DEFAULT NULL,
  `roleName` varchar(64) DEFAULT NULL,
  `roleType` varchar(255) DEFAULT NULL,
  `roleCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roleName` (`roleName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('2', '拥有最高的权限。', '系统最高', '1', '系统最高');
INSERT INTO `tb_role` VALUES ('3', '作为系统的管理人员，权限弱小于系统最高用户。', '管理员', '2', '管理员');

-- ----------------------------
-- Table structure for `tb_role_tb_function`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_tb_function`;
CREATE TABLE `tb_role_tb_function` (
  `tbRoles_id` bigint(20) NOT NULL,
  `tbFunctions_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tbRoles_id`,`tbFunctions_id`),
  KEY `FK5AD00DF1EC5B743` (`tbFunctions_id`),
  KEY `FK5AD00DF1D736C77F` (`tbRoles_id`),
  KEY `FK5AD00DF1C4232488` (`tbFunctions_id`),
  KEY `FK5AD00DF14FFF9F44` (`tbRoles_id`),
  CONSTRAINT `FK5AD00DF14FFF9F44` FOREIGN KEY (`tbRoles_id`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `FK5AD00DF1C4232488` FOREIGN KEY (`tbFunctions_id`) REFERENCES `tb_function` (`id`),
  CONSTRAINT `tb_role_tb_function_ibfk_1` FOREIGN KEY (`tbRoles_id`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `tb_role_tb_function_ibfk_2` FOREIGN KEY (`tbFunctions_id`) REFERENCES `tb_function` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_tb_function
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_role_tb_module`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_tb_module`;
CREATE TABLE `tb_role_tb_module` (
  `tbRoles_id` bigint(20) NOT NULL,
  `tbModules_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tbRoles_id`,`tbModules_id`),
  KEY `FK382DF2C51A698D6B` (`tbModules_id`),
  KEY `FK382DF2C5D736C77F` (`tbRoles_id`),
  KEY `FK382DF2C5845B87F0` (`tbModules_id`),
  KEY `FK382DF2C54FFF9F44` (`tbRoles_id`),
  CONSTRAINT `FK382DF2C54FFF9F44` FOREIGN KEY (`tbRoles_id`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `FK382DF2C5845B87F0` FOREIGN KEY (`tbModules_id`) REFERENCES `tb_module` (`id`),
  CONSTRAINT `tb_role_tb_module_ibfk_1` FOREIGN KEY (`tbModules_id`) REFERENCES `tb_module` (`id`),
  CONSTRAINT `tb_role_tb_module_ibfk_2` FOREIGN KEY (`tbRoles_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_tb_module
-- ----------------------------
INSERT INTO `tb_role_tb_module` VALUES ('2', '1');
INSERT INTO `tb_role_tb_module` VALUES ('3', '1');
INSERT INTO `tb_role_tb_module` VALUES ('2', '2');
INSERT INTO `tb_role_tb_module` VALUES ('3', '2');
INSERT INTO `tb_role_tb_module` VALUES ('2', '3');
INSERT INTO `tb_role_tb_module` VALUES ('3', '3');
INSERT INTO `tb_role_tb_module` VALUES ('2', '4');
INSERT INTO `tb_role_tb_module` VALUES ('3', '4');
INSERT INTO `tb_role_tb_module` VALUES ('2', '5');
INSERT INTO `tb_role_tb_module` VALUES ('3', '5');
INSERT INTO `tb_role_tb_module` VALUES ('2', '6');
INSERT INTO `tb_role_tb_module` VALUES ('3', '6');
INSERT INTO `tb_role_tb_module` VALUES ('2', '7');
INSERT INTO `tb_role_tb_module` VALUES ('3', '7');

-- ----------------------------
-- Table structure for `tb_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` varchar(4) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF13C65CA3C6A4145` (`roleId`),
  KEY `FKF13C65CAB533190A` (`roleId`),
  CONSTRAINT `FKF13C65CAB533190A` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `tb_userinfo_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userinfo
-- ----------------------------
INSERT INTO `tb_userinfo` VALUES ('1', '2011-03-10 00:00:00', 'admin@163.com', 'fe4053114c7c4e7c02bd6362063bfa9f', '13510122175', '正常', '2015-04-30 10:45:12', 'admin', '2');
INSERT INTO `tb_userinfo` VALUES ('36', null, 'hepx@163.com', 'fe4053114c7c4e7c02bd6362063bfa9f', '13312974165', '正常', '2015-04-30 10:32:40', 'hepx', '3');
