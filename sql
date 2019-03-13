#创建学生表
CREATE TABLE `tbl_student` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '学生id',
	`name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
	PRIMARY KEY (`id`)
)
COMMENT='学生表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

