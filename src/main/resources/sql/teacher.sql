#############################################教师分库分表sql
#创建教师库
CREATE DATABASE `db_teacher_0`;
CREATE DATABASE `db_teacher_1`;
CREATE DATABASE `db_teacher_2`;

#创建教师表
CREATE TABLE `tbl_teacher_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherId` bigint(20) NOT NULL COMMENT '教师id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '教师姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='教师分表0'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_teacher_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherId` bigint(20) NOT NULL COMMENT '教师id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '教师姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='教师分表1'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_teacher_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherId` bigint(20) NOT NULL COMMENT '教师id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '教师姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='教师分表2'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_teacher_3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherId` bigint(20) NOT NULL COMMENT '教师id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '教师姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='教师分表3'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_teacher_4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherId` bigint(20) NOT NULL COMMENT '教师id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '教师姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='教师分表4'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

