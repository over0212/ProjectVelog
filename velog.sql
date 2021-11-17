-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.6.4-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- velog 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `velog` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `velog`;

-- 테이블 velog.border_dtl 구조 내보내기
CREATE TABLE IF NOT EXISTS `border_dtl` (
  `border_code` int(11) NOT NULL,
  `border_content` varchar(1000) NOT NULL,
  `origin_file_names` varchar(1000) DEFAULT NULL,
  `temp_file_names` varchar(1000) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`border_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog.border_dtl:~0 rows (대략적) 내보내기
DELETE FROM `border_dtl`;
/*!40000 ALTER TABLE `border_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `border_dtl` ENABLE KEYS */;

-- 테이블 velog.border_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `border_mst` (
  `border_code` int(11) NOT NULL,
  `border_title` varchar(50) NOT NULL,
  `border_writer` varchar(50) NOT NULL,
  `border_date` date NOT NULL,
  `border_count` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`border_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog.border_mst:~0 rows (대략적) 내보내기
DELETE FROM `border_mst`;
/*!40000 ALTER TABLE `border_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `border_mst` ENABLE KEYS */;

-- 테이블 velog.notice_dtl 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice_dtl` (
  `notice_code` int(11) NOT NULL,
  `notice_content` varchar(50) NOT NULL,
  `origin_file_names` varchar(500) DEFAULT NULL,
  `temp_file_names` varchar(500) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`notice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog.notice_dtl:~0 rows (대략적) 내보내기
DELETE FROM `notice_dtl`;
/*!40000 ALTER TABLE `notice_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_dtl` ENABLE KEYS */;

-- 테이블 velog.notice_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice_mst` (
  `notice_code` int(11) NOT NULL,
  `notice_title` varchar(50) NOT NULL,
  `notice_writer` varchar(50) NOT NULL,
  `notice_date` date NOT NULL,
  `notice_count` int(11) NOT NULL DEFAULT 0,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`notice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog.notice_mst:~0 rows (대략적) 내보내기
DELETE FROM `notice_mst`;
/*!40000 ALTER TABLE `notice_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_mst` ENABLE KEYS */;

-- 테이블 velog.user_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_mst` (
  `user_email` varchar(100) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog.user_mst:~6 rows (대략적) 내보내기
DELETE FROM `user_mst`;
/*!40000 ALTER TABLE `user_mst` DISABLE KEYS */;
INSERT INTO `user_mst` (`user_email`, `user_pwd`, `user_name`, `user_id`, `comment`, `create_date`, `update_date`) VALUES
	('asdasd12@naver.com', '12345', '이규진', 'gyujin', '눈칫밥10단', '2021-11-06', '2021-11-06'),
	('asdf123@gmail.com', '12345', '주단태', 'mrjoo', '악랄한사람', '2021-11-06', '2021-11-06'),
	('coqja123@gmail.com', '1234', '서채범', 'coqja', NULL, '2021-11-17', '2021-11-17'),
	('nanee0706@gmail.com', '1234', '하나은', 'haa', '안녕하세요', '2021-11-17', '2021-11-17'),
	('qwer123@gmail.com', '1234', '천서진', 'cheon', '돈많아', '2021-11-06', '2021-11-06'),
	('zxc123@naver.com', '1234', '오윤희', 'ohhhh', '천상의목소리', '2021-11-06', '2021-11-06');
/*!40000 ALTER TABLE `user_mst` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
