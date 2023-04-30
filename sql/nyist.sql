/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.22 : Database - nyist
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nyist` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `nyist`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `descri` text,
  `photo` varchar(100) DEFAULT NULL,
  `pubdate` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_T_BOOK_TID_idx` (`tid`) USING BTREE,
  CONSTRAINT `FK_T_BOOK_TID` FOREIGN KEY (`tid`) REFERENCES `t_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`name`,`author`,`tid`,`price`,`descri`,`photo`,`pubdate`) values (33,'Vue.js','111',1,30,'开发理论与编码实践结合，让你不仅学有所成，更能学以致用！ 系统：从点到面讲解，循序渐进，有条有理 \r\n深入：以底层筑基实现上层运用，让你知其所以然 实用：提供62个应用案例，以实践检验真理 实战','4456c0e0-d3d4-40b4-b63c-cf3571e66242.jpg','1900-01-01'),(34,'Java核心技术卷Ⅰ','222',2,80,'Java领域极有影响力和价值的著作之一，与《Java编程思想》齐名，10余年全球畅销不衰，广受好评。 \r\n针对Java SE 9、10、11全面更新，系统全面讲解Java语言的核心概念、语法、重要特性和开发方法，包含大量案例，实践性强。','0fd0c981-d169-49c9-9352-5a48c55ec816.jpg','2020-10-10'),(35,'JavaScript','666',3,100,'web前端开发经典教程，JS“红宝书”全新升级，入门+实战，涵盖ECMAScript 2019，提供教学视频+配套编程环境，可直接在线运行随书代码 给少年的你','084900d8-6060-4a9d-9aaa-fad61e62221a.jpg','2021-06-18'),(36,'Java虚拟机','888',1,50,'互联网大厂面试核心知识点全覆盖 ！这本书值得所有Java技术人员读3遍，值得Java技术人员读3遍，值得读3遍！ （2）根据 JDK12和JDK 13 EA版本 全面更新，新增内容近50%','f1bde543-ea8e-4e0b-8fe6-54d017322a5a.jpg','2000-11-11');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values (1,'电子书'),(2,'文学'),(3,'数学');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pwd` varchar(60) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`name`,`pwd`,`birthday`,`age`,`photo`) values (2,'user','$2a$10$u9ZRukgj5tpx7hp42DFgjuIntaaiHJZBINJlnXM/.dE2U5dq0gSTi','3898-08-01','23',NULL),(25,'weiye','123456','2020-08-21','21','b2cecf4a-8a3f-4252-b689-92824dceafba.jpg'),(26,'weiye1','123456','2020-08-21','21','a8ab04b7-e347-42dc-a7de-448a2b40c115.jpg');

/* Procedure structure for procedure `findUserCount` */

/*!50003 DROP PROCEDURE IF EXISTS  `findUserCount` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `findUserCount`(IN cname VARCHAR(12),OUT result INT)
begin
	select count(*)into result from t_user where name like concat(concat('%',cname),'%');
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
