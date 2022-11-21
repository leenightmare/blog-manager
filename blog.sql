/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : ksblog

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2022-11-21 10:25:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog_article`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '文章作者',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '文章标题',
  `description` varchar(500) DEFAULT NULL COMMENT '文章描述',
  `image` varchar(200) DEFAULT NULL COMMENT '文章的预览图片',
  `content` longtext CHARACTER SET utf8mb4 COMMENT '文章内容',
  `content_md` longtext CHARACTER SET utf8mb4 COMMENT ' Markdown格式的文章内容',
  `create_time` datetime NOT NULL COMMENT '发表时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `comment_count` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `visits` int(11) NOT NULL DEFAULT '0' COMMENT '访问量',
  `poll_count` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `is_comment` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否开启评论 0：关闭 1：开启',
  `is_top` tinyint(4) DEFAULT '0' COMMENT '文章是否置顶  0：否  1：是',
  `is_reward` tinyint(4) DEFAULT '1' COMMENT '是否开启赞赏 0:否 1:是',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 0：草稿 1：已发布 2：回收站',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of blog_article
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_article_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) NOT NULL COMMENT '文章ID',
  `tag_id` bigint(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章与标签的对应关系';

-- ----------------------------
-- Records of blog_article_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_category`
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '分类名',
  `url` varchar(50) DEFAULT NULL COMMENT '分类链接',
  `status` tinyint(2) DEFAULT '0' COMMENT '分类状态 0：正常 1:已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_url` (`url`) COMMENT '分类链接唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of blog_category
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_comment`
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级评论,大于0时为评论回复',
  `user_agent` varchar(500) DEFAULT NULL COMMENT '评论者使用的浏览器',
  `user_ip` varchar(128) DEFAULT NULL COMMENT '评论者的ip地址',
  `user_email` varchar(255) DEFAULT NULL COMMENT '评论者的邮箱',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评论人',
  `user_nickname` varchar(50) DEFAULT NULL,
  `content` text NOT NULL COMMENT '评论内容',
  `reply_user_id` bigint(20) DEFAULT NULL COMMENT '回复的人',
  `reply_user_nickname` varchar(50) DEFAULT NULL,
  `target_type` int(11) DEFAULT NULL COMMENT '目标类型 1：文章 2：评论 3:留言',
  `article_id` bigint(20) DEFAULT NULL COMMENT '评论的文章',
  `create_time` datetime NOT NULL COMMENT '评论时间',
  `status` tinyint(2) DEFAULT '1' COMMENT '评论状态 0：待审核 1：已发布 2：已删除',
  `user_avatar` varchar(255) DEFAULT NULL,
  `reply_user_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '标签名',
  `url` varchar(50) DEFAULT NULL COMMENT '标签链接',
  `status` tinyint(2) DEFAULT '0' COMMENT '标签状态 0：正常 1:已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_url` (`url`) COMMENT '分类链接唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_user`
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户类型 0:管理员 1:普通用户',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态 0：正常 1：禁用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of blog_user
-- ----------------------------
