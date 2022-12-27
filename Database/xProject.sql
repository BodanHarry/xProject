create Database xProject
go

use xProject
go

/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 15.0 		*/
/*  Created On : 14-nov-2022 9:17:54 PM 				*/
/*  DBMS       : SQL Server 2012 						*/
/* ---------------------------------------------------- */

/* Drop Foreign Key Constraints */

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Input_Product]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Input] DROP CONSTRAINT [FK_Input_Product]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Input_User]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Input] DROP CONSTRAINT [FK_Input_User]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Output_Product]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Output] DROP CONSTRAINT [FK_Output_Product]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Output_User]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Output] DROP CONSTRAINT [FK_Output_User]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Product_Category]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Product] DROP CONSTRAINT [FK_Product_Category]
GO

/* Drop Tables */

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Category]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Category]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Input]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Input]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Output]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Output]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Product]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Product]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[User]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [User]
GO

/* Create Tables */

CREATE TABLE [ColorIdentifier]
(
	[ColorID] int NOT NULL,
)
GO

CREATE TABLE [Category]
(
	[CategoryID] int NOT NULL IDENTITY (1, 1),
	[Productdescription] nvarchar(80) NULL,
	[Producttype] nvarchar(80) NULL,
	[Productsize] nvarchar(80) NULL
)
GO

CREATE TABLE [Input]
(
	[InputID] int NOT NULL IDENTITY (1, 1),
	[Inputdate] nvarchar(20) NULL,
	[Inputprice] decimal(30,2) NULL,
	[Inputquantity] int NULL,
	[ProductID] int NOT NULL,
	[UserID] int NOT NULL
)
GO

CREATE TABLE [Output]
(
	[OutputID] int NOT NULL IDENTITY (1, 1),
	[Outputdate] nvarchar(20) NULL,
	[Outputprice] decimal(30,2) NULL,
	[Outputquantity] int NULL,
	[ProductID] int NOT NULL,
	[UserID] int NOT NULL
)
GO

CREATE TABLE [Product]
(
	[ProductID] int NOT NULL IDENTITY (1, 1),
	[Productname] nvarchar(80) NULL,
	[Productcolor] nvarchar(80) NULL,
	[Productprice] decimal(10,2) NULL,
	[CategoryID] int NOT NULL,
	[Productquantity] int NULL
)
GO

CREATE TABLE [User]
(
	[UserID] int NOT NULL IDENTITY (1, 1),
	[Username] nvarchar(80) NULL,
	[Useremail] nvarchar(80) NULL,
	[Userpassword] nvarchar(80) NULL,
	[UserPhoto] varbinary(MAX) NULL,
)
GO

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE [Category] 
 ADD CONSTRAINT [PK_Category]
	PRIMARY KEY CLUSTERED ([CategoryID] ASC)
GO

ALTER TABLE [Input] 
 ADD CONSTRAINT [PK_Input]
	PRIMARY KEY CLUSTERED ([InputID] ASC)
GO

ALTER TABLE [Output] 
 ADD CONSTRAINT [PK_Output]
	PRIMARY KEY CLUSTERED ([OutputID] ASC)
GO

ALTER TABLE [Product] 
 ADD CONSTRAINT [PK_Product]
	PRIMARY KEY CLUSTERED ([ProductID] ASC)
GO

ALTER TABLE [User] 
 ADD CONSTRAINT [PK_User]
	PRIMARY KEY CLUSTERED ([UserID] ASC)
GO

/* Create Foreign Key Constraints */

ALTER TABLE [Input] ADD CONSTRAINT [FK_Input_Product]
	FOREIGN KEY ([ProductID]) REFERENCES [Product] ([ProductID]) ON DELETE No Action ON UPDATE No Action
GO

ALTER TABLE [Input] ADD CONSTRAINT [FK_Input_User]
	FOREIGN KEY ([UserID]) REFERENCES [User] ([UserID]) ON DELETE No Action ON UPDATE No Action
GO

ALTER TABLE [Output] ADD CONSTRAINT [FK_Output_Product]
	FOREIGN KEY ([ProductID]) REFERENCES [Product] ([ProductID]) ON DELETE No Action ON UPDATE No Action
GO

ALTER TABLE [Output] ADD CONSTRAINT [FK_Output_User]
	FOREIGN KEY ([UserID]) REFERENCES [User] ([UserID]) ON DELETE No Action ON UPDATE No Action
GO

ALTER TABLE [Product] ADD CONSTRAINT [FK_Product_Category]
	FOREIGN KEY ([CategoryID]) REFERENCES [Category] ([CategoryID]) ON DELETE No Action ON UPDATE No Action
GO

INSERT INTO ColorIdentifier
    VALUES (0)