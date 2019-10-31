/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : baho_ecc_zhengshi

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 31/10/2019 10:48:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sd_tbsoentry
-- ----------------------------
DROP TABLE IF EXISTS `t_sd_tbsoentry`;
CREATE TABLE `t_sd_tbsoentry`  (
  `FID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FADJUSTFEE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FBINDOID` bigint(20) NULL DEFAULT NULL,
  `FBUYERNICK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FBUYERRATE` bit(1) NULL DEFAULT NULL,
  `FCID` bigint(20) NULL DEFAULT NULL,
  `FCONSIGNTIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FDISCOUNTFEE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FENDTIME` datetime(0) NULL DEFAULT NULL,
  `FIID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FINVOICENO` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FISOVERSOLD` bit(1) NULL DEFAULT NULL,
  `FISSERVICEORDER` bit(1) NULL DEFAULT NULL,
  `FITEMMEALID` bigint(20) NULL DEFAULT NULL,
  `FITEMMEALNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FLOGISTICSCOMPANY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FMODIFIED` datetime(0) NULL DEFAULT NULL,
  `FNUM` bigint(20) NULL DEFAULT NULL,
  `FNUMIID` bigint(20) NULL DEFAULT NULL,
  `FOID` bigint(20) NULL DEFAULT NULL,
  `FORDERFROM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FOUTERIID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FOUTERSKUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FPAYMENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FPICPATH` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `FPRICE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FREFUNDID` bigint(20) NULL DEFAULT NULL,
  `FREFUNDSTATUS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FSELLERNICK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FSELLERRATE` bit(1) NULL DEFAULT NULL,
  `FSELLERTYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FSHIPPINGTYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FSKUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FSKUPROPERTIESNAME` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `FSNAPSHOT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `FSNAPSHOTURL` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `FSTATUS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FTIMEOUTACTIONTIME` datetime(0) NULL DEFAULT NULL,
  `FTITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FTOTALFEE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FPARENTID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FVERSION` int(11) NULL DEFAULT 0,
  `ftenantid` bigint(10) NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`FID`) USING BTREE,
  INDEX `sd_tbsoentry_index1`(`FPARENTID`) USING BTREE,
  INDEX `sd_tbsoentry_index2`(`FOID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sd_tbsoentry
-- ----------------------------
INSERT INTO `t_sd_tbsoentry` VALUES ('00002048cded49909238cb91a03152d8', '0.00', NULL, NULL, b'0', 50006024, '2019-06-20 03:18:37', '92.34', '2019-06-30 03:18:46', NULL, '259294363498', b'0', NULL, NULL, NULL, '顺丰速运', NULL, 1, 535396550326, 307100079368118802, 'WAP,JHS,WAP', NULL, '6941753397587', '56.66', 'https://img.alicdn.com/bao/uploaded/i3/820521956/O1CN014PtUb51QJtExM3X0L_!!820521956.jpg', '149.00', NULL, 'NO_REFUND', NULL, b'0', 'B', 'express', '4258200691042', '颜色分类:青柠绿【现货】', NULL, 'o:307100079368118802_1', 'TRADE_FINISHED', NULL, '【狂欢价】可优比宝宝儿童坐便器婴儿小孩小马桶女座便器婴幼儿男便盆尿盆', '65.00', '85e74c8e04dd49838348522869e9bd7e', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
