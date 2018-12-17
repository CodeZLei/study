/*
 Navicat Premium Data Transfer

 Source Server         : 本地库(127.0.0.1)
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 17/12/2018 18:41:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for da_around_community_price_info
-- ----------------------------
DROP TABLE IF EXISTS `da_around_community_price_info`;
CREATE TABLE `da_around_community_price_info`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `base_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小区编号',
  `com_name` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼盘名称',
  `cs_city_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市编号',
  `city_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `around_com_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '周边楼盘名称',
  `distance` double NULL DEFAULT NULL COMMENT '位置',
  `xlongitude` double NULL DEFAULT NULL COMMENT 'x坐标',
  `ylatitude` double NULL DEFAULT NULL COMMENT 'y坐标',
  `unit_price` double NULL DEFAULT NULL COMMENT '均价',
  `source_channel` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源渠道',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '周边小区均价信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for da_community_base_info
-- ----------------------------
DROP TABLE IF EXISTS `da_community_base_info`;
CREATE TABLE `da_community_base_info`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `com_name` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼盘名称',
  `cs_city_code` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市编号',
  `city_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `district_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域编号',
  `district_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `unit_price` double NULL DEFAULT NULL COMMENT '均价',
  `ratio_by_last_month_for_price` double NULL DEFAULT NULL COMMENT '上月价格浮动比例',
  `ratio_by_last_year_for_price` double NULL DEFAULT NULL COMMENT '上年价格浮动比例',
  `xlongitude` double NULL DEFAULT NULL COMMENT 'x坐标',
  `ylongitude` double NULL DEFAULT NULL COMMENT 'y坐标',
  `house_types` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房子类型',
  `school_district_housing` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
  `subway_district_housing` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地铁',
  `completion_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成shiji8an',
  `building_category` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `developer_company` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开发公司',
  `sell_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '售卖时间',
  `building_area` double NULL DEFAULT NULL COMMENT '时间',
  `land_area` double NULL DEFAULT NULL COMMENT '绿化',
  `land_use_years_limit` int(11) NULL DEFAULT NULL COMMENT '时间',
  `greening_rate` double NULL DEFAULT NULL COMMENT '比率',
  `management_company` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
  `management_fees` double NULL DEFAULT NULL COMMENT '物业',
  `parking_space_info` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园',
  `school` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
  `subway_line` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公家',
  `bus_line` varchar(11000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地铁',
  `source_channel` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据来源渠道',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '小区基本信息表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
