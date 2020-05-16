
-- ----------------------------
-- Table structure for `t_b_user`
-- ----------------------------

DROP TABLE IF EXISTS `t_b_user`;
CREATE TABLE `t_b_user` (
  `id` int(36) NOT NULL,
 `userName` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
 `permission` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for `t_b_dorm`
-- ----------------------------
DROP TABLE IF EXISTS `t_b_dorm`;
CREATE TABLE `t_b_dorm` (
  `D_id` int(36) PRIMARY KEY,
  `total` int(11) DEFAULT NULL,
  `used` int(11) DEFAULT NULL,
  `dormadmin` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_b_damage`
-- ----------------------------
DROP TABLE IF EXISTS `t_b_damage`;
CREATE TABLE `t_b_damage` (
  `Da_id` int(36) PRIMARY KEY,
  `damagestation` varchar(200) DEFAULT NULL,
  `damagetime` date DEFAULT NULL,
  `isfixed` varchar(1) DEFAULT NULL,
  `dormid` int(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_b_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_b_student`;
CREATE TABLE `t_b_student` (
  `S_id` int(36) PRIMARY KEY,
  `S_name` varchar(20) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `mobile` varchar(13) DEFAULT NULL,
  `dormid` int(36) NOT NULL,
  CONSTRAINT  FOREIGN KEY (`dormid`) REFERENCES `t_s_dorm` (`D_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_b_visitor`
-- ----------------------------
DROP TABLE IF EXISTS `t_b_visitor`;
CREATE TABLE `t_b_visitor` (
  `id` int(36) NOT NULL,
  `visitorname` varchar(10) NOT NULL,
  `studentid` int(36) NOT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`visitorname`,`studentid`),
  CONSTRAINT `fk_t_b_visitor_t_b_student1` FOREIGN KEY (`studentid`) REFERENCES `t_s_student` (`S_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_b_V`
-- ----------------------------
DROP TABLE IF EXISTS `t_b_v`;
CREATE TABLE `t_b_v` (
  `S_id` int(36) NOT NULL,
  `a_id` int(36) NOT NULL,
  `id` int(36) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`S_id`,`a_id`,`id`),
  CONSTRAINT  FOREIGN KEY (`S_id`) REFERENCES `t_s_student` (`S_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT  FOREIGN KEY (`id`) REFERENCES `t_s_visitor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_b_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_b_score`;
CREATE TABLE `t_b_score` (
  `id` varchar (36) PRIMARY KEY,
  `score` int(11) NOT NULL,
  `dormid` int(36) NOT NULL,
  KEY `fk_t_b_score_t_b_dorm1` (`dormid`),
  CONSTRAINT `fk_t_b_score_t_b_dorm1` FOREIGN KEY (`dormid`) REFERENCES `t_s_dorm` (`D_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 触发器
-- ----------------------------
CREATE TRIGGER age_trigger BEFORE INSERT ON t_b_user FOR EACH ROW
BEGIN
IF(new.age<40)THEN
set new.age = 40;
END IF;
end;

-- ----------------------------
-- Table structure for `t_b_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_log`;
CREATE TABLE `t_s_log` (
  `id` varchar (36) PRIMARY KEY,
  `username` varchar (36) NOT NULL,
  `visitTime` timestamp NOT NULL,
  `method` varchar (36) NOT NULL,
  `executionTime` int (11) NOT NULL,
  `ip` varchar (36) NOT NULL,
  `url` varchar (36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
