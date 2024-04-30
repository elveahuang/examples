DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user`
(
    `id`       BIGINT(20) UNSIGNED NOT NULL COMMENT 'ID',
    `username` VARCHAR(100)        NOT NULL COMMENT '',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_user_0`;

CREATE TABLE `t_user_0`
(
    `id`       BIGINT(20) UNSIGNED NOT NULL COMMENT 'ID',
    `username` VARCHAR(100)        NOT NULL COMMENT '',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_user_1`;

CREATE TABLE `t_user_1`
(
    `id`       BIGINT(20) UNSIGNED NOT NULL COMMENT 'ID',
    `username` VARCHAR(100)        NOT NULL COMMENT '',
    PRIMARY KEY (`id`)
);
