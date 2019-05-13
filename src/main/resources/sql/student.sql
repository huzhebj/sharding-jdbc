#############################################学生分库分表sql
#创建学生库
CREATE DATABASE `db_student_0`;
CREATE DATABASE `db_student_1`;
CREATE DATABASE `db_student_2`;
CREATE DATABASE `db_student_3`;
CREATE DATABASE `db_student_4`;

#创建学生表
CREATE TABLE `tbl_student_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表0'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表1'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表2'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表3'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表4'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_5` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表5'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_6` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表6'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表7'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_8` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表8'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_9` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentId` bigint(20) NOT NULL COMMENT '学生id',
  `cityId` int(11) DEFAULT NULL COMMENT '城市id',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`id`)
) COMMENT='学生分表9'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

