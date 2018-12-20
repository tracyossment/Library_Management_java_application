-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 20, 2018 at 07:51 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Author` varchar(255) NOT NULL,
  `Quantity` int(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ID`, `Name`, `Author`, `Quantity`) VALUES
(3, 'The Invisible Man', 'HG wells', 6),
(12, 'Anna Karenina', 'Leo Tolstoy', 5),
(13, 'Middlemarch', 'George Eliot', 1),
(14, 'The Search of lost time', 'Marcel Proust', 0),
(15, 'War and Peace', 'Leo Tolstoy', 2),
(16, 'The Alchemist', 'Paulo Coehlo', 40),
(17, 'abc', 'aaaa', 11);

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE IF NOT EXISTS `issue` (
  `issueID` int(255) NOT NULL AUTO_INCREMENT,
  `studentID` int(255) NOT NULL,
  `bookID` int(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`issueID`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`issueID`, `studentID`, `bookID`, `date`) VALUES
(12, 45, 13, '2018-10-27 09:32:09'),
(13, 12, 13, '2018-10-27 09:33:00'),
(14, 3, 14, '2018-10-27 09:33:41'),
(15, 6, 14, '2018-10-27 09:33:53');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
CREATE TABLE IF NOT EXISTS `librarian` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `aadhar` int(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `aadhar` (`aadhar`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`ID`, `password`, `name`, `aadhar`) VALUES
(2, 'Anna', 'Anna', 1112),
(3, 'Bianca', 'Bianca', 1234),
(4, 'Susan', 'Susan', 456456),
(5, 'kelly', 'Kelly', 123);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `ID` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `password`) VALUES
('admin1', 'password1'),
('admin2', ''),
('admin3', ''),
('admin4', ''),
('admin5', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
