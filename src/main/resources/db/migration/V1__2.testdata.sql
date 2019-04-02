USE [CHILD_PICS]
GO

SET IDENTITY_INSERT dbo.child ON

INSERT INTO dbo.child (pk, dob, gender, last_updated, name)
     VALUES (1, '2015-01-07T00:00:00.0000000', 'Male', '2019-04-01T00:00:00.0000000','Ali')
INSERT INTO dbo.child (pk, dob, gender, last_updated, name)
     VALUES (2, '2017-01-07T00:00:00.0000000', 'Female', '2019-04-01T00:00:00.0000000','Zara')

SET IDENTITY_INSERT dbo.child OFF
SET IDENTITY_INSERT dbo.picture ON

INSERT INTO dbo.picture (pk, child_fk, filename, geo_coordinates, last_updated, child_age)
     VALUES (1, 1, 'C:/temp/aliBaby.jpg', '60, 80', '2019-04-01T00:00:00.0000000', 1)
INSERT INTO dbo.picture (pk, child_fk, filename, geo_coordinates, last_updated, child_age)
     VALUES (2, 1, 'C:/temp/aliInfant.jpg', '60, 80', '2019-04-01T00:00:00.0000000', 3)
INSERT INTO dbo.picture (pk, child_fk, filename, geo_coordinates, last_updated, child_age)
     VALUES (3, 2, 'C:/temp/zaraBaby.jpg', '60, 80', '2019-04-01T00:00:00.0000000', 1)
INSERT INTO dbo.picture (pk, child_fk, filename, geo_coordinates, last_updated, child_age)
     VALUES (4, 2, 'C:/temp/zaraToddler.jpg', '60, 80', '2019-04-01T00:00:00.0000000', 2)
INSERT INTO dbo.picture (pk, child_fk, filename, geo_coordinates, last_updated, child_age)
     VALUES (5, 2, 'C:/temp/zaraInfant.png', '60, 80', '2019-04-01T00:00:00.0000000', 3)

SET IDENTITY_INSERT dbo.picture OFF
GO