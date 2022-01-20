-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 16, 2021 at 04:18 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vaccinationapp_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vaccination_date` datetime(6) DEFAULT NULL,
  `national_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `vaccine_dose` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `name_vaccine` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `place_vaccine` varchar(255) DEFAULT NULL,
  `batch_number` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `vaccination_date`, `national_id`, `district`, `vaccine_dose`, `name`, `name_vaccine`, `department_id`, `sex`, `place_vaccine`, `batch_number`, `age`) VALUES
(20, '2021-09-10 00:00:00.000000', '7895872461v', 'Kurunagala', '1st_dose', 'Avishka Samod', 'Sinopharm', NULL, 'Male', 'Narammala', '7895872461', 22),
(21, '2021-08-25 00:00:00.000000', '200123654875', 'Puttalam', '1st_dose', 'Viraj Jayawardhana', 'Pfizer', NULL, 'Male', 'Anamaduwa', '2001236548', 20),
(22, '2021-09-08 00:00:00.000000', '1999365428', 'Puttalam', '2nd_dose', 'Tharindu NIrushan', 'AstraZeneca', NULL, 'Male', 'Chilaw', '1999365428', 23),
(23, '2021-07-30 00:00:00.000000', '1992543687', 'Gampaha', '1st_dose', 'Nirmali Perera', 'Sinopharm', NULL, 'Female', 'Ragama', '1992543687', 19),
(24, '2021-05-23 00:00:00.000000', '1968568752', 'Gampaha', '1st_dose', 'Dumidu Sheron', 'Pfizer', NULL, 'Male', 'Seeduwa', '1968568752', 25),
(25, '2021-08-27 00:00:00.000000', '1999563248', 'Kurunagala', '2nd_dose', 'Lahiru Jayawardhana', 'Sinopharm', NULL, 'Female', 'Kuliyapitiya', '1999563248', 27),
(26, '2021-07-24 00:00:00.000000', '1998578965', 'Gampaha', '2nd_dose', 'Lalitha Prathibha', 'Sinopharm', NULL, 'Male', 'Minuwangoda', '1998578965', 22),
(27, '2021-08-19 00:00:00.000000', '1998653874', 'Puttalam', '1st_dose', 'Rusiru Shashimal', 'Sinopharm', NULL, 'Male', 'Arachchikattuwa', '1998653874', 18);

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
CREATE TABLE IF NOT EXISTS `user_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`id`, `password`, `user_name`) VALUES
(1, 'abc123', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `vaccine`
--

DROP TABLE IF EXISTS `vaccine`;
CREATE TABLE IF NOT EXISTS `vaccine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `prices` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vaccine`
--

INSERT INTO `vaccine` (`id`, `name`, `quantity`, `prices`) VALUES
(28, 'Sinopharm', 50000, 320000),
(29, 'Pfizer–BioNTech', 35000, 250000),
(30, 'Oxford–AstraZeneca', 28000, 150000);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `district` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
