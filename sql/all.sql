-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2024-01-11 17:21:42
-- 服务器版本： 8.0.12
-- PHP 版本： 8.0.2

SET
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET
time_zone = "+00:00";

--
-- 数据库： `aaaa`
--

-- --------------------------------------------------------

--
-- 表的结构 `device`
--

CREATE TABLE `device`
(
    `id`             bigint(11) NOT NULL,
    `uuid`           varchar(255) COLLATE utf8_unicode_ci                    NOT NULL DEFAULT '' COMMENT '设备唯一id',
    `client`         varchar(20) COLLATE utf8_unicode_ci                     NOT NULL DEFAULT '' COMMENT 'ios,android,web',
    `name`           varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '设备名称',
    `model`          varchar(100) COLLATE utf8_unicode_ci                    NOT NULL DEFAULT '' COMMENT '设备的型号：iPhone',
    `utsname`        varchar(255) COLLATE utf8_unicode_ci                    NOT NULL DEFAULT '' COMMENT '机器名：iPod7,1',
    `system_name`    varchar(100) COLLATE utf8_unicode_ci                    NOT NULL DEFAULT '' COMMENT '系统名 iOS',
    `system_version` varchar(100) COLLATE utf8_unicode_ci                    NOT NULL DEFAULT '' COMMENT '系统版本',
    `ip`             varchar(20) COLLATE utf8_unicode_ci                     NOT NULL DEFAULT '' COMMENT 'ip',
    `useragent`      text COLLATE utf8_unicode_ci                            NOT NULL COMMENT 'ua',
    `created_at`     datetime                                                         DEFAULT NULL,
    `updated_at`     datetime                                                         DEFAULT NULL,
    `creator_id`     int(11) NOT NULL DEFAULT '0',
    `updater_id`     int(11) NOT NULL DEFAULT '0',
    `deleted`        tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user`
(
    `id`         bigint(11) NOT NULL,
    `phone`      varchar(20) COLLATE utf8_unicode_ci  NOT NULL DEFAULT '' COMMENT '手机号',
    `username`   varchar(111) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
    `password`   varchar(250) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
    `ip`         varchar(16) COLLATE utf8_unicode_ci  NOT NULL DEFAULT '' COMMENT 'ip',
    `useragent`  text COLLATE utf8_unicode_ci         NOT NULL COMMENT 'useragent',
    `created_at` datetime                                      DEFAULT NULL,
    `updated_at` datetime                                      DEFAULT NULL,
    `creator_id` int(11) DEFAULT NULL,
    `updater_id` int(11) DEFAULT NULL,
    `deleted`    tinyint(1) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `user_group`
--

CREATE TABLE `user_group`
(
    `id`          bigint(11) NOT NULL,
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '分组名',
    `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '描述',
    `created_at`  datetime                                                         DEFAULT NULL,
    `updated_at`  datetime                                                         DEFAULT NULL,
    `creator_id`  int(11) NOT NULL DEFAULT '0',
    `updater_id`  int(11) NOT NULL DEFAULT '0',
    `deleted`     tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转储表的索引
--

--
-- 表的索引 `device`
--
ALTER TABLE `device`
    ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- 表的索引 `user_group`
--
ALTER TABLE `user_group`
    ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `device`
--
ALTER TABLE `device`
    MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
    MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `user_group`
--
ALTER TABLE `user_group`
    MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT;
COMMIT;
