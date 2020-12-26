-- 此后是增加表
CREATE TABLE Communication
(
    CommunicationID INTEGER     NOT NULL,
    Context         VARCHAR(50) NULL,
    UserID          INTEGER     NOT NULL,
    FileID          INTEGER     NULL,
    TeamID          INTEGER     NOT NULL
);
CREATE UNIQUE INDEX XPKCommunication ON Communication (CommunicationID);
ALTER TABLE Communication
    ADD PRIMARY KEY (CommunicationID);
CREATE TABLE FileAssess
(
    FileID     INTEGER     NOT NULL,
    FileAssess VARCHAR(50) NULL,
    AssessorID INTEGER     NULL,
    AssessTime DATE        NULL
);
CREATE UNIQUE INDEX XPKFileAssess ON FileAssess (FileID);
ALTER TABLE FileAssess
    ADD PRIMARY KEY (FileID);
CREATE TABLE Files
(
    FileID        INTEGER      NOT NULL,
    FileRealName  VARCHAR(50)  NULL,
    FileType      VARCHAR(50)  NULL,
    FileLocation  VARCHAR(100) NULL,
    TeamID        INTEGER      NOT NULL,
    StudentUserID INTEGER      NOT NULL,
    UploadTime    DATE         NULL
);
CREATE UNIQUE INDEX XPKFiles ON Files (FileID);
ALTER TABLE Files
    ADD PRIMARY KEY (FileID);
CREATE TABLE GroupAssess
(
    TeamID     INTEGER      NOT NULL,
    Score      INTEGER      NULL,
    TeamAssess VARCHAR(100) NULL,
    AssessorID INTEGER      NOT NULL
);
CREATE UNIQUE INDEX XPKGroupAssess ON GroupAssess (TeamID);
ALTER TABLE GroupAssess
    ADD PRIMARY KEY (TeamID);
CREATE TABLE Milestone
(
    MilestoneID          INTEGER      NOT NULL,
    MilestoneName        VARCHAR(50)  NULL,
    MilestoneDescription VARCHAR(100) NULL
);
CREATE UNIQUE INDEX XPKMilestone ON Milestone (MilestoneID);
ALTER TABLE Milestone
    ADD PRIMARY KEY (MilestoneID);
