-- --------------------------------------------------------
-- 호스트:                          dcrhg4kh56j13bnu.cbetxkdyhwsb.us-east-1.rds.amazonaws.com
-- 서버 버전:                        10.4.21-MariaDB-log - Source distribution
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 rc341mq9bm8s59xz.user_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_mst` (
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `name` varchar(10) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 rc341mq9bm8s59xz.user_mst:~6 rows (대략적) 내보내기
DELETE FROM `user_mst`;
/*!40000 ALTER TABLE `user_mst` DISABLE KEYS */;
INSERT INTO `user_mst` (`email`, `username`, `name`, `comment`, `password`, `create_date`, `update_date`) VALUES
	('asdasd12@naver.com', 'gyujin', '이규진', '눈칫밥10단', '12345', '2021-11-06', '2021-11-06'),
	('asdf1234@gmail.com', 'sangwoo', '정상우', '주니어', '1234', '2021-11-25', '2021-11-25'),
	('asdf123@gmail.com', 'mrjoo', '주단태', '악랄한사람', '12345', '2021-11-06', '2021-11-06'),
	('coqja123@gmail.com', 'coqja', '서채범', NULL, '1234', '2021-11-17', '2021-11-17'),
	('nanee0706@gmail.com', 'haa', '하나은', '안녕하세요', '1234', '2021-11-17', '2021-11-17'),
	('qwer123@gmail.com', 'cheon', '천서진', '돈많아', '1234', '2021-11-06', '2021-11-06'),
	('zxc123@naver.com', 'ohhhh', '오윤희', '천상의목소리', '1234', '2021-11-06', '2021-11-06');
/*!40000 ALTER TABLE `user_mst` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
