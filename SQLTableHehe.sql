CREATE DATABASE Hehe
USE Hehe
use master
drop database Hehe
-- CREATE TABLE --

CREATE TABLE Admin (
	Id int identity NOT NULL,
	[Password] varchar(50) NOT NULL,
	Email varchar(50) NOT NULL,
	[Role] nvarchar(15) NOT NULL,
	CreatedAt date,
	UpdatedAt date,
    CONSTRAINT PK_Admin PRIMARY KEY (Id),
)

CREATE TABLE Student (
	Id int identity NOT NULL,
	FirstName nvarchar(50) NOT NULL,
	LastName nvarchar(50) NOT NULL,
	Dob date,
	Email varchar(50) NOT NULL,
	[Password] varchar(50) NOT NULL,
	PhoneNumber char(10) NOT NULL,
	[Status] nvarchar(30) NOT NULL,
	[Role] nvarchar(15) NOT NULL,
	CreatedAt date,
	UpdatedAt date,
    CONSTRAINT PK_Student PRIMARY KEY (Id),
)

CREATE TABLE Author (
	Id int identity NOT NULL,
	FirstName nvarchar(50) NOT NULL,
	LastName nvarchar(50) NOT NULL,
	Dob date,
	Email varchar(50) NOT NULL,
	[Password] varchar(50) NOT NULL,
	PhoneNumber char(10) NOT NULL,
	[Status] nvarchar(30) NOT NULL,
	[Role] nvarchar(15) NOT NULL,
	CreatedAt date,
	UpdatedAt date,
    CONSTRAINT PK_Author PRIMARY KEY (Id),
)

CREATE TABLE Category (
	Id int identity NOT NULL,
	[Name] nvarchar(50),
	[Description] nvarchar(500), -- cai nay ko biet dung data type gi
	[Status] nvarchar(30),
	UpdatedAt date,
    CONSTRAINT PK_Category PRIMARY KEY (Id),
)

CREATE TABLE Course (
	Id int identity NOT NULL,
	AuthorId int NOT NULL,
	CategoryId int NOT NULL,
	[Name] nvarchar(50),
	[Description] nvarchar(500),
	[Status] nvarchar(30),
	Price money,
	CreatedAt date,
	UpdatedAt date,
	Duration float,
    CONSTRAINT PK_Course PRIMARY KEY (Id),
	CONSTRAINT FK_Course_AuthorId_Author_Id FOREIGN KEY (AuthorId) REFERENCES Author(Id),
	CONSTRAINT FK_Course_CategoryId_Category_Id FOREIGN KEY (CategoryId) REFERENCES Category(Id)
)

CREATE TABLE Skill (
	Id int identity NOT NULL,
	[Name] nvarchar(50),
    CONSTRAINT PK_Skill PRIMARY KEY (Id),
)

CREATE TABLE Section (
	Id int identity NOT NULL,
	CourseId int NOT NULL,
	[Name] nvarchar(50),
	[Description] nvarchar(50),
	DisplayIndex int,
	UpdatedAt date,
    CONSTRAINT PK_Section PRIMARY KEY (Id),
	CONSTRAINT FK_Section_CourseId_Course_Id FOREIGN KEY (CourseId) REFERENCES Course(Id),
)

CREATE TABLE Topic (
	Id int identity NOT NULL,
	SectionId int NOT NULL,
	CourseId int NOT NULL, -- cai nay de luu data course ko phai de link
	[Name] nvarchar(50),
	[Description] nvarchar(3000),
	[Status] nvarchar(30),
	DisplayIndex int,
	CreatedAt date,
	UpdatedAt date,
    CONSTRAINT PK_Topic PRIMARY KEY (Id),
	CONSTRAINT FK_Topic_SectionId_Section_Id FOREIGN KEY (SectionId) REFERENCES Section(Id),
)

CREATE TABLE Quiz (
	Id int identity NOT NULL,
	TopicId int UNIQUE, -- UNIQUE nhung null duoc vi 1-1
	Content nvarchar(1000), -- cai nay ko biet dung data type gi
	[Date] date,
	NumberAnswers int, -- cai nay la so cau hoi a
	CreatedAt date,
	UpdatedAt date,
    CONSTRAINT PK_Quiz PRIMARY KEY (Id),
	CONSTRAINT FK_Quiz_TopicId_Topic_Id FOREIGN KEY (TopicId) REFERENCES Topic(Id),
)

CREATE TABLE Answer (
	Id int identity NOT NULL,
	QuizId int NOT NULL,
	Content nvarchar(1000),
	IsCorrect bit,
	CreatedAt date,
	UpdatedAt date,
    CONSTRAINT PK_Answer PRIMARY KEY (Id),
	CONSTRAINT FK_Answer_QuizId_Quiz_Id FOREIGN KEY (QuizId) REFERENCES Quiz(Id),
)

