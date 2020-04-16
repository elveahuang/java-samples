/*
建库
*/
DROP DATABASE IF EXISTS `java-samples`;

CREATE DATABASE IF NOT EXISTS `java-samples` DEFAULT CHARACTER SET `utf8mb4` DEFAULT COLLATE `utf8mb4_unicode_ci`;

USE `java-samples`;

/*
用户表
*/
CREATE TABLE `sys_user`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `username`    VARCHAR(150) COMMENT '用户名',
    `email`       VARCHAR(150) COMMENT '邮箱',
    `mobile`      VARCHAR(150) COMMENT '手机',
    `nickname`    VARCHAR(255) COMMENT '昵称',
    `fullname`    VARCHAR(255) COMMENT '全名',
    `password`    VARCHAR(255) COMMENT '密码',
    `status`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '用户状态',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_usr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user`
    COMMENT '用户表';

CREATE INDEX `ix_usr_username` ON `sys_user` (`username`);
CREATE INDEX `ix_usr_mobile` ON `sys_user` (`mobile`);
CREATE INDEX `ix_usr_email` ON `sys_user` (`email`);

INSERT INTO `sys_user` (`id`, `username`, `email`, `mobile`,
                        `nickname`, `status`, `active`, `password`,
                        `created_at`, `created_by`, `modified_at`, `modified_by`)
VALUES (1, 'admin', 'master@host.com', '13800138000', 'Administrator', 1, 1,
        '$2a$10$NCaQsuUAmjMGYpDFCexkDumlA7aexspqelQews287jBk0cF5koypy',
        now(), 1, now(), 1);
