-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 30 Avril 2016 à 12:29
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `mail`
--

-- --------------------------------------------------------

--
-- Structure de la table `mailmessage`
--

CREATE TABLE IF NOT EXISTS `mailmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromp` varchar(20) NOT NULL,
  `Top` varchar(20) NOT NULL,
  `messagep` text NOT NULL,
  `isnew` varchar(20) NOT NULL,
  `priority` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Contenu de la table `mailmessage`
--

INSERT INTO `mailmessage` (`id`, `fromp`, `Top`, `messagep`, `isnew`, `priority`) VALUES
(2, 'amar', 'amir', 'salut', 'true', 'SPAM'),
(9, 'amar', 'amar', 'testtest', 'true', 'Normal'),
(10, 'amar', 'amar', 'sall,jiajqucqcqf', 'true', 'Haute'),
(11, 'amar', 'amar', 'ahla', 'true', 'Normal'),
(15, 'client1', 'clinent', 'hb', 'true', 'Normal'),
(16, 'client1', 'client1', 'ZFEQZFZW', 'true', 'Normal'),
(17, 'client2', 'client2', 'huhuhs', 'true', 'Haute'),
(18, 'client2', 'client1', 'jhana', 'true', 'Normal'),
(19, 'client2', 'client1', 'hello there', 'true', 'Normal'),
(20, 'client2', 'client1', 'hhhhhhhhhhh', 'true', 'Normal'),
(21, 'client2', 'client1', 'salut', 'true', 'Normal');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