CREATE TABLE StudentInCourse (
	Id int identity NOT NULL,
	StudentId int,
	CourseId int,
	DisplayIndex int, 
	[Certificate] varchar(100), -- cai nay la 1 cai url chua hinh anh certi
	StartDate date,
	DeadlineDate date,
	[Status] nvarchar(15),
    CONSTRAINT PK_StudentInCourse PRIMARY KEY (Id),
	CONSTRAINT FK_StudentInCourse_StudentId_Student_Id FOREIGN KEY (StudentId) REFERENCES Student(Id),
	CONSTRAINT FK_StudentInCourse_CourseId_Course_Id FOREIGN KEY (CourseId) REFERENCES Course(Id)
)

CREATE TABLE StudentInTopic (
	Id int identity NOT NULL,
	StudentCourseId int NOT NULL,	
	TopicId int,
	StartDate date,
	DeadlineDate date,
    CONSTRAINT PK_StudentInTopic PRIMARY KEY (Id),
	CONSTRAINT FK_StudentInTopic_StudentCourseId_StudentInCourse_Id FOREIGN KEY (StudentCourseId) REFERENCES StudentInCourse(Id),
	CONSTRAINT FK_StudentInTopic_TopicId_Topic_Id FOREIGN KEY (TopicId) REFERENCES Topic(Id),
)

CREATE TABLE StudentInQuiz (
	Id int identity NOT NULL,
	StudentTopicId int,
	QuizId int,
	CreatedAt date,
    CONSTRAINT PK_StudentInQuiz PRIMARY KEY (Id),
	CONSTRAINT FK_StudentInQuiz_StudentTopicId_StudentInTopic_Id FOREIGN KEY (StudentTopicId) REFERENCES StudentInTopic(Id),
	CONSTRAINT FK_StudentInQuiz_QuizId_Quiz_Id FOREIGN KEY (QuizId) REFERENCES Quiz(Id),
)

CREATE TABLE StudentAnswer (
	Id int identity NOT NULL,
	StudentQuizId int,
	AnswerId int,
	CreatedAt date,
    CONSTRAINT PK_StudentAnswer PRIMARY KEY (Id),
	CONSTRAINT FK_StudentAnswer_StudentQuizId_StudentInQuiz_Id FOREIGN KEY (StudentQuizId) REFERENCES StudentInQuiz(Id),
	CONSTRAINT FK_StudentAnswer_AnswerId_Answer_Id FOREIGN KEY (AnswerId) REFERENCES Answer(Id),
)

CREATE TABLE CourseInSkill (
	Id int identity NOT NULL,
	SkillId int UNIQUE NOT NULL,
	CourseId int NOT NULL,
    CONSTRAINT PK_CourseInSkill PRIMARY KEY (Id),
	CONSTRAINT FK_CourseInSkill_SkillId_Skill_Id FOREIGN KEY (SkillId) REFERENCES Skill(Id),
	CONSTRAINT FK_CourseInSkill_CourseId_Course_Id FOREIGN KEY (CourseId) REFERENCES Course(Id),
)

CREATE TABLE Comment (
	Id int identity NOT NULL,
	MasterId int NULL,
	StudentTopicId int,
	[Text] nvarchar(50),
	[Date] date,
	[Level] int NOT NULL,
    CONSTRAINT PK_Comment PRIMARY KEY (Id),
	CONSTRAINT FK_Comment_StudentTopicId_StudentInTopic_Id FOREIGN KEY (StudentTopicId) REFERENCES StudentInTopic(Id),
	CONSTRAINT FK_Comment_MasterId_Comment_Id FOREIGN KEY (MasterId) REFERENCES Comment(Id)
)

-- //////////////// TRIGGER \\\\\\\\\\\\\\\\

-- ADMIN
GO
CREATE TRIGGER Admin_InsertDate ON Admin AFTER INSERT AS 
BEGIN
	UPDATE Admin SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Admin SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Admin_UpdateDate ON Admin AFTER INSERT AS 
BEGIN
	UPDATE Admin SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- STUDENT
GO
CREATE TRIGGER Student_InsertDate ON Student AFTER INSERT AS 
BEGIN
	UPDATE Student SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Student SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Student_UpdateDate ON Student AFTER INSERT AS 
BEGIN
	UPDATE Student SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- AUTHOR
GO
CREATE TRIGGER Author_InsertDate ON Author AFTER INSERT AS 
BEGIN
	UPDATE Author SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Author SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Author_UpdateDate ON Author AFTER INSERT AS 
BEGIN
	UPDATE Author SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- COURSE
GO
CREATE TRIGGER Course_InsertDate ON Course AFTER INSERT AS 
BEGIN
	UPDATE Course SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Course SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Course_UpdateDate ON Course AFTER INSERT AS 
