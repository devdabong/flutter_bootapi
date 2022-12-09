create database sample_db;

CREATE TABLE `tb_user` (
                           `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '아이디',
                           `USER_NAME` varchar(100) NOT NULL COMMENT '유저명',
                           `USER_EMAIL` varchar(100) NOT NULL COMMENT '이메일',
                           `USER_PASSWORD` text NOT NULL COMMENT '비밀번호',
                           PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='유저 테이블';


CREATE FUNCTION sample_db.FN_CRYPTO(P_TYPE VARCHAR(3),
	P_VALUE VARCHAR(300)
) RETURNS varchar(300) CHARSET utf8mb4
    COMMENT '암복호화 함수'
BEGIN
	DECLARE R_VALUE VARCHAR(300);

	SET @KEY256 = sha2('dabong123!!', 256);

	IF P_TYPE = 'ENC' then
		SELECT HEX(AES_ENCRYPT(P_VALUE, @KEY256)) INTO R_VALUE;
	ELSEIF P_TYPE = 'DEC' then
		select AES_DECRYPT(UNHEX(P_VALUE), @KEY256) INTO R_VALUE;
	END IF;

	 RETURN R_VALUE;
END