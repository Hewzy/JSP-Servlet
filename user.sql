/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 28/12/2018 09:19:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `id` int(5) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES ('中国', '中国好啊', 'he', '2018-12-22 09:10:09', 1);
INSERT INTO `discuss` VALUES ('中国', '祖国伟大', 'weizhi', '2018-12-22 09:10:18', 1);
INSERT INTO `discuss` VALUES ('联蔚科技', '在秦淮区', 'hwz', '2018-12-23 09:10:23', 2);
INSERT INTO `discuss` VALUES ('夏同学', '金科的', 'hwz', '2018-12-23 10:10:28', 3);
INSERT INTO `discuss` VALUES ('杨同学', '金科的啊', 'hewei', '2018-12-22 22:10:41', 4);
INSERT INTO `discuss` VALUES ('杨同学', '哈哈哈，我也是啊', 'he', '2018-12-21 11:10:50', 4);
INSERT INTO `discuss` VALUES ('杨同学', '有空一起吃饭啊', 'he', '2018-12-23 12:11:01', 4);
INSERT INTO `discuss` VALUES ('联蔚科技', '我在这家公司上班哦！', 'hwz', '2018-12-23 13:11:13', 2);
INSERT INTO `discuss` VALUES ('联蔚科技', '哈哈，我也在', 'he', '2018-12-22 14:11:19', 2);
INSERT INTO `discuss` VALUES ('中国', '我爱我的祖国！', 'he', '2018-12-22 15:11:25', 1);
INSERT INTO `discuss` VALUES ('中国', '显示现在中国的时间', 'he', '2018-12-24 09:32:59', 1);
INSERT INTO `discuss` VALUES ('中国', '是我自己写的', 'he', '2018-12-24 13:45:52', 1);
INSERT INTO `discuss` VALUES ('联蔚科技', '你们在哪里啊？', 'he', '2018-12-25 11:07:59', 2);
INSERT INTO `discuss` VALUES ('中国', '没有人嘛', 'he', '2018-12-25 11:25:03', 1);
INSERT INTO `discuss` VALUES ('中国', '哈哈哈', 'he', '2018-12-25 20:05:19', 1);
INSERT INTO `discuss` VALUES ('我的家乡', '欢迎大家来我的家乡哦！', 'he', '2018-12-25 20:10:12', 7);
INSERT INTO `discuss` VALUES ('联蔚科技', '你好啊', 'he', '2018-12-26 09:44:54', 2);
INSERT INTO `discuss` VALUES ('同事们', '是的啊', 'he', '2018-12-27 09:59:57', 9);
INSERT INTO `discuss` VALUES ('灌云县', '是我的家乡小镇', 'he', '2018-12-27 12:27:05', 18);
INSERT INTO `discuss` VALUES ('中国', '嗯嗯', 'he', '2018-12-27 13:37:35', 1);
INSERT INTO `discuss` VALUES ('我的文章', '大家捧捧场哦！', 'hwz1', '2018-12-27 18:43:06', 19);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `lastTime` datetime(0) NULL DEFAULT NULL,
  `details` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`, `title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('he', '中国', '2018-12-27 13:37:52.222', '我的祖国', 1, '2018-12-27 13:37:35', '中华人民共和国！');