BEGIN
	UPDATE Course SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Course_InsertPrice ON Course AFTER INSERT AS 
BEGIN
	UPDATE Course SET Price = 0
END

-- chưa viết trigger cho việc thêm giá tiền vào (lưu ý)

-- CATEGORY
GO
CREATE TRIGGER Category_UpdateDate ON Category AFTER INSERT AS 
BEGIN
	UPDATE Category SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- SECTION
GO
CREATE TRIGGER Section_UpdateDate ON Section AFTER INSERT AS 
BEGIN
	UPDATE Section SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- TOPIC
GO
CREATE TRIGGER Topic_InsertDate ON Topic AFTER INSERT AS 
BEGIN
	UPDATE Topic SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Topic SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Topic_UpdateDate ON Topic AFTER INSERT AS 
BEGIN
	UPDATE Topic SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- QUIZ
GO
CREATE TRIGGER Quiz_InsertDate ON Quiz AFTER INSERT AS 
BEGIN
	UPDATE Quiz SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Quiz SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Quiz_UpdateDate ON Quiz AFTER INSERT AS 
BEGIN
	UPDATE Quiz SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- ANSWER
GO
CREATE TRIGGER Answer_InsertDate ON Answer AFTER INSERT AS 
BEGIN
	UPDATE Answer SET CreatedAt = (SELECT CAST(GETDATE() AS date))
	UPDATE Answer SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

GO
CREATE TRIGGER Answer_UpdateDate ON Answer AFTER INSERT AS 
BEGIN
	UPDATE Answer SET UpdatedAt = (SELECT CAST(GETDATE() AS date))
END

-- STUDENT IN COURSE
GO
CREATE TRIGGER StudentInCourse_InsertDate ON StudentInCourse AFTER INSERT AS 
BEGIN
	UPDATE StudentInCourse SET StartDate = (SELECT CAST(GETDATE() AS date))
END

-- STUDENT IN TOPIC
GO
CREATE TRIGGER StudentInTopic_InsertDate ON StudentInTopic AFTER INSERT AS 
BEGIN
	UPDATE StudentInTopic SET StartDate = (SELECT CAST(GETDATE() AS date))
END

-- STUDENT IN QUIZ
GO
CREATE TRIGGER StudentInQuiz_InsertDate ON StudentInQuiz AFTER INSERT AS 
BEGIN
	UPDATE StudentInQuiz SET CreatedAt = (SELECT CAST(GETDATE() AS date))
END

-- STUDENT IN ANSWER
GO
CREATE TRIGGER StudentAnswer_InsertDate ON StudentAnswer AFTER INSERT AS 
BEGIN
	UPDATE StudentAnswer SET CreatedAt = (SELECT CAST(GETDATE() AS date))
END

-- COMMENT
GO
CREATE TRIGGER Comment_InsertDate ON Comment AFTER INSERT AS 
BEGIN
	UPDATE Comment SET Date = (SELECT CAST(GETDATE() AS date))
END


-- //////////////// INSERT \\\\\\\\\\\\\\\\

-- STUDENT
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Marshall', 'Hamlyn', '2002-05-07', 'mhamlyn0@hatena.ne.jp', 'QAeufP57', '6856900891', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Micheil', 'Bier', '2004-01-15', 'mbier1@google.cn', 'PggEpkOPvn', '2286845065', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Clayborne', 'Elecum', '2010-06-15', 'celecum2@virginia.edu', '7ulVFnqQ', '7116468581', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Elena', 'MacAlpyne', '1995-12-27', 'emacalpyne3@tinyurl.com', 'b0WE9i6XcdsN', '6832538452', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Lennard', 'Heritege', '1992-09-11', 'lheritege4@dion.ne.jp', 't3UNHyaHdBd', '9925900873', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Cynthea', 'Fryatt', '1990-05-11', 'cfryatt5@whitehouse.gov', '4WCUmQWl6lr', '4319387566', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Gilbertina', 'Snoddin', '2002-12-17', 'gsnoddin6@spotify.com', 'lXpYXJJehJSB', '1729996691', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Merrielle', 'Spowart', '2003-10-14', 'mspowart7@gov.uk', 'kmyqdqV538P', '9691826245', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Foster', 'Bottrill', '2001-04-27', 'fbottrill8@npr.org', 'c5fkc5W', '7364913123', 'Active', 'Student');
insert into Student (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Carmita', 'Rubinovitch', '2012-06-08', 'crubinovitch9@is.gd', 'KaD3tdD', '1444199088', 'Active', 'Student');

-- AUTHOR
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Constancia', 'Mattielli', '1941-07-10', 'cmattielli0@cdc.gov', 'shQj2ooErEDa', '6722422834', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Marguerite', 'Edy', '1971-08-01', 'medy1@cocolog-nifty.com', 'mPJlv8VJX8', '6929346926', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Vina', 'Donoher', '1956-05-21', 'vdonoher2@over-blog.com', 'r2NLDQxznGx', '2302729809', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Sidoney', 'Heersema', '1976-04-15', 'sheersema3@sciencedaily.com', 'CXI4olZ4g0', '8261921630', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Rubin', 'Cote', '1987-12-16', 'rcote4@arstechnica.com', 'n0tN9yeztHgH', '6292682957', 'Active', 'v');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Malvina', 'Derkes', '1976-01-20', 'mderkes5@163.com', 'twey7Ai8UA', '7526354326', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Rycca', 'Bril', '1968-07-08', 'rbril6@nature.com', 'KwboSM', '7217768423', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Lonna', 'Emson', '1944-07-18', 'lemson7@shop-pro.jp', 'QtQB9xbvi', '9703997504', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Eve', 'Wapol', '1995-06-10', 'ewapol8@infoseek.co.jp', 'biEeSkj0YN4X', '2339641651', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Hoang', 'Nguyen The', '1977-09-25', 'HoangNT20@fe.edu.vn', 'D7fW7W7z', '5551653472', 'Active', 'Author');
-- select Id, FirstName, LastName, DOB, Email, Password, PhoneNumber, Status, Role, CreatedAt, UpdatedAt from Student where Email = 'mhamlyn0@hatena.ne.jp' and Password = 'QAeufP57'

