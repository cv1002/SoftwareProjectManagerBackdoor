/*
 Navicat Premium Data Transfer

 Source Server         : 39.100.13.87
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : 39.100.13.87:3306
 Source Schema         : pmcore

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 03/01/2021 19:48:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Communication
-- ----------------------------
DROP TABLE IF EXISTS `Communication`;
CREATE TABLE `Communication`  (
  `CommunicationID` int(11) NOT NULL AUTO_INCREMENT,
  `Context` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `UserID` int(11) NOT NULL,
  `FileID` int(11) NULL DEFAULT NULL,
  `TeamID` int(11) NOT NULL,
  PRIMARY KEY (`CommunicationID`) USING BTREE,
  UNIQUE INDEX `XPKCommunication`(`CommunicationID`) USING BTREE,
  INDEX `R_21`(`UserID`) USING BTREE,
  INDEX `R_22`(`TeamID`) USING BTREE,
  CONSTRAINT `Communication_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for FileAssess
-- ----------------------------
DROP TABLE IF EXISTS `FileAssess`;
CREATE TABLE `FileAssess`  (
  `FileID` int(11) NOT NULL,
  `FileAssess` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `AssessorID` int(11) NULL DEFAULT NULL,
  `AssessTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`FileID`) USING BTREE,
  UNIQUE INDEX `XPKFileAssess`(`FileID`) USING BTREE,
  INDEX `R_35`(`AssessorID`) USING BTREE,
  CONSTRAINT `FileAssess_ibfk_1` FOREIGN KEY (`FileID`) REFERENCES `FileInfo` (`FileID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FileAssess_ibfk_2` FOREIGN KEY (`AssessorID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for FileContent
-- ----------------------------
DROP TABLE IF EXISTS `FileContent`;
CREATE TABLE `FileContent`  (
  `FileID` int(11) NOT NULL,
  `FileContent` longblob NULL,
  PRIMARY KEY (`FileID`) USING BTREE,
  UNIQUE INDEX `XPKFileContent`(`FileID`) USING BTREE,
  CONSTRAINT `FileContent_ibfk_1` FOREIGN KEY (`FileID`) REFERENCES `FileInfo` (`FileID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for FileInfo
-- ----------------------------
DROP TABLE IF EXISTS `FileInfo`;
CREATE TABLE `FileInfo`  (
  `FileID` int(11) NOT NULL AUTO_INCREMENT,
  `FileRealName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FileType` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FileLocation` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TeamID` int(11) NOT NULL,
  `StudentUserID` int(11) NOT NULL,
  `UploadTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`FileID`) USING BTREE,
  UNIQUE INDEX `XPKFiles`(`FileID`) USING BTREE,
  INDEX `R_16`(`TeamID`) USING BTREE,
  INDEX `R_17`(`StudentUserID`) USING BTREE,
  CONSTRAINT `FileInfo_ibfk_1` FOREIGN KEY (`TeamID`) REFERENCES `Team` (`TeamID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FileInfo_ibfk_2` FOREIGN KEY (`StudentUserID`) REFERENCES `Student` (`StudentUserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for GroupAssess
-- ----------------------------
DROP TABLE IF EXISTS `GroupAssess`;
CREATE TABLE `GroupAssess`  (
  `TeamID` int(11) NOT NULL,
  `Score` int(11) NULL DEFAULT NULL,
  `TeamAssess` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `AssessorID` int(11) NOT NULL,
  PRIMARY KEY (`TeamID`) USING BTREE,
  UNIQUE INDEX `XPKGroupAssess`(`TeamID`) USING BTREE,
  INDEX `R_42`(`AssessorID`) USING BTREE,
  CONSTRAINT `GroupAssess_ibfk_1` FOREIGN KEY (`TeamID`) REFERENCES `Team` (`TeamID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `GroupAssess_ibfk_2` FOREIGN KEY (`AssessorID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Milestone
-- ----------------------------
DROP TABLE IF EXISTS `Milestone`;
CREATE TABLE `Milestone`  (
  `MilestoneID` int(11) NOT NULL AUTO_INCREMENT,
  `MilestoneName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `MilestoneDescription` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MilestoneID`) USING BTREE,
  UNIQUE INDEX `XPKMilestone`(`MilestoneID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Object
-- ----------------------------
DROP TABLE IF EXISTS `Object`;
CREATE TABLE `Object`  (
  `ObjectName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ObjectName`) USING BTREE,
  UNIQUE INDEX `XPKObject`(`ObjectName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Operation
-- ----------------------------
DROP TABLE IF EXISTS `Operation`;
CREATE TABLE `Operation`  (
  `OperationDescription` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`OperationDescription`) USING BTREE,
  UNIQUE INDEX `XPKOperation`(`OperationDescription`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for PermissionConfig
-- ----------------------------
DROP TABLE IF EXISTS `PermissionConfig`;
CREATE TABLE `PermissionConfig`  (
  `ConfigID` int(11) NOT NULL AUTO_INCREMENT,
  `ObjectName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `OperationDescription` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ConfigID`) USING BTREE,
  UNIQUE INDEX `XPKPermissionConfig`(`ConfigID`) USING BTREE,
  INDEX `R_2`(`ObjectName`) USING BTREE,
  INDEX `R_3`(`OperationDescription`) USING BTREE,
  CONSTRAINT `PermissionConfig_ibfk_1` FOREIGN KEY (`ObjectName`) REFERENCES `Object` (`ObjectName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `PermissionConfig_ibfk_2` FOREIGN KEY (`OperationDescription`) REFERENCES `Operation` (`OperationDescription`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Project
-- ----------------------------
DROP TABLE IF EXISTS `Project`;
CREATE TABLE `Project`  (
  `ProjectID` int(11) NOT NULL AUTO_INCREMENT,
  `ProjectName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ProjectDescription` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ProjectID`) USING BTREE,
  UNIQUE INDEX `XPKProject`(`ProjectID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ProjectAssignment
-- ----------------------------
DROP TABLE IF EXISTS `ProjectAssignment`;
CREATE TABLE `ProjectAssignment`  (
  `ProjectID` int(11) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `ProjectStartTime` date NOT NULL,
  `ProjectDeadline` date NULL DEFAULT NULL,
  PRIMARY KEY (`TeamID`) USING BTREE,
  UNIQUE INDEX `XPKProjectAssignment`(`TeamID`) USING BTREE,
  INDEX `R_30`(`ProjectID`) USING BTREE,
  CONSTRAINT `ProjectAssignment_ibfk_1` FOREIGN KEY (`ProjectID`) REFERENCES `Project` (`ProjectID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ProjectAssignment_ibfk_2` FOREIGN KEY (`TeamID`) REFERENCES `Team` (`TeamID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ProjectCompletion
-- ----------------------------
DROP TABLE IF EXISTS `ProjectCompletion`;
CREATE TABLE `ProjectCompletion`  (
  `FileID` int(11) NOT NULL,
  `CompletionID` int(11) NOT NULL AUTO_INCREMENT,
  `TeamID` int(11) NOT NULL,
  `MilestoneID` int(11) NOT NULL,
  PRIMARY KEY (`CompletionID`) USING BTREE,
  UNIQUE INDEX `XPKProjectCompletion`(`CompletionID`) USING BTREE,
  INDEX `R_32`(`FileID`) USING BTREE,
  INDEX `R_33`(`TeamID`) USING BTREE,
  INDEX `R_34`(`MilestoneID`) USING BTREE,
  CONSTRAINT `ProjectCompletion_ibfk_1` FOREIGN KEY (`FileID`) REFERENCES `FileInfo` (`FileID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ProjectCompletion_ibfk_2` FOREIGN KEY (`TeamID`) REFERENCES `Team` (`TeamID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ProjectCompletion_ibfk_3` FOREIGN KEY (`MilestoneID`) REFERENCES `Milestone` (`MilestoneID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Role
-- ----------------------------
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role`  (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`RoleID`) USING BTREE,
  UNIQUE INDEX `XPKRole`(`RoleID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for RolePowerAssignment
-- ----------------------------
DROP TABLE IF EXISTS `RolePowerAssignment`;
CREATE TABLE `RolePowerAssignment`  (
  `AssignmentID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleID` int(11) NULL DEFAULT NULL,
  `ConfigID` int(11) NOT NULL,
  `Permission` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`AssignmentID`) USING BTREE,
  UNIQUE INDEX `XPKRolePowerAssignment`(`AssignmentID`) USING BTREE,
  INDEX `R_5`(`RoleID`) USING BTREE,
  INDEX `R_6`(`ConfigID`) USING BTREE,
  CONSTRAINT `RolePowerAssignment_ibfk_1` FOREIGN KEY (`RoleID`) REFERENCES `Role` (`RoleID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `RolePowerAssignment_ibfk_2` FOREIGN KEY (`ConfigID`) REFERENCES `PermissionConfig` (`ConfigID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 304 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`  (
  `StudentUserID` int(11) NOT NULL,
  `Class` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `StudentID` bigint(20) NULL DEFAULT NULL,
  `TeamID` int(11) NULL DEFAULT NULL,
  `Job` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`StudentUserID`) USING BTREE,
  UNIQUE INDEX `XPKStudent`(`StudentUserID`) USING BTREE,
  INDEX `R_13`(`TeamID`) USING BTREE,
  CONSTRAINT `Student_ibfk_1` FOREIGN KEY (`StudentUserID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Student_ibfk_2` FOREIGN KEY (`TeamID`) REFERENCES `Team` (`TeamID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for StudentAssess
-- ----------------------------
DROP TABLE IF EXISTS `StudentAssess`;
CREATE TABLE `StudentAssess`  (
  `Score` int(11) NULL DEFAULT NULL,
  `Assess` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `StudentUserID` int(11) NOT NULL,
  `AssessorID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`StudentUserID`) USING BTREE,
  UNIQUE INDEX `XPKStudentAssess`(`StudentUserID`) USING BTREE,
  INDEX `R_39`(`AssessorID`) USING BTREE,
  CONSTRAINT `StudentAssess_ibfk_1` FOREIGN KEY (`StudentUserID`) REFERENCES `Student` (`StudentUserID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `StudentAssess_ibfk_2` FOREIGN KEY (`AssessorID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Task
-- ----------------------------
DROP TABLE IF EXISTS `Task`;
CREATE TABLE `Task`  (
  `TaskID` int(11) NOT NULL AUTO_INCREMENT,
  `TaskName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TaskDeadline` date NULL DEFAULT NULL,
  `TaskHandlerID` int(11) NULL DEFAULT NULL,
  `TaskFinishType` int(11) NULL DEFAULT NULL,
  `TaskStartTime` date NULL DEFAULT NULL,
  `TaskPublisherID` int(11) NULL DEFAULT NULL,
  `TaskDescription` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`TaskID`) USING BTREE,
  UNIQUE INDEX `XPKTask`(`TaskID`) USING BTREE,
  INDEX `R_29`(`TaskPublisherID`) USING BTREE,
  CONSTRAINT `Task_ibfk_1` FOREIGN KEY (`TaskPublisherID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Team
-- ----------------------------
DROP TABLE IF EXISTS `Team`;
CREATE TABLE `Team`  (
  `TeamID` int(11) NOT NULL AUTO_INCREMENT,
  `TeamName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TeamDescription` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`TeamID`) USING BTREE,
  UNIQUE INDEX `XPKTeam`(`TeamID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for TodoList
-- ----------------------------
DROP TABLE IF EXISTS `TodoList`;
CREATE TABLE `TodoList`  (
  `TodoListID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NULL DEFAULT NULL,
  `TodoThings` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FinishState` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`TodoListID`) USING BTREE,
  UNIQUE INDEX `XPKTodoList`(`TodoListID`) USING BTREE,
  INDEX `R_40`(`UserID`) USING BTREE,
  CONSTRAINT `TodoList_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `UserPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `RoleID` int(11) NOT NULL,
  `Tel` bigint(20) NULL DEFAULT NULL,
  `EMail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `UserIconLocation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Sex` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`UserID`) USING BTREE,
  UNIQUE INDEX `XPKUser`(`UserID`) USING BTREE,
  INDEX `R_8`(`RoleID`) USING BTREE,
  CONSTRAINT `User_ibfk_1` FOREIGN KEY (`RoleID`) REFERENCES `Role` (`RoleID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
