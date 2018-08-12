-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2016 at 06:54 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `categoryId` int(100) NOT NULL,
  `categoryName` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`categoryId`, `categoryName`) VALUES
(1, 'cloth'),
(2, 'fruit'),
(3, 'cosmetic'),
(4, 'fish');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `customerId` int(100) NOT NULL,
  `customerName` varchar(100) NOT NULL,
  `customerPhone` varchar(100) NOT NULL,
  `customerAddress` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerId`, `customerName`, `customerPhone`, `customerAddress`) VALUES
(1, 'customer1', '1404088508508', 'address1'),
(2, 'customer2', '0065654654144', 'address2');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
  `EmployeeId` int(100) NOT NULL,
  `EmployeeUsername` varchar(100) NOT NULL,
  `EmployeePassword` varchar(100) NOT NULL,
  `EmployeeName` varchar(100) NOT NULL,
  `EmployeePosition` varchar(100) NOT NULL,
  `EmployeeSalary` varchar(100) NOT NULL,
  `EmployeePhone` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EmployeeId`, `EmployeeUsername`, `EmployeePassword`, `EmployeeName`, `EmployeePosition`, `EmployeeSalary`, `EmployeePhone`) VALUES
(1, 'stock1', 's1', 'stockmanager1', 'Stock Manager', '20000', '0155200554'),
(3, 'admin', 'admin', 'admin', 'admin', '100000', '456859623'),
(4, 'saler1', 'sa1', 'saler1', 'saler', '10000', '00120242042');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `productId` int(100) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `productPrice` varchar(100) NOT NULL,
  `productQuantity` int(100) NOT NULL,
  `categoryId` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productId`, `ProductName`, `productPrice`, `productQuantity`, `categoryId`) VALUES
(3, 'Fair & lovly', '150', 8, 3),
(4, 'shaari', '2250', 15, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `saleId` int(100) NOT NULL,
  `productId` int(100) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `saleCost` varchar(100) NOT NULL,
  `saleQuantity` varchar(100) NOT NULL,
  `saleDate` varchar(100) NOT NULL,
  `customerId` int(100) NOT NULL,
  `EmployeeId` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`saleId`, `productId`, `productName`, `saleCost`, `saleQuantity`, `saleDate`, `customerId`, `EmployeeId`) VALUES
(3, 4, 'shaari', '11250', '5', '2016-08-26', 2, 4),
(4, 3, 'Fair & lovly', '750', '5', '2016-08-27', 1, 4),
(5, 3, 'Fair & lovly', '150', '1', '2016-08-27', 1, 4),
(6, 3, 'Fair & lovly', '150', '1', '2016-08-29', 1, 4),
(8, 8, 'shirt', '440', '2', '2016-08-28', 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `stockId` int(100) NOT NULL,
  `productId` int(100) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `stockQuantity` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stockId`, `productId`, `productName`, `stockQuantity`) VALUES
(1, 3, 'fair & lovly', 8),
(2, 4, 'shaari', 15);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userId` int(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `userPassword` varchar(100) NOT NULL,
  `EmployeeId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`EmployeeId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`saleId`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stockId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `categoryId` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customerId` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `EmployeeId` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productId` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `saleId` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stockId` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(100) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