-- SKILL
INSERT INTO Skill ([Name]) VALUES ('C#')
INSERT INTO Skill ([Name]) VALUES ('Java')
INSERT INTO Skill ([Name]) VALUES ('C++')
INSERT INTO Skill ([Name]) VALUES ('C')
INSERT INTO Skill ([Name]) VALUES ('HTML')
INSERT INTO Skill ([Name]) VALUES ('CSS')
INSERT INTO Skill ([Name]) VALUES ('JavaScript')
INSERT INTO Skill ([Name]) VALUES ('SQL Server')
INSERT INTO Skill ([Name]) VALUES ('Python')
INSERT INTO Skill ([Name]) VALUES ('MongoDB')

-- CATEGORY
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Front-end Programming','This is a course about front-end developing.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Back-end Programming','This is a course about back-end developing.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Embedded Programming','This is a course about embedded developing.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('OOP Programming','This is a course about object-oriented programming.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Basic Programming','This is a course about basic knowledge in programming.','Active','')

-- COURSE
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (1, 1, 'HTML Basic','This course introduces basic knowledge about HTML','Active',0,'','',2.3)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (1, 1, 'CSS Basic','This course introduces basic knowledge about CSS','Active',0,'','',3.75)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (3, 4, 'C# Basic','This course will provide you with a basic knowledge of C # programming through basic concepts and practical exercises in the C # programming language.','Active',0,'','',2.4)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (4, 4, 'C++ Basic','This course introduces advanced knowledge about C#','Active',0,'','',5.8)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (1, 3, 'Internet Of Things','This course introduces knowledge about the Internet of Things','Active',0,'','',3.5)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (8, 5, 'C Basic','The complete C Programing Course for Beginners, this course teaches you the fundamentals of a programing language. After completed, you will be able to move from the basics to more advanced course.','Active',0,'','',4.2)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (10, 4, 'OOP With Java','This course provides knowledge about object-oriented Java','Active',0,'','',3.2)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (4, 1, 'JavaScript Basic','Help students master the basic fundamental and syntax in Javascript - the most popular programming language in the world.','Active',0,'','',10.8)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (6, 4, 'C++ Advanced','Advanced C ++ course is for those who have mastered the basic knowledge. This course will help you take a closer look at what you have learned in the basic course and learn about some new concepts.','Active',0,'','',9.1)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (7, 2, 'Java Web Development','This course provides method on develop an web app with Java','Active',0,'','',11.7)

