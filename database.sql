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

-- 테이블 velog-aiden.email_token_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `email_token_mst` (
  `id` varchar(100) NOT NULL,
  `expiration_date` datetime NOT NULL,
  `expired` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog-aiden.email_token_mst:~12 rows (대략적) 내보내기
DELETE FROM `email_token_mst`;
/*!40000 ALTER TABLE `email_token_mst` DISABLE KEYS */;
INSERT INTO `email_token_mst` (`id`, `expiration_date`, `expired`, `email`, `create_date`, `update_date`) VALUES
	('07acf93177cf4e6f937c0f9a703c6534', '2021-11-25 19:54:58', 0, 'liberty0212@naver.com', '2021-11-25 19:49:58', '2021-11-25 19:49:58'),
	('25734c79a0e944abb22792c1284ec30a', '2021-11-25 19:50:10', 0, 'liberty0212@naver.com', '2021-11-25 19:45:10', '2021-11-25 19:45:10'),
	('293bf4f67cbc4800ae828cc56cc0809b', '2021-11-25 20:07:35', 0, 'liberty0212@naver.com', '2021-11-25 20:02:35', '2021-11-25 20:02:35'),
	('60a376a528d44e03ab3052e00b874a0b', '2021-11-25 20:43:47', 0, 'liberty0212@naver.com', '2021-11-25 20:38:47', '2021-11-25 20:38:47'),
	('75959d6fb5ea4bb79cc578b9d42d2eb5', '2021-11-25 20:47:41', 0, 'liberty0212@naver.com', '2021-11-25 20:42:41', '2021-11-25 20:42:41'),
	('8431bba2b4e94ee59602f2f400b9f427', '2021-11-25 20:52:28', 0, 'liberty0212@naver.com', '2021-11-25 20:47:28', '2021-11-25 20:47:28'),
	('867a3d4507df45eb88c60ef94c843e50', '2021-11-25 19:48:32', 0, 'liberty0212@naver.com', '2021-11-25 19:43:32', '2021-11-25 19:43:32'),
	('8a08514dbffd4aa28bb3576283ece973', '2021-11-25 20:49:19', 0, 'liberty0212@naver.com', '2021-11-25 20:44:19', '2021-11-25 20:44:19'),
	('9544bc203a5e411eabd5562d16f94730', '2021-11-25 20:50:01', 0, 'liberty0212@naver.com', '2021-11-25 20:45:01', '2021-11-25 20:45:01'),
	('b6abc253d2b64c69b980f2ba85fcb7ba', '2021-11-25 20:03:15', 0, 'liberty0212@naver.com', '2021-11-25 19:58:15', '2021-11-25 19:58:15'),
	('d5f3f42b95c84bd780a2ed8acbf45a72', '2021-11-25 20:56:49', 0, 'liberty0212@naver.com', '2021-11-25 20:51:49', '2021-11-25 20:51:49'),
	('f5425ff79a4f439ca7102a2872e387e2', '2021-11-25 20:46:07', 0, 'liberty0212@naver.com', '2021-11-25 20:41:07', '2021-11-25 20:41:07');
/*!40000 ALTER TABLE `email_token_mst` ENABLE KEYS */;

-- 테이블 velog-aiden.user_mst 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `name` varchar(10) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 velog-aiden.user_mst:~0 rows (대략적) 내보내기
DELETE FROM `user_mst`;
/*!40000 ALTER TABLE `user_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_mst` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
