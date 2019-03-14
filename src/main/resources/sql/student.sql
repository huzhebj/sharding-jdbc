#创建学生表
CREATE TABLE `tbl_student_0` (
	`id` BIGINT(64) NOT NULL COMMENT '学生id',
	`age` INT(3) NOT NULL DEFAULT '0' COMMENT '年龄',
	`name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
	`cityID` BIGINT(20) NOT NULL DEFAULT '1' COMMENT '城市id',
	PRIMARY KEY (`id`)
)
COMMENT='学生表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_1` (
	`id` BIGINT(64) NOT NULL COMMENT '学生id',
	`age` INT(3) NOT NULL DEFAULT '0' COMMENT '年龄',
	`name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
	`cityID` BIGINT(20) NOT NULL DEFAULT '1' COMMENT '城市id',
	PRIMARY KEY (`id`)
)
COMMENT='学生表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_2` (
	`id` BIGINT(64) NOT NULL COMMENT '学生id',
	`age` INT(3) NOT NULL DEFAULT '0' COMMENT '年龄',
	`name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
	`cityID` BIGINT(20) NOT NULL DEFAULT '1' COMMENT '城市id',
	PRIMARY KEY (`id`)
)
COMMENT='学生表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `tbl_student_3` (
	`id` BIGINT(64) NOT NULL COMMENT '学生id',
	`age` INT(3) NOT NULL DEFAULT '0' COMMENT '年龄',
	`name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
	`cityID` BIGINT(20) NOT NULL DEFAULT '1' COMMENT '城市id',
	PRIMARY KEY (`id`)
)
COMMENT='学生表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

