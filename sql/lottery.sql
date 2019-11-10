/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.13 : Database - lottery
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=''NO_AUTO_VALUE_ON_ZERO'' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lottery` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `lottery`;

/*Table structure for table `blog` */

CREATE TABLE `blog` (
  `id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

/*Table structure for table `t_act` */

CREATE TABLE `t_act` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `actType` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ''活动类型'',
  `platformType` varchar(225) DEFAULT NULL COMMENT ''平台类型（kub,diai）'',
  `actName` varchar(64) DEFAULT NULL COMMENT ''活动名称'',
  `actInfo` varchar(255) DEFAULT NULL COMMENT ''活动信息介绍'',
  `createDt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `lastModified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT=''活动表'';

/*Data for the table `t_act` */

insert  into `t_act`(`id`,`actType`,`platformType`,`actName`,`actInfo`,`createDt`,`lastModified`) values (1,''ceshi2'',''kub'',''99活动'',''该活动正在参与中'',''2019-10-11 10:00:35'',''2019-11-01 10:12:01''),(2,''ceshi0000'',''diai'',''双11活动'',''该活动正在参与中'',''2019-10-14 18:09:30'',''2019-11-01 10:08:25'');

/*Table structure for table `t_file` */

CREATE TABLE `t_file` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `actId` int(10) DEFAULT NULL COMMENT ''活动表主键'',
  `theType` varchar(255) DEFAULT NULL COMMENT ''是否是主图，或存在的位置，logo或其他图片'',
  `showName` varchar(255) DEFAULT NULL COMMENT ''图片名称'',
  `realUrl` varchar(255) DEFAULT NULL COMMENT ''阿里云存储位置'',
  `previewUrl` varchar(255) DEFAULT NULL COMMENT ''预览下载地址'',
  `createDt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT=''文件表'';

/*Data for the table `t_file` */

insert  into `t_file`(`id`,`actId`,`theType`,`showName`,`realUrl`,`previewUrl`,`createDt`) values (1,NULL,NULL,''03.png'','''',''http://baho.oss-cn-hangzhou.aliyuncs.com/?Expires=1886557900&OSSAccessKeyId=LTAIvZRrSH0xRwa0&Signature=Skiao7NKRUSYZwAALyNUivC%2FhKI%3D'',''2019-10-16 11:49:37''),(2,NULL,NULL,''03.png'','''',''http://baho.oss-cn-hangzhou.aliyuncs.com/?Expires=1886558922&OSSAccessKeyId=LTAIvZRrSH0xRwa0&Signature=2d0lJeS%2FBrNDRFOOR4BLPJGlFSs%3D'',''2019-10-16 12:06:38''),(3,NULL,NULL,''03.png'',''user/ceshi/2019-10/2019-10-16/20191016130628922.png'',''http://baho.oss-cn-hangzhou.aliyuncs.com/user/ceshi/2019-10/2019-10-16/20191016130628922.png?Expires=1886562389&OSSAccessKeyId=LTAIvZRrSH0xRwa0&Signature=xVaM319ImUuaLzVvDqpdYpXE07M%3D'',''2019-10-16 13:04:52''),(4,NULL,NULL,''04.jpg'',''user/ceshi/2019-10/2019-10-16/20191016131132893.jpg'',''http://baho.oss-cn-hangzhou.aliyuncs.com/user/ceshi/2019-10/2019-10-16/20191016131132893.jpg?Expires=1886562692&OSSAccessKeyId=LTAIvZRrSH0xRwa0&Signature=ngH6gvnvJfPoUl7zjhqsYiuSvbg%3D'',''2019-10-16 13:09:28'');

/*Table structure for table `t_prize` */

CREATE TABLE `t_prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platformType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ''平台类型（kub,diai）'',
  `nick` varchar(255) DEFAULT NULL COMMENT ''买家昵称'',
  `billNum` varchar(255) DEFAULT NULL COMMENT ''订单编号'',
  `orderDt` datetime DEFAULT NULL COMMENT ''下单时间'',
  `prizeType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ''奖品类型（口碑券、天猫超市卡等）奖品名称'',
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ''购买商品'',
  `deviceInfo` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ''设备信息'',
  `prizeStatus` int(6) DEFAULT ''0'' COMMENT ''是否已经领取奖品（1:已领取；0:未领取）'',
  `receiveDt` datetime DEFAULT NULL COMMENT ''领取时间'',
  `createDt` datetime DEFAULT CURRENT_TIMESTAMP,
  `actId` int(10) DEFAULT NULL COMMENT ''活动表主键'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT=''中间信息表'';

/*Data for the table `t_prize` */

insert  into `t_prize`(`id`,`platformType`,`nick`,`billNum`,`orderDt`,`prizeType`,`goodsName`,`deviceInfo`,`prizeStatus`,`receiveDt`,`createDt`,`actId`) values (1,''kub'',''王五'',''545636902702951289'',''2019-10-11 10:40:04'',''口碑券'',''XPE爬爬垫'',''【Apache-HttpClient/4.5.3 (Java/1.7.0_75)】,【47.92.244.102】'',0,''2019-10-15 16:12:00'',''2019-10-11 10:41:23'',1),(2,''diai'',''王五'',''545636902702951289'',''2019-10-15 18:12:33'',''天猫超市卡'',''靠谱'',NULL,0,''2019-10-15 16:57:37'',''2019-10-14 18:10:17'',2),(3,''kub'',''王五'',''3255210291235267'',''2019-10-23 13:55:14'',''天猫超市卡'',''XPE爬爬垫'',''【Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1】,【172.16.0.1】'',0,''2019-10-18 13:15:08'',''2019-10-15 09:10:36'',1),(4,''kub'',''王五'',''488003777181744288'',''2019-10-08 09:53:18'',''天猫超市卡'',''XPE爬爬垫'',''【Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1】,【172.16.0.1】'',1,''2019-11-04 10:53:04'',''2019-10-15 18:11:47'',1),(5,''kub'',''李四'',''496716642673604454'',''2019-10-17 09:53:15'',''天猫超市卡'',''XPE爬爬垫'',''【Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Mobile Safari/537.36】,【172.16.0.1】'',0,''2019-10-18 13:59:35'',''2019-10-17 09:50:56'',1),(6,''diai'',''王五'',''569385155060416471'',NULL,''天猫超市卡'',''靠谱'',''【Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1】,【172.16.0.1】'',1,''2019-11-02 17:33:58'',''2019-10-17 14:50:50'',2),(7,''kub'',''张三'',''493076257140463091'',''2019-10-17 17:24:02'',''小卡片'',''哈哈'',''【Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36】,【172.16.0.1】'',1,''2019-10-18 16:28:36'',''2019-10-17 17:21:42'',1),(8,''kub'',''王五'',''507446402947065904'',''2019-10-08 17:25:36'',''大卡片'',''哟呵'',''【Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36】,【172.16.0.1】'',1,''2019-10-21 14:58:00'',''2019-10-17 17:23:27'',1),(9,''kub'',''王五'',''493076257140463091'',NULL,NULL,NULL,''【Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36】,【172.16.0.1】'',1,''2019-11-04 10:52:46'',''2019-10-18 12:32:02'',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
