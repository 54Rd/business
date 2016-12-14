/*
Navicat MySQL Data Transfer

Source Server         : eb_data_test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : eb_test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-14 22:52:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for eb_auth_local
-- ----------------------------
DROP TABLE IF EXISTS `eb_auth_local`;
CREATE TABLE `eb_auth_local` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserID` bigint(20) NOT NULL,
  `UserName` varchar(20) NOT NULL COMMENT '用户账户',
  `PassWord` varchar(50) NOT NULL,
  `InsertTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  PRIMARY KEY (`ID`),
  KEY `IX_UserID` (`UserID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eb_user_con
-- ----------------------------
DROP TABLE IF EXISTS `eb_user_con`;
CREATE TABLE `eb_user_con` (
  `UserID` bigint(20) NOT NULL DEFAULT '0',
  `InsertTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `RoleID` int(11) DEFAULT '0' COMMENT '对应权限的角色ID',
  `IsLimit` tinyint(4) DEFAULT '0' COMMENT '是否限制登陆',
  `DataStatus` int(11) DEFAULT '1' COMMENT '1-有效，9-删除',
  KEY `UserID` (`UserID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eb_user_profile
-- ----------------------------
DROP TABLE IF EXISTS `eb_user_profile`;
CREATE TABLE `eb_user_profile` (
  `UserID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  `RealName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`UserID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100020 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `Id` int(11) DEFAULT NULL,
  `Num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
