-- 创建满汉楼的数据库
CREATE DATABASE mhl;
-- 创建employee表（主键id,empId,name,pwd,job如果需要可以自己加字段等）
CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT,-- 自增
	empId VARCHAR(32) UNIQUE NOT NULL DEFAULT '', -- 员工号
	pwd CHAR(32) NOT NULL DEFAULT '', -- 密码md5
	NAME VARCHAR(50) NOT NULL DEFAULT '', -- 姓名
	job VARCHAR(50) NOT NULL DEFAULT '' -- 岗位
	)CHARSET=utf8;
	
DROP TABLE employee;
#添加测试数据
INSERT INTO employee VALUES(NULL,'6668612',MD5('123456'),'张三丰','经理');
INSERT INTO employee VALUES(NULL,'6668622',MD5('123456'),'小龙女','服务员');
INSERT INTO employee VALUES(NULL,'6668633',MD5('123456'),'张无忌','收银员');
INSERT INTO employee VALUES(NULL,'090909',MD5('123456'),'刘总','经理');

SELECT * FROM employee;
DESC employee;

-- 创建diningTable表（id，state，orderName，orderTel）
CREATE TABLE diningTable(
	id INT PRIMARY KEY AUTO_INCREMENT, #自增，表示餐桌号
	state VARCHAR(32) NOT NULL DEFAULT '',#餐桌的状态
	orderName VARCHAR(32) NOT NULL DEFAULT '',#预定人的名字
	orderTel VARCHAR(32) NOT NULL DEFAULT ''#预定人的联系方式
	)CHARSET utf8;
DROP TABLE diningTable;
#测试数据
INSERT INTO diningTable VALUES(NULL,'空','','');
INSERT INTO diningTable VALUES(NULL,'空','','');
INSERT INTO diningTable VALUES(NULL,'空','','');
SELECT * FROM diningTable;
UPDATE diningTable SET state='空',orderName='',orderTel='' WHERE id = 1;