-- SECTION
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (1, 'HTML Structure', 'Basic knowledge about HTML structure.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (1, 'Comment', 'How to write comments in HTML.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (1, 'Common HTML Tags', 'Some common HTML tags to start.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (1, 'Attributes', 'Definition HTML attributes.', 4)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'Using CSS in HTML', 'How to use CSS in HTML.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'ID And Classes', 'Definition of ID and classes in CSS.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'Priority In CSS', 'Definition of CSS priority.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'Variables', 'Definition of variables in CSS.', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'CSS Units', 'Some common units in CSS.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'CSS Methods', 'Some common methods in CSS.', 6)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'Pseudo Classes', 'Definition of pseudo classes.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (2, 'Pseudo Elements', 'Definition of pseudo elements.', 6)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'First C# Program', 'Creating the first C program.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'Variable', 'Definition of variable.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'Operators', 'Definition of input.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'Conditional statements', 'Definition of selection statements.', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'Loops', 'Definition of loops.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'Array', 'Definition of array.', 6)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'String', 'Definition of string.', 7)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (3, 'C# Method', 'Definition of function.', 8)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'First C++ Program', 'Creating the first C++ program.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'Variables and Data Types', 'Definition of variable.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'Basic Operators & Input', 'Definition of input.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'Selection statements', 'Definition of selection statements.', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'Loops', 'Definition of loops.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'Array', 'Definition of array.', 6)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'String', 'Definition of string.', 7)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (4, 'Function', 'Definition of function.', 8)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'Introduction To IoT', 'Introduction to IoT and it''s components.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'Advantages And Disadvantages', 'Advantages and disadvantages of IoT in our real life.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'Understanding Internet', 'Definition of Internet.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'Understanding Electronics', 'Definition of Electronics.', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'IoT Boards', 'IoT boards and mechanics behind them.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'Sensor And Actuator', 'How to use sensor and actuator.', 6)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (5, 'Learning Arduino Programming', 'How to program Arduino and perform projects.', 7)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'First C Program', 'Creating the first C program.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'Variable', 'Definition of variable.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'Input', 'Definition of input.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'Selection statements', 'Definition of selection statements.', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'Loops', 'Definition of loops.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'Array', 'Definition of array.', 6)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'String', 'Definition of string.', 7)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (6, 'Function', 'Definition of function.', 8)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (7, 'Classes and objects', 'Definition of classes and objects', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (7, 'Static variables and methods', 'Definition of static variables and methods', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (7, 'Encapsulation', 'Definition of encapsulation', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (7, 'Inheritance', 'Definition of inheritance', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (7, 'Polymorphism and abstraction', 'Definition of polymorphism and abstraction', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (7, 'Relationships', 'Definition of relationships', 6)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'Overview, console.log and comments', 'Creating the first C program.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'Variable', 'Definition of variable.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'Operators', 'Definition of input.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'Functions', 'Definition of selection statements.', 4)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'If - Else and Switch - Case statements', 'Definition of loops.', 5)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'Loops', 'Definition of array.', 6)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (8, 'Methods', 'Definition of string.', 7)

INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (9, 'Pointer', 'Creating the first C program.', 1)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (9, 'Array', 'Definition of variable.', 2)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (9, 'Bitwise', 'Definition of input.', 3)
INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (9, 'Struct', 'Definition of selection statements.', 4)

-- TOPIC
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,7, 'Data type and variables','Definition of data type and parameters in Java', 'Active', 1)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,7, 'Function','Explore function feature and create function method', 'Active', 2) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,7, 'Object and class','All information about object and class', 'Active', 3) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (3,7, 'Creating Java application','Create Java step-by-step', 'Active', 4) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,7, 'Static','A different memory: static', 'Active', 5) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,7, 'Input and try-catch','Definition of input and try-catch in Java', 'Active', 6) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,7, 'Primitive array','Definition of primitive array in Java', 'Active', 7) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,7, 'Object array','Definition of object array in Java', 'Active', 8) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (4,7, 'Inheritance','Definition of inheritance in Java', 'Active', 9) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (4,7, 'Abstract class','Definition of abstract class in Java', 'Active', 10) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (5,7, 'Interface','Definition of interface in Java', 'Active', 11) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (6,7, 'Collections framework','Definition of collections framework in Java', 'Active', 12) 
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (6,7, 'Wrapper','Definition of wrapper in Java', 'Active', 13) 

INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,6, 'Writing "Hello World!"','In a C program, printf() function is used to print values on the screen. See the example below:<br>When the above code is compiled and executed, it produces the following result:<br>There are some statements in the code that you are not familiar with such as #include<stdio.h>, int main(){ and return 0; but you do not have to pay attention to them in this lesson. You can assume that they are the required parts of a C program.<br>Now, replace printf("Hello Codelearn"); with printf("You can code"); as below:<br>When the above code is compiled and executed, it produces the following result:<br>Now you can return to the Task above and solve it.','Active',1)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,6, 'Comments','The comment is explanatory statements that you can include in the code. Their purpose is only to allow the programmer to insert notes or descriptions embedded within the source code so that they can easily understand their code. All characters available inside any comment are ignored by the C compiler.<br>C supports single-line and multi-line comments.<br>Single-line comments can start with //, extending to the end of the line.<br>You can also put a comment right after the statement. For example:<br>Multi-line comments start with /* and end with */. For example.<br>Now you can return to the Task and solve it or refer to the instruction below..','Active',2)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,6, 'Plus operator','According to the previous lessons, to display 1324 + 7553 = , we use this statement:<br>To display the sum of 1324 and 7553, use this statement:<br>You can combine two statements above as below:<br>When the above code is compiled and executed, it produces the following result:<br>1324 + 7553 = 8877<br>Now you can return to the Task above and solve it or refer to the instruction below.','Active',3)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (1,6, 'Showing data on multiple rows','First, run this program:<br>When the above code is compiled and executed, it produces the following result:<br>As you can see, the program cannot display the information we need on in two lines. To insert a new line, use ''\n'' in printf function.<br>When the above code is compiled and executed, it produces the following result:<br>Or you can use ''\n'' as below:<br>Now you can return to the Task and solve it or refer to the instruction below.','Active',4)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,6, 'Declaring variables','The definition of variables in C++ is just the same as that of variables in Mathematics. Variables are containers for storing data values.<br>Example of the declaration of integer variables:<br>When the above code is compiled and executed, it produces the following result:<br>You can also declare and assign value to a variable in a statement as below:<br>When the above code is compiled and executed, it produces the following result:<br>Variable naming conventions:<br>Variable names can have letters, numbers, and underscores, but it must start with an underscore or a letter.<br>Variable names cannot contain spaces.<br>Variable names can be anything but not the keywords such as int, float, static, struct, etc.<br>Legal variable names:<br>int a;<br>int _a;<br>int a10_;<br>Illegal variable names:<br>int 10a;<br>int a 10;<br>int int;<br>Now you can return to the Task above and solve it or refer to the instruction below.','Active',5)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,6, 'Float and double','To declare a variable which is a real number and assign a value to it, we use keyword double:<br>double a = 10.5;<br>To display a real number on the screen, use printf() function and %f.<br>This program declares a variable of type double and displays it on the screen:<br>When the above code is compiled and executed, it produces the following result:<br>a = 1.500000<br>Except double, C programming language also uses float to store the values of real numbers. However, you can use double in most cases.<br>Note: You cannot use type int to store values of real numbers.<br>As you can see, when using int, the output is wrong.<br>Now you can return to the Task above and solve it or refer to the instruction below.','Active',6)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,6, 'Char','In C++, character type allows a variable to store only one character in ASCII table. This character can be a letter (a, b, c, ... x, y, z), a number (0, 1, 2,..., 9), an operator (+, -, *, /) or any special character (!, &, ...).<br>The keyword used for the character data type is char (char stands for character), to print a character, use %c format specifier. Example of a program that declares and displays a variable of type char:<br>When the above code is compiled and executed, it produces the following result:<br>a<br>Now you can return to the Task and solve it or refer to the instruction below.','Active',6)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (2,6, 'Display the next character','The goal of this lesson is to help you understand more about the character type. Read the theory below to know how to fill the blank (...) to display the character ''d''.<br>Characters essentially are integers, to print an integer, use %d format specifier.<br>When the above code is compiled and executed, it produces the following result:<br>a = 97<br>b = 98<br>c = 99<br>d = 100<br>e = 101<br>...<br>x = 120<br>y = 121<br>z = 122<br>As you can see, the list of numeric values of all characters from ''a'' to ''z'' makes an ascending sequence, each pair of successive values in the sequence are separated by 1 unit.<br>Because characters essentially are integers, you can also apply operators (+, -, *, /) to declare a variable. According to the result of the program above, letter ''d'' is equal to ''a'' + 3, letter ''e'' is equal to ''d'' + 1.<br>When the above code is compiled and executed, it produces the following result:<br>d<br>e<br>Now you can return to the Task above and solve it or refer to the instruction below.','Active',6)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (3,6, 'If else in C','We use the if statement to specify a block of JavaScript code to be executed if a condition is true.<br>In C, operator == compares whether the values on both sides of the operator are equal, operator != compares whether values on both sides of the operator are not equal. As the above example, if (n % 2 == 0) is the statement to check whether the n leaves remainder 0 when divided by 2, if (n % 2 != 0) is the statement to check whether the remainder is not equal to 0 when n divided by 2.','Active',7)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (3,6, 'Switch case in C','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec velit ex. Suspendisse sed finibus tellus. Duis consequat, felis et auctor sodales, ipsum nibh porttitor metus, id dictum eros quam et metus. Etiam ut quam elit. Sed elit dolor, vestibulum quis fringilla dapibus, efficitur non leo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent egestas ipsum justo, tincidunt molestie est imperdiet id. Sed cursus, mauris a imperdiet ultrices, nunc purus ornare lorem, volutpat malesuada augue risus sit amet enim. Nullam eget cursus arcu. Nulla facilisis sed nulla ut faucibus.','Active',8)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (4,6, 'For loop','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec velit ex. Suspendisse sed finibus tellus. Duis consequat, felis et auctor sodales, ipsum nibh porttitor metus, id dictum eros quam et metus. Etiam ut quam elit. Sed elit dolor, vestibulum quis fringilla dapibus, efficitur non leo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent egestas ipsum justo, tincidunt molestie est imperdiet id. Sed cursus, mauris a imperdiet ultrices, nunc purus ornare lorem, volutpat malesuada augue risus sit amet enim. Nullam eget cursus arcu. Nulla facilisis sed nulla ut faucibus.','Active',9)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (4,6, 'While loop','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec velit ex. Suspendisse sed finibus tellus. Duis consequat, felis et auctor sodales, ipsum nibh porttitor metus, id dictum eros quam et metus. Etiam ut quam elit. Sed elit dolor, vestibulum quis fringilla dapibus, efficitur non leo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent egestas ipsum justo, tincidunt molestie est imperdiet id. Sed cursus, mauris a imperdiet ultrices, nunc purus ornare lorem, volutpat malesuada augue risus sit amet enim. Nullam eget cursus arcu. Nulla facilisis sed nulla ut faucibus.','Active',10)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (4,6, 'Do while loop','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec velit ex. Suspendisse sed finibus tellus. Duis consequat, felis et auctor sodales, ipsum nibh porttitor metus, id dictum eros quam et metus. Etiam ut quam elit. Sed elit dolor, vestibulum quis fringilla dapibus, efficitur non leo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent egestas ipsum justo, tincidunt molestie est imperdiet id. Sed cursus, mauris a imperdiet ultrices, nunc purus ornare lorem, volutpat malesuada augue risus sit amet enim. Nullam eget cursus arcu. Nulla facilisis sed nulla ut faucibus.','Active',11)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (5,6, 'Array','The above code forces you to declare many variables and it might be impossible if you want to create hundreds of variables. Fortunately, you can solve this problem using arrays.<br>An array represents a collection of elements (values or variables).<br>As you can see, instead of creating 10 variables, you just need to create an array of 10 elements. It means instead of entering the values of variables to find the sum of them, you need to enter the values of elements to find the sum of them.<br>The values of any of the elements in an array can be accessed just like the value of a regular variable of the same type. The syntax is: name[index]','Active',12)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (5,6, '2-dimensional array','A 2-dimensional array, also known as a matrix, is an array of one-dimensional arrays. 2-dimensional arrays are like a table where 1-dimensional arrays are rows in the table and array elements are cells.<br>Syntax to declare a two-dimensional array with 3 rows and 5 columns: int arr[3][5];','Active',13)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (6,6, 'String','Strings are actually one-dimensional array of characters terminated by a null character ''\0''. You can initialize strings like initializing arrays:<br>char str[] = "abcd";<br>-char str[50] = "abcd";<br>char str[] = {''a'', ''b'', ''c'', ''d'', ''\0''};<br>char str[5] = {''a'', ''b'', ''c'', ''d'', ''\0''};<br>To input data and display it on the screen, use %s format specifier.<br>Note: when input data to a string, don''t use & operator in scanf() function.','Active',14)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (6,6, 'String length','As is the previous lessons, strings are actually one-dimensional array of characters terminated by a null character ''\0''. Therefore, you can iterate over characters of the string from i = 0 to until ''\0'' (null character) is encountered. In each iteration, the value of i is increased by 1. <br>Besides, you can use strlen() function in string.h library to find the length of a string','Active',15)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (6,6, 'Turn lowercase to UPPERCASE','Characters are essentially integers. When you convert a lowercase character to an uppercase character, it means you convert an integer to another integer. As in previous lessons, to find the integer value (in ASCII table) of a character.<br>As you can see, the value of a lowercase character is equal to the total value of its uppercase character and 32. ','Active',16)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (6,6, 'Comparing 2 strings','You cannot use == operator to check whether 2 strings are the same because this operator compares addresses of the first elements in two strings.<br>str1 is not equal to str2<br>To check whether two strings are the same, use strcmp() function in string.h. This function returns 0 if two strings are the same or returns a number not equal to 0 if the two strings are not the same.','Active',17)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (7,6, 'Function','The function is a block of code that only runs when it is called. Using a function is easy.<br>A function can be called multiple times. To display two English alphabets, you can call the function twice.<br>To create (often referred to as declare) a function, specify the name of the function, followed by parentheses ():<br>void functionName() {<br>/*<br>code to be executed<br>	this code block will be executed when called<br>	*/<br>}<br>To call a function, write the function''s name followed by two parentheses () and a semicolon ;','Active',18)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (7,6, 'Function with parameters','Function show() in the above code is a function with parameter, which is a variable of type string.<br>To call a function with parameters, you need to provide value with parameters. These values are called arguments. <br>As can be seen, when call function show(); you have to pass values to 3 parameters. ','Active',19)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (7,6, 'Calling function','You probably notice a problem with this approach is that the code in all three for loops is duplicated. Obviously, you need to find a way to reuse the code instead of having to repeat this code every time you need it.<br>Through the previous lessons about function, you already know that the function is used to represent a block of code, so you can put the duplicated code into the function and every time you use it, you just need to call the function.<br>When using a function, the above program becomes shorter and easier to understand.','Active',20)
INSERT INTO Topic (SectionId, CourseId, [Name], [Description], [Status], DisplayIndex) VALUES (7,6, 'Function with return','In the previous lessons, you learned how to create and use functions with no return values. Functions with no return value are declared with the keyword void. These functions are used to execute the code in the body of the function and do not need to return the result after the execution is completed.<br>Functions with return values will return a result after execution.<br>In the above example, function sum() is declared with the keyword int so that the return value is type int (the result of this function is an integer).<br>To return a result of the function, you use the return statement. As in the example above, function sum() calls return statement add; so the result of the function is variable add.<br>Because sum() is a function whose return value is an integer, you can use this function as an integer (you can assign int a = sum(3); or output cout << sum(3);, ...).<br>Note: Function stops executing when it meets return statement.','Active',21)