CREATE TABLE Object
(
    ObjectName VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX XPKObject ON Object (ObjectName);
ALTER TABLE Object
    ADD PRIMARY KEY (ObjectName);
CREATE TABLE Operation
(
    OperationDescription VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX XPKOperation ON Operation (OperationDescription);
ALTER TABLE Operation
    ADD PRIMARY KEY (OperationDescription);
CREATE TABLE PermissionConfig
(
    ConfigID             INTEGER     NOT NULL,
    ObjectName           VARCHAR(50) NOT NULL,
    OperationDescription VARCHAR(50) NOT NULL,
    Permission           INTEGER     NULL
);
CREATE UNIQUE INDEX XPKPermissionConfig ON PermissionConfig (ConfigID);
ALTER TABLE PermissionConfig
    ADD PRIMARY KEY (ConfigID);
CREATE TABLE Project
(
    ProjectID          INTEGER      NOT NULL,
    ProjectName        VARCHAR(50)  NULL,
    ProjectDescription VARCHAR(100) NULL
);
CREATE UNIQUE INDEX XPKProject ON Project (ProjectID);
ALTER TABLE Project
    ADD PRIMARY KEY (ProjectID);
CREATE TABLE ProjectAssignment
(
    ProjectID        INTEGER NOT NULL,
    TeamID           INTEGER NOT NULL,
    ProjectStartTime DATE    NOT NULL,
    ProjectDeadline  DATE    NULL
);
CREATE UNIQUE INDEX XPKProjectAssignment ON ProjectAssignment (TeamID);
ALTER TABLE ProjectAssignment
    ADD PRIMARY KEY (TeamID);
CREATE TABLE ProjectCompletion
(
    FileID       INTEGER NOT NULL,
    CompletionID INTEGER NOT NULL,
    TeamID       INTEGER NOT NULL,
    MilestoneID  INTEGER NOT NULL
);
CREATE UNIQUE INDEX XPKProjectCompletion ON ProjectCompletion (CompletionID);
ALTER TABLE ProjectCompletion
    ADD PRIMARY KEY (CompletionID);
CREATE TABLE Role
(
    RoleID   INTEGER     NOT NULL,
    RoleName VARCHAR(50) NULL
);
CREATE UNIQUE INDEX XPKRole ON Role (RoleID);
ALTER TABLE Role
    ADD PRIMARY KEY (RoleID);
CREATE TABLE RolePowerAssignment
(
    AssignmentID INTEGER NOT NULL,
    RoleID       INTEGER NULL,
    ConfigID     INTEGER NOT NULL
);
CREATE UNIQUE INDEX XPKRolePowerAssignment ON RolePowerAssignment (AssignmentID);
ALTER TABLE RolePowerAssignment
    ADD PRIMARY KEY (AssignmentID);
CREATE TABLE Student
(
    StudentUserID INTEGER     NOT NULL,
    Class         VARCHAR(50) NULL,
    StudentID     INTEGER     NULL,
    TeamID        INTEGER     NULL
);
CREATE UNIQUE INDEX XPKStudent ON Student (StudentUserID);
ALTER TABLE Student
    ADD PRIMARY KEY (StudentUserID);
CREATE TABLE StudentAssess
(
    Score         INTEGER      NULL,
    Assess        VARCHAR(100) NULL,
    StudentUserID INTEGER      NOT NULL,
    AssessorID    INTEGER      NULL
);
CREATE UNIQUE INDEX XPKStudentAssess ON StudentAssess (StudentUserID);
ALTER TABLE StudentAssess
    ADD PRIMARY KEY (StudentUserID);
CREATE TABLE Task
(
    TaskID          INTEGER      NOT NULL,
    TaskName        VARCHAR(50)  NULL,
    TaskDeadline    DATE         NULL,
    TaskHandlerID   INTEGER      NULL,
    TaskFinishType  INTEGER      NULL,
    TaskStartTime   DATE         NULL,
    TaskPublisherID INTEGER      NULL,
    TaskDescription VARCHAR(100) NULL
);
CREATE UNIQUE INDEX XPKTask ON Task (TaskID);
ALTER TABLE Task
    ADD PRIMARY KEY (TaskID);
CREATE TABLE Team
(
    TeamID          INTEGER      NOT NULL,
    TeamName        VARCHAR(50)  NULL,
    TeamDescription VARCHAR(100) NULL
);
CREATE UNIQUE INDEX XPKTeam ON Team (TeamID);
ALTER TABLE Team
    ADD PRIMARY KEY (TeamID);
CREATE TABLE `User`
(
    UserID           INTEGER      NOT NULL,
    UserName         VARCHAR(50)  NULL,
    UserPassword     VARCHAR(50)  NULL,
    RoleID           INTEGER      NOT NULL,
    Tel              INTEGER      NULL,
    EMail            VARCHAR(100) NULL,
    UserIconLocation VARCHAR(50)  NULL,
    Sex              VARCHAR(50)  NULL
);
CREATE UNIQUE INDEX XPKUser ON `User` (UserID);
ALTER TABLE `User`
    ADD PRIMARY KEY (UserID);
CREATE TABLE FileContent
(
    FileID      INTEGER NOT NULL,
    FileContent BLOB
);
CREATE UNIQUE INDEX XPKFileContent ON FileContent (FileID);
ALTER TABLE FileContent
    ADD PRIMARY KEY (FileID);
-- 此后是增加自增
ALTER TABLE Milestone
    CHANGE MilestoneID MilestoneID INTEGER NOT NULL auto_increment;
ALTER TABLE Milestone
    auto_increment = 1;
ALTER TABLE Files
    CHANGE FileID FileID INTEGER NOT NULL auto_increment;
ALTER TABLE Files
    auto_increment = 1;
ALTER TABLE Communication
    CHANGE CommunicationID CommunicationID INTEGER NOT NULL auto_increment;
ALTER TABLE Communication
    auto_increment = 1;
ALTER TABLE Team
    CHANGE TeamID TeamID INTEGER NOT NULL auto_increment;
ALTER TABLE Team
    auto_increment = 1;
ALTER TABLE Project
    CHANGE ProjectID ProjectID INTEGER NOT NULL auto_increment;
ALTER TABLE Project
    auto_increment = 1;
ALTER TABLE Task
    CHANGE TaskID TaskID INTEGER NOT NULL auto_increment;
ALTER TABLE Task
    auto_increment = 1;
ALTER TABLE Role
    CHANGE RoleID RoleID INTEGER NOT NULL auto_increment;
ALTER TABLE Role
    auto_increment = 1;
ALTER TABLE RolePowerAssignment
    CHANGE AssignmentID AssignmentID INTEGER NOT NULL auto_increment;
ALTER TABLE RolePowerAssignment
    auto_increment = 1;
ALTER TABLE `User`
    CHANGE UserID UserID INTEGER NOT NULL auto_increment;
ALTER TABLE `User`
    auto_increment = 1;
ALTER TABLE PermissionConfig
    CHANGE ConfigID ConfigID INTEGER NOT NULL auto_increment;
ALTER TABLE PermissionConfig
    auto_increment = 1;
-- 此后是增加外键
ALTER TABLE Communication
    ADD FOREIGN KEY R_21 (UserID) REFERENCES `User` (UserID);
ALTER TABLE Communication
    ADD FOREIGN KEY R_22 (TeamID) REFERENCES Team (TeamID);
ALTER TABLE FileAssess
    ADD FOREIGN KEY R_24 (FileID) REFERENCES Files (FileID);
ALTER TABLE FileAssess
    ADD FOREIGN KEY R_35 (AssessorID) REFERENCES `User` (UserID);
ALTER TABLE Files
    ADD FOREIGN KEY R_16 (TeamID) REFERENCES Team (TeamID);
ALTER TABLE Files
    ADD FOREIGN KEY R_17 (StudentUserID) REFERENCES Student (StudentUserID);
ALTER TABLE GroupAssess
    ADD FOREIGN KEY R_26 (TeamID) REFERENCES Team (TeamID);
ALTER TABLE GroupAssess
    ADD FOREIGN KEY R_42 (AssessorID) REFERENCES `User` (UserID);
ALTER TABLE PermissionConfig
    ADD FOREIGN KEY R_2 (ObjectName) REFERENCES Object (ObjectName);
ALTER TABLE PermissionConfig
    ADD FOREIGN KEY R_3 (OperationDescription) REFERENCES Operation (OperationDescription);
ALTER TABLE ProjectAssignment
    ADD FOREIGN KEY R_30 (ProjectID) REFERENCES Project (ProjectID);
ALTER TABLE ProjectAssignment
    ADD FOREIGN KEY R_31 (TeamID) REFERENCES Team (TeamID);
ALTER TABLE ProjectCompletion
    ADD FOREIGN KEY R_32 (FileID) REFERENCES Files (FileID);
ALTER TABLE ProjectCompletion
    ADD FOREIGN KEY R_33 (TeamID) REFERENCES Team (TeamID);
ALTER TABLE ProjectCompletion
    ADD FOREIGN KEY R_34 (MilestoneID) REFERENCES Milestone (MilestoneID);
ALTER TABLE RolePowerAssignment
    ADD FOREIGN KEY R_5 (RoleID) REFERENCES Role (RoleID);
ALTER TABLE RolePowerAssignment
    ADD FOREIGN KEY R_6 (ConfigID) REFERENCES PermissionConfig (ConfigID);
ALTER TABLE Student
    ADD FOREIGN KEY R_11 (StudentUserID) REFERENCES `User` (UserID);
ALTER TABLE Student
    ADD FOREIGN KEY R_13 (TeamID) REFERENCES Team (TeamID);
ALTER TABLE StudentAssess
    ADD FOREIGN KEY R_38 (StudentUserID) REFERENCES Student (StudentUserID);
ALTER TABLE StudentAssess
    ADD FOREIGN KEY R_39 (AssessorID) REFERENCES `User` (UserID);
ALTER TABLE Task
    ADD FOREIGN KEY R_29 (TaskPublisherID) REFERENCES `User` (UserID);
ALTER TABLE `User`
    ADD FOREIGN KEY R_8 (RoleID) REFERENCES Role (RoleID);