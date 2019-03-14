#创建城市表
CREATE TABLE `tbl_city` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '城市id',
	`cityName` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '城市名称',
	PRIMARY KEY (`id`)
)
COMMENT='城市表'
COLLATE='utf8_general_ci';

