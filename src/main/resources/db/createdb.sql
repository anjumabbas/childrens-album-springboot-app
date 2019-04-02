use master
create database CHILD_PICS
create login child_pics_login with password = 'childpics', default_database=CHILD_PICS, CHECK_POLICY = OFF

Go
use CHILD_PICS
create user child_pics_login for login child_pics_login with default_schema = DBO

alter role [db_owner] add member child_pics_login