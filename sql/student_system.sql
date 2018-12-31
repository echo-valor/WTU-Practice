/*
Navicat MySQL Data Transfer

Source Server         : newlinfeng
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : student_system

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-12-28 13:44:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(20) NOT NULL,
  `sname` varchar(10) NOT NULL,
  `ssex` varchar(10) NOT NULL,
  `sbirthday` varchar(20) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  `sprovince` varchar(20) NOT NULL,
  `shobby` varchar(100) NOT NULL,
  `sphone` varchar(20) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1604241020', 'newlinfeng', '男', '1998-05-21', '黑龙江省', '足球，篮球，羽毛球，游泳，拍照，打游戏', '15925856547');
INSERT INTO `student` VALUES ('1604241021', 'liming', '男', '1999-09-08', '辽宁省', '足球，篮球', '15965845721');
INSERT INTO `student` VALUES ('1604241022', 'wangwu', '女', '2001-07-15', '辽宁省', '足球，篮球，羽毛球，游泳，唱歌', '15965845548');
INSERT INTO `student` VALUES ('1604241029', 'whn', '男', '2001-02-01辽宁省', '篮球', '14274856932', '15486570235');
INSERT INTO `student` VALUES ('1604241065', 'liming', '男', '1999-09-08', '辽宁省', '足球，篮球', '15965845721');
INSERT INTO `student` VALUES ('1604245238', '李林峰', '男', '1985-09-23', '吉林省', '足球，篮球，乒乓球，看电影', '15682354897');
INSERT INTO `student` VALUES ('1834223456', '赤犬', 'm', '2000-06-04', '河北省', '健身', '15432555678');
INSERT INTO `student` VALUES ('1936542345', '甚平', 'm', '1999-09-04', '安徽省', '空手道', '15609095678');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userName` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'e10adc3949ba59abbe56e057f20f883e');
