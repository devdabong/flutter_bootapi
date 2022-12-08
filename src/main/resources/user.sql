create database sample_db;

CREATE TABLE `tb_user` (
                           `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '아이디',
                           `USER_NAME` varchar(100) NOT NULL COMMENT '유저명',
                           `USER_EMAIL` varchar(100) NOT NULL COMMENT '이메일',
                           `USER_PASSWORD` text NOT NULL COMMENT '비밀번호',
                           PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='유저 테이블';