INSERT INTO `message` VALUES ('hwz', '联蔚科技', '2018-12-24 14:05:14.092', '这是备注', 2, '2018-12-26 09:44:54', '上海联蔚信息科技有限公司于2000年11月20日成立。法定代表人胡剑凡,公司经营范围包括：计算机软件的设计、开发；网络软件应用服务及相关的信息技术咨询服务；计算机系统集成的设计、安装、调试和维护；数据处理业务及相关服务；计算机应用软件、电脑及外围设备、服务器、路由器、打印机、安全接入设备、通讯设备和上述装备的配套器材、以及办公用品和文具、日用品、数码产品和小家电的批发；佣金代理（拍卖除外）、进出口；提供相关配套服务（不涉及国营贸易管理商品、涉及配额、许可证管理商品的、按国家有关规定办理申请）等。enen');
INSERT INTO `message` VALUES ('hwz', '夏同学', '2018-12-24 10:32:46.511', '备注', 3, '2018-12-23 10:10:28', '金陵科技学院');
INSERT INTO `message` VALUES ('hwz', '杨同学', '2018-12-24 10:32:46.511', '备注2', 4, '2018-12-23 12:11:01', '金陵科技学院的学生啊');
INSERT INTO `message` VALUES ('he', '我的家乡', '2018-12-27 20:20:39.461', '连云港', 7, '2018-12-25 20:10:12', '连云港，江苏省下辖地级市，古称“海州”，海域6677平方公里。因面向连岛、背倚云台山，又因海港，得名连云港。位于中国沿海中部，东濒黄海，属温带季风气候，东部与朝鲜、韩国、日本隔海相望，西与徐州市、宿迁市相连，南部与淮安市和盐城市毗邻，北至西北与山东省日照市、临沂市相邻，下辖3个区。');
INSERT INTO `message` VALUES ('he', '灌云县', '2018-12-27 12:26:54.609', '我的小镇', 18, '2018-12-27 12:27:05', '隶属于江苏省连云港市，位于江苏省东北部，连云港市与宿迁市之间，东部濒临黄海，与韩国、日本等地区相望；西与沭阳县为邻；南隔新沂河与灌南县相连；北与连云港市区、东海县交界。介于东经119°2′50″—119°52′9″，北纬34°11′45″—34°38′50″之间，东西最大直线距离73千米');
INSERT INTO `message` VALUES ('hwz1', '我的文章', '2018-12-27 18:42:53.234', 'hwz1', 19, '2018-12-27 18:43:06', '这是额第一次用hwz1发表文章');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES (1, '查看');
INSERT INTO `power` VALUES (2, '删除');
INSERT INTO `power` VALUES (3, '修改');
INSERT INTO `power` VALUES (4, '管人');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '普通');
INSERT INTO `role` VALUES (2, '管理');
INSERT INTO `role` VALUES (3, '超管');
INSERT INTO `role` VALUES (23, '汉语');
INSERT INTO `role` VALUES (27, '会不会');
INSERT INTO `role` VALUES (28, '教师');
INSERT INTO `role` VALUES (29, '嗯嗯');

-- ----------------------------
-- Table structure for role_power
-- ----------------------------
DROP TABLE IF EXISTS `role_power`;
CREATE TABLE `role_power`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `power_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_power
-- ----------------------------
INSERT INTO `role_power` VALUES (1, 23, 2);
INSERT INTO `role_power` VALUES (2, 2, 2);
INSERT INTO `role_power` VALUES (3, 3, 4);
INSERT INTO `role_power` VALUES (4, 23, 3);
INSERT INTO `role_power` VALUES (19, 29, 1);
INSERT INTO `role_power` VALUES (20, 27, 1);
INSERT INTO `role_power` VALUES (21, 27, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'he', '18852076991', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (3, 'hewei', '12312312312', '4297f44b13955235245b2497399d7a93');
INSERT INTO `user` VALUES (4, 'her', '12312312312', '4297f44b13955235245b2497399d7a93');
INSERT INTO `user` VALUES (5, 'kuaishou', '12312312312', 'efe6398127928f1b2e9ef3207fb82663');
INSERT INTO `user` VALUES (6, 'kuai', '12312312312', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (7, 'hui', '12345678901', 'b274ffdfd8f0f12bbee1f6abd442e20f');
INSERT INTO `user` VALUES (8, 'hwz1', '12345678901', 'b274ffdfd8f0f12bbee1f6abd442e20f');
INSERT INTO `user` VALUES (30, 'hwz', '12312312312', '6590f73ecdf351c38de00befd2ecf17b');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) NULL DEFAULT NULL,
  `role_id` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 3);
INSERT INTO `user_role` VALUES (2, 3, 23);
INSERT INTO `user_role` VALUES (3, 4, 27);
INSERT INTO `user_role` VALUES (4, 5, 23);
INSERT INTO `user_role` VALUES (5, 6, 1);
INSERT INTO `user_role` VALUES (6, 7, 1);
INSERT INTO `user_role` VALUES (7, 8, 23);
INSERT INTO `user_role` VALUES (8, 30, 2);

SET FOREIGN_KEY_CHECKS = 1;
