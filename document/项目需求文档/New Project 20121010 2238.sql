-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema `dynamic`
--

CREATE DATABASE IF NOT EXISTS `dynamic`;
USE `dynamic`;

--
-- Definition of table `c_sys_column`
--

DROP TABLE IF EXISTS `c_sys_column`;
CREATE TABLE `c_sys_column` (
  `id` varchar(32) NOT NULL COMMENT '32位UUID[全局唯一]',
  `table_id` varchar(32) NOT NULL COMMENT 'c_sys_table的主键,此列隶属于的表',
  `name` varchar(45) NOT NULL COMMENT '列名称',
  `colunm_physical_name` varchar(45) NOT NULL COMMENT '列物理名称',
  `value_type` char(1) NOT NULL COMMENT '列类型[文本,选择]',
  `length` varchar(5) NOT NULL COMMENT '值长度',
  `empty` char(1) default NULL COMMENT '是否为空',
  `primaryKey` char(1) default NULL COMMENT '是否为主键',
  `remark` varchar(45) default NULL COMMENT '列文字说明',
  `status` char(1) NOT NULL COMMENT '列状态[可用,不可用]',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='列描述信息';

--
-- Dumping data for table `c_sys_column`
--

/*!40000 ALTER TABLE `c_sys_column` DISABLE KEYS */;
INSERT INTO `c_sys_column` (`id`,`table_id`,`name`,`colunm_physical_name`,`value_type`,`length`,`empty`,`primaryKey`,`remark`,`status`) VALUES 
 ('2F9772F7D0DB4AD1BE3B7604C69F8C43','493B8F0754DE439DBC43027DD2F98EBB','name','Test_Column_name','0','20',NULL,NULL,NULL,'1'),
 ('4DB119E40AF8406482D372C6809CFB60','493B8F0754DE439DBC43027DD2F98EBB','age','Test_Column_age','0','20',NULL,NULL,NULL,'1'),
 ('E46669AA3B074DBC8B8E1396A02BF289','493B8F0754DE439DBC43027DD2F98EBB','address','Test_Column_address','0','20',NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `c_sys_column` ENABLE KEYS */;


--
-- Definition of table `c_sys_data_mapping`
--

DROP TABLE IF EXISTS `c_sys_data_mapping`;
CREATE TABLE `c_sys_data_mapping` (
  `id` varchar(32) NOT NULL,
  `source_type` char(1) NOT NULL,
  `dictionary_id` varchar(32) NOT NULL,
  `custom_sql` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `c_sys_data_mapping`
--

/*!40000 ALTER TABLE `c_sys_data_mapping` DISABLE KEYS */;
INSERT INTO `c_sys_data_mapping` (`id`,`source_type`,`dictionary_id`,`custom_sql`) VALUES 
 ('5E1624B6E9684C2EA89C9E0A3FD765E5','0','001','SELECT * FROM dict');
/*!40000 ALTER TABLE `c_sys_data_mapping` ENABLE KEYS */;


--
-- Definition of table `c_sys_data_verify`
--

DROP TABLE IF EXISTS `c_sys_data_verify`;
CREATE TABLE `c_sys_data_verify` (
  `id` varchar(32) NOT NULL,
  `rule` varchar(45) NOT NULL COMMENT '验证规则',
  `message` varchar(45) NOT NULL COMMENT '提示信息',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `c_sys_data_verify`
--

/*!40000 ALTER TABLE `c_sys_data_verify` DISABLE KEYS */;
INSERT INTO `c_sys_data_verify` (`id`,`rule`,`message`) VALUES 
 ('A60EFE1C90154BAC92F3052AC388397A','NotNull','不能为空！');
/*!40000 ALTER TABLE `c_sys_data_verify` ENABLE KEYS */;


--
-- Definition of table `c_sys_display_style`
--

DROP TABLE IF EXISTS `c_sys_display_style`;
CREATE TABLE `c_sys_display_style` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `display_style` char(1) NOT NULL,
  `width` varchar(10) NOT NULL,
  `height` varchar(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `c_sys_display_style`
--

/*!40000 ALTER TABLE `c_sys_display_style` DISABLE KEYS */;
INSERT INTO `c_sys_display_style` (`id`,`name`,`display_style`,`width`,`height`) VALUES 
 ('93F757257E054B98B3E6A4DA8D201091','测试显示样式','0','10000','123456');
/*!40000 ALTER TABLE `c_sys_display_style` ENABLE KEYS */;


--
-- Definition of table `c_sys_table`
--

DROP TABLE IF EXISTS `c_sys_table`;
CREATE TABLE `c_sys_table` (
  `id` varchar(32) character set utf8 collate utf8_bin NOT NULL COMMENT '32位UUID',
  `name` varchar(32) NOT NULL COMMENT '表名称[16个中文]',
  `table_physical_name` varchar(32) NOT NULL COMMENT '表物理名称',
  `create_time` varchar(14) default NULL COMMENT '创建时间[yyyyMMddHHmmss]',
  `type` char(1) NOT NULL COMMENT '表类型[表，视图]',
  `status` char(1) NOT NULL COMMENT '表状态[可用，不可用]',
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级使用表';

--
-- Dumping data for table `c_sys_table`
--

/*!40000 ALTER TABLE `c_sys_table` DISABLE KEYS */;
INSERT INTO `c_sys_table` (`id`,`name`,`table_physical_name`,`create_time`,`type`,`status`) VALUES 
 (0x3439334238463037353444453433394442433433303237444432463938454242,'测试学生基本信息表','Test_Student_Info',NULL,'0','1');
/*!40000 ALTER TABLE `c_sys_table` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