select * from Section
select * from Author
select * from Student
select * from Topic


select * from Topic t left join Section s on t.SectionId = s.Id

/*
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role]) values ('Bron', 'Burgwyn', '10/16/1983', 'bburgwyn0@lycos.com', '9SxguSaItpKR', '6502713963', 'Active', 'Author');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Prince', 'Luckie', '02/21/1997', 'pluckie1@booking.com', 'OhdDg4QyEar', '3941165616', 'Active', 'Author', '07/20/2021', '01/12/2022');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Lina', 'Turtle', '11/11/1963', 'lturtle2@un.org', 'RDIGmm', '1085161477', 'Active', 'Author', '09/12/2021', '10/09/2020');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Flora', 'Bundy', '12/12/1994', 'fbundy3@slideshare.net', 'inlGWE3', '7544698087', 'Active', 'Author', '06/12/2021', '08/25/2021');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Darb', 'Rodd', '04/06/1950', 'drodd4@com.com', 'ZCpP9zWUCR', '7119149439', 'Active', 'Author', '04/28/2020', '10/29/2021');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Alleen', 'Elwood', '01/27/1979', 'aelwood5@clickbank.net', 'TOX6o7dUpW', '8515264841', 'Active', 'Author', '04/29/2020', '06/04/2020');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Clem', 'Corkhill', '02/28/1957', 'ccorkhill6@ucsd.edu', 'kCQvX1qxy5', '9159452027', 'Active', 'Author', '04/04/2022', '05/31/2021');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Sarge', 'Cargon', '03/17/1969', 'scargon7@shinystat.com', 'VAlrenF', '2537748284', 'Active', 'Author', '09/13/2020', '09/05/2021');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Bailie', 'Binstead', '07/11/1964', 'bbinstead8@skype.com', 'cI45zhgL', '3224664292', 'Active', 'Author', '12/04/2021', '06/24/2020');
insert into Author (FirstName, LastName, Dob, Email, [Password], PhoneNumber, [Status], [Role], CreatedAt, UpdatedAt) values ('Osmund', 'Roston', '01/17/1994', 'oroston9@artisteer.com', 'O2gD7Bz8mpJS', '2111189910', 'Active', 'Author', '05/08/2020', '07/24/2020');


INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Front-end Programming','This is a course about front-end developing.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Back-end Programming','This is a course about back-end developing.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Embedded Programming','This is a course about embedded developing.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('OOP Programming','This is a course about object-oriented programming.','Active','')
INSERT INTO Category ([Name], [Description], [Status], UpdatedAt) VALUES ('Basic Programming','This is a course about basic knowledge in programming.','Active','')

INSERT INTO Skill ([Name]) VALUES ('C#')
INSERT INTO Skill ([Name]) VALUES ('Java')
INSERT INTO Skill ([Name]) VALUES ('C++')
INSERT INTO Skill ([Name]) VALUES ('C')
INSERT INTO Skill ([Name]) VALUES ('JavaScript')
INSERT INTO Skill ([Name]) VALUES ('SQL')

INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (1, 1, 'HTML Basic','This course introduces basic knowledge about HTML','Active',0,'','',6.5)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (2, 1, 'CSS Basic','This course introduces basic knowledge about CSS','Active',0,'','',3.75)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (3, 4, 'C# Basic','This course introduces basic knowledge about C#','Active',0,'','',2.4)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (4, 4, 'C# Advanced','This course introduces advanced knowledge about C#','Active',0,'','',5.8)
INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, CreatedAt, UpdatedAt, Duration) VALUES (1, 3, 'C Basic','This course introduces basic knowledge about C','Active',0,'','',3.5)

select * from Author
select * from Course
select * from Skill
select * from Category
*/