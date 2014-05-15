/*
SQLyog Community v11.2 RC1 (64 bit)
MySQL - 5.1.66-0ubuntu0.10.04.1 : Database - aniketos_runtime
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aniketos_runtime` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `aniketos_runtime`;

/*Table structure for table `results` */

DROP TABLE IF EXISTS `results`;

CREATE TABLE `results` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instanceId` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `variableName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `variableResult` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2088 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `serviceTasks` */

DROP TABLE IF EXISTS `serviceTasks`;

CREATE TABLE `serviceTasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `atomicServiceUrl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `taskId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `bpmn` text COLLATE utf8_unicode_ci NOT NULL,
  `compositeServiceName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2664 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `services` */

DROP TABLE IF EXISTS `services`;

CREATE TABLE `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `processId` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `deploymentId` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=242 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
