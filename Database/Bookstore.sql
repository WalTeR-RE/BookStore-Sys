/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50521
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50521
 File Encoding         : 65001

 Date: 27/12/2023 03:59:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `AccountId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `Created` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OTP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ResetCounter` int(11) NULL DEFAULT 0,
  `WrongResetCounter` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`AccountId`, `username`, `Email`) USING BTREE,
  INDEX `AccountId`(`AccountId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 'Osama', '1a658a02dbe42ddbf35ab40e885a5806', 'asamaaly70@gmail.com', 'User', 1, '03-12-2023', '', 0, 0);

-- ----------------------------
-- Table structure for banrecord
-- ----------------------------
DROP TABLE IF EXISTS `banrecord`;
CREATE TABLE `banrecord`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Banner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BannerUUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Reason` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BanType` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `UUID`(`UUID`) USING BTREE,
  INDEX `BannerUUID`(`BannerUUID`) USING BTREE,
  INDEX `Name`(`Name`) USING BTREE,
  INDEX `Banner`(`Banner`) USING BTREE,
  INDEX `banrecord_ibfk_5`(`BanType`) USING BTREE,
  CONSTRAINT `banrecord_ibfk_5` FOREIGN KEY (`BanType`) REFERENCES `bantypes` (`TypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `banrecord_ibfk_1` FOREIGN KEY (`UUID`) REFERENCES `usersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `banrecord_ibfk_2` FOREIGN KEY (`BannerUUID`) REFERENCES `usersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `banrecord_ibfk_3` FOREIGN KEY (`Name`) REFERENCES `usersrecord` (`Name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `banrecord_ibfk_4` FOREIGN KEY (`Banner`) REFERENCES `usersrecord` (`Name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of banrecord
-- ----------------------------
INSERT INTO `banrecord` VALUES (4, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'Osama', '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'TestFunction', 105);
INSERT INTO `banrecord` VALUES (5, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'Osama', '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'TestFunction', 105);
INSERT INTO `banrecord` VALUES (6, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'Osama', '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'TestFunction', 100);
INSERT INTO `banrecord` VALUES (7, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'Osama', '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'TestFunction', 100);
INSERT INTO `banrecord` VALUES (8, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'Osama', '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'TestFunction', 105);

-- ----------------------------
-- Table structure for bantypes
-- ----------------------------
DROP TABLE IF EXISTS `bantypes`;
CREATE TABLE `bantypes`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TypeId` int(11) NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `TypeId`(`TypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bantypes
-- ----------------------------
INSERT INTO `bantypes` VALUES (1, 100, 'BanAccount');
INSERT INTO `bantypes` VALUES (2, 105, 'BanChat');

-- ----------------------------
-- Table structure for bookscategories
-- ----------------------------
DROP TABLE IF EXISTS `bookscategories`;
CREATE TABLE `bookscategories`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bookscategories
-- ----------------------------
INSERT INTO `bookscategories` VALUES (1, 'Action');
INSERT INTO `bookscategories` VALUES (2, 'Anime');
INSERT INTO `bookscategories` VALUES (3, 'Comedy');
INSERT INTO `bookscategories` VALUES (4, 'Drama');
INSERT INTO `bookscategories` VALUES (5, 'Slice Of Life');
INSERT INTO `bookscategories` VALUES (6, 'Horror');
INSERT INTO `bookscategories` VALUES (7, 'Mystery');
INSERT INTO `bookscategories` VALUES (8, 'Science fiction');
INSERT INTO `bookscategories` VALUES (9, 'Adventure');
INSERT INTO `bookscategories` VALUES (10, 'Fantasy');
INSERT INTO `bookscategories` VALUES (11, 'Historical');
INSERT INTO `bookscategories` VALUES (12, 'Romance');

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs`  (
  `Id` int(11) NOT NULL,
  `UUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Logtype` int(11) NULL DEFAULT NULL,
  `LogContent` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `log_key`(`UUID`, `Name`) USING BTREE,
  INDEX `log_key2`(`Logtype`) USING BTREE,
  CONSTRAINT `log_key2` FOREIGN KEY (`Logtype`) REFERENCES `logstypes` (`LogType`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `log_key` FOREIGN KEY (`UUID`, `Name`) REFERENCES `usersrecord` (`uuid`, `Name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for logstypes
-- ----------------------------
DROP TABLE IF EXISTS `logstypes`;
CREATE TABLE `logstypes`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LogType` int(11) NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `LogType`(`LogType`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of logstypes
-- ----------------------------
INSERT INTO `logstypes` VALUES (1, 505, 'SYSTEM_DB_ERROR');
INSERT INTO `logstypes` VALUES (2, 117, 'Chat_Log');
INSERT INTO `logstypes` VALUES (3, 110, 'Admin Feature');
INSERT INTO `logstypes` VALUES (4, 105, 'Manager Feature');
INSERT INTO `logstypes` VALUES (5, 102, 'New Order');
INSERT INTO `logstypes` VALUES (6, 111, 'Reviews');
INSERT INTO `logstypes` VALUES (7, 118, 'Edit Review');
INSERT INTO `logstypes` VALUES (8, 120, 'Vouchers');
INSERT INTO `logstypes` VALUES (9, 1, 'Register');
INSERT INTO `logstypes` VALUES (10, 2, 'Login');
INSERT INTO `logstypes` VALUES (11, 3, 'Forgot Password');
INSERT INTO `logstypes` VALUES (12, 500, 'System_ERROR');
INSERT INTO `logstypes` VALUES (13, 404, 'Files Not Found Errors');

-- ----------------------------
-- Table structure for messagerecord
-- ----------------------------
DROP TABLE IF EXISTS `messagerecord`;
CREATE TABLE `messagerecord`  (
  `Id` int(11) NOT NULL,
  `SenderUUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SenderName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `SenderUUID`(`SenderUUID`) USING BTREE,
  INDEX `messagerecord_ibfk_2`(`SenderName`) USING BTREE,
  CONSTRAINT `messagerecord_ibfk_2` FOREIGN KEY (`SenderName`) REFERENCES `usersrecord` (`Name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `messagerecord_ibfk_1` FOREIGN KEY (`SenderUUID`) REFERENCES `usersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ordershistory
-- ----------------------------
DROP TABLE IF EXISTS `ordershistory`;
CREATE TABLE `ordershistory`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TotalCash` int(11) NULL DEFAULT NULL,
  `Date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `date_key`(`Date`) USING BTREE,
  INDEX `uuid_key`(`uuid`) USING BTREE,
  CONSTRAINT `uuid_key` FOREIGN KEY (`uuid`) REFERENCES `ordersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `date_key` FOREIGN KEY (`Date`) REFERENCES `ordersrecord` (`Date`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ordershistory
-- ----------------------------
INSERT INTO `ordershistory` VALUES (1, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 12000, '2022');
INSERT INTO `ordershistory` VALUES (2, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 9000, '2023');
INSERT INTO `ordershistory` VALUES (3, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 1300, '26-12-2023');
INSERT INTO `ordershistory` VALUES (4, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 6090, '27-12-2023');

-- ----------------------------
-- Table structure for ordersrecord
-- ----------------------------
DROP TABLE IF EXISTS `ordersrecord`;
CREATE TABLE `ordersrecord`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Phonenumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Address` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Quantity` int(11) NULL DEFAULT NULL,
  `BookId` int(11) NOT NULL,
  `Date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE,
  INDEX `name`(`Name`) USING BTREE,
  INDEX `Pnum`(`Phonenumber`) USING BTREE,
  INDEX `BookId`(`BookId`) USING BTREE,
  INDEX `Date`(`Date`) USING BTREE,
  CONSTRAINT `BookId` FOREIGN KEY (`BookId`) REFERENCES `sysbooksrecord` (`BookId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `name` FOREIGN KEY (`Name`) REFERENCES `usersrecord` (`Name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Pnum` FOREIGN KEY (`Phonenumber`) REFERENCES `usersrecord` (`Phonenumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `uuid` FOREIGN KEY (`uuid`) REFERENCES `usersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ordersrecord
-- ----------------------------
INSERT INTO `ordersrecord` VALUES (2, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '2412412', 'asfasfda', 10, 3, '2022');
INSERT INTO `ordersrecord` VALUES (3, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '2412412', 'asfasfda', 10, 3, '2023');
INSERT INTO `ordersrecord` VALUES (4, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (5, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (6, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (7, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (8, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (9, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (10, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '26-12-2023');
INSERT INTO `ordersrecord` VALUES (11, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (12, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (13, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (14, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (15, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (16, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (17, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (18, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (19, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (20, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (21, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (22, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (23, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (24, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (25, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (26, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (27, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (28, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (29, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (30, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (31, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (32, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (33, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (34, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (35, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');
INSERT INTO `ordersrecord` VALUES (36, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '01007985244', '67 halima', 'Egypt', 3, 7, '27-12-2023');

-- ----------------------------
-- Table structure for reviewsrecord
-- ----------------------------
DROP TABLE IF EXISTS `reviewsrecord`;
CREATE TABLE `reviewsrecord`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Revname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Revuuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BookId` int(11) NULL DEFAULT NULL,
  `Stars` tinyint(1) NULL DEFAULT NULL,
  `Description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `review_record_key`(`BookId`) USING BTREE,
  INDEX `review_record_key2`(`Revuuid`) USING BTREE,
  INDEX `review_record_key3`(`Revname`) USING BTREE,
  CONSTRAINT `review_record_key3` FOREIGN KEY (`Revname`) REFERENCES `usersrecord` (`Name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `review_record_key` FOREIGN KEY (`BookId`) REFERENCES `sysbooksrecord` (`BookId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `review_record_key2` FOREIGN KEY (`Revuuid`) REFERENCES `usersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sysbooksrecord
-- ----------------------------
DROP TABLE IF EXISTS `sysbooksrecord`;
CREATE TABLE `sysbooksrecord`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BookId` int(11) NOT NULL,
  `Author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `Description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CoverImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Price` int(11) NULL DEFAULT NULL,
  `Quantity` int(11) NULL DEFAULT NULL,
  `AvgRev` float NOT NULL,
  PRIMARY KEY (`Id`, `BookId`) USING BTREE,
  INDEX `Category`(`Category`) USING BTREE,
  INDEX `BookId`(`BookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sysbooksrecord
-- ----------------------------
INSERT INTO `sysbooksrecord` VALUES (2, 2, 'Osama2', 'Faker23232', 'Fantasy,Player', 'Hacker for the win is the way', 'please/hacke2r.png', 500, 34, 5);
INSERT INTO `sysbooksrecord` VALUES (3, 3, 'Osama3', '2452532532', 'Action,Anime', 'Hacker for the win is the way', 'please/hacker3.png', 800, 12, 3.232);
INSERT INTO `sysbooksrecord` VALUES (6, 6, 'HeckTheWorld', 'Life Is Shit', 'Hack, Drama, Queen, Slice of Life', 'Here we go', 'Path/Imag.png', 100, 3, 3.3);
INSERT INTO `sysbooksrecord` VALUES (7, 7, 'HeckTheWorld', 'Life Is Shit', 'Hack, Drama, Queen, Slice of Life', 'Here we go', 'Path/Imag.png', 100, 3, 3.3);

-- ----------------------------
-- Table structure for ticketsrecord
-- ----------------------------
DROP TABLE IF EXISTS `ticketsrecord`;
CREATE TABLE `ticketsrecord`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TicketId` int(11) NOT NULL,
  `UUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`, `TicketId`) USING BTREE,
  INDEX `ticket_record_key`(`UUID`) USING BTREE,
  INDEX `ticket_record_key2`(`Name`) USING BTREE,
  CONSTRAINT `ticket_record_key2` FOREIGN KEY (`Name`) REFERENCES `usersrecord` (`Name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ticket_record_key` FOREIGN KEY (`UUID`) REFERENCES `usersrecord` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ticketsrecord
-- ----------------------------
INSERT INTO `ticketsrecord` VALUES (1, 180079, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'TESTER IS HER E FOR REAL', 'TESTER IS HER E FOR REAL', 'NEW', '27-12-2023');
INSERT INTO `ticketsrecord` VALUES (2, 168202, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'TESTER IS HER E FOR REAL', 'TESTER IS HER E FOR REAL', 'NEW', '27-12-2023');
INSERT INTO `ticketsrecord` VALUES (3, 130413, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 'TESTER IS HER E FOR REAL', 'TESTER IS HER E FOR REAL', 'NEW', '27-12-2023');

-- ----------------------------
-- Table structure for usersrecord
-- ----------------------------
DROP TABLE IF EXISTS `usersrecord`;
CREATE TABLE `usersrecord`  (
  `AccountId` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Age` int(11) NULL DEFAULT NULL,
  `Gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Phonenumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SecurityQues` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SecurityQuesAns` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Points` int(11) NULL DEFAULT NULL,
  `Online` tinyint(1) NULL DEFAULT NULL,
  `ChatIsBanned` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`AccountId`, `uuid`, `Name`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE,
  INDEX `Name`(`Name`) USING BTREE,
  INDEX `Phonenumber`(`Phonenumber`) USING BTREE,
  INDEX `uuid_2`(`uuid`, `Name`) USING BTREE,
  CONSTRAINT `account id` FOREIGN KEY (`AccountId`) REFERENCES `accounts` (`AccountId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usersrecord
-- ----------------------------
INSERT INTO `usersrecord` VALUES (1, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', 20, 'Male', '01007985244', 'What is your favorite color?', 'Cyan', 510, 1, 0);

-- ----------------------------
-- Table structure for vouchers
-- ----------------------------
DROP TABLE IF EXISTS `vouchers`;
CREATE TABLE `vouchers`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `voucherid` int(11) NULL DEFAULT NULL,
  `voucher` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `counter` int(11) NULL DEFAULT NULL,
  `expiredate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DiscountPercentage` int(11) NULL DEFAULT NULL,
  `UsedCount` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `voucherid`(`voucherid`, `voucher`(255)) USING BTREE,
  INDEX `voucherid_2`(`voucherid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vouchers
-- ----------------------------
INSERT INTO `vouchers` VALUES (1, 1, 'welcome', 5, '27-12-2023', 30, 2);

-- ----------------------------
-- Table structure for vouchersrecord
-- ----------------------------
DROP TABLE IF EXISTS `vouchersrecord`;
CREATE TABLE `vouchersrecord`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `voucherid` int(11) NULL DEFAULT NULL,
  `UUID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `vouchers_record_key`(`voucherid`) USING BTREE,
  INDEX `vouchers_record_key1`(`UUID`, `Name`) USING BTREE,
  CONSTRAINT `vouchers_record_key1` FOREIGN KEY (`UUID`, `Name`) REFERENCES `usersrecord` (`uuid`, `Name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vouchers_record_key` FOREIGN KEY (`voucherid`) REFERENCES `vouchers` (`voucherid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vouchersrecord
-- ----------------------------
INSERT INTO `vouchersrecord` VALUES (1, 1, '0bc5901d-d90e-3a94-a0be-648ced6a7ab2', 'Osama', '27-12-2023');

SET FOREIGN_KEY_CHECKS = 1;
