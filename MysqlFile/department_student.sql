#综合练习

-- 1.创建表
CREATE TABLE DEPARTMENT(
	departmentid VARCHAR(32) PRIMARY KEY,
	deptname VARCHAR(32) UNIQUE NOT NULL);
	
CREATE TABLE class(
	classid INT PRIMARY KEY,
	`subject` VARCHAR(32) NOT NULL DEFAULT '',
	deptname VARCHAR(32), -- 外键字段
	enrolltime INT NOT NULL DEFAULT 2000,
	num INT NOT NULL DEFAULT 0,
	FOREIGN KEY (deptname) REFERENCES DEPARTMENT(deptname));

CREATE TABLE lzy_student(
	studentid INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	age INT NOT NULL DEFAULT 0,
	classid INT, -- 外键
	FOREIGN KEY(classid) REFERENCES class(classid));
	
INSERT INTO DEPARTMENT VALUES('001','数学');
INSERT INTO DEPARTMENT VALUES('002','计算机');
INSERT INTO DEPARTMENT VALUES('003','化学');
INSERT INTO DEPARTMENT VALUES('004','中文');
INSERT INTO DEPARTMENT VALUES('005','经济');

INSERT INTO class VALUES(101,'软件','计算机',1995,20);
INSERT INTO class VALUES(102,'微电子','计算机',1996,30);
INSERT INTO class VALUES(111,'无机化学','化学',1995,29);
INSERT INTO class VALUES(112,'高分子化学','化学',1996,25);
INSERT INTO class VALUES(121,'统计化学','数学',1995,20);
INSERT INTO class VALUES(131,'现代语言','中文',1996,20);
INSERT INTO class VALUES(141,'国际贸易','经济',1997,30);
INSERT INTO class VALUES(142,'国际金融','经济',1996,14);

INSERT INTO lzy_student VALUES(8101,'张三',18,101);
INSERT INTO lzy_student VALUES(8102,'钱四',16,121);
INSERT INTO lzy_student VALUES(8103,'王玲',17,131);
INSERT INTO lzy_student VALUES(8105,'李飞',19,102);
INSERT INTO lzy_student VALUES(8109,'赵四',18,141);
INSERT INTO lzy_student VALUES(8110,'李可',20,142);
INSERT INTO lzy_student VALUES(8201,'张飞',18,111);
INSERT INTO lzy_student VALUES(8302,'周瑜',16,112);
INSERT INTO lzy_student VALUES(8203,'王亮',17,101);
INSERT INTO lzy_student VALUES(8305,'董庆',19,102);
INSERT INTO lzy_student VALUES(8409,'赵龙',18,101);

SELECT * FROM department;
SELECT * FROM class;
SELECT * FROM lzy_student;

SELECT * FROM lzy_student WHERE `name` LIKE '李%';
SELECT COUNT(*) AS nums,deptname FROM class GROUP BY deptname HAVING nums>1;
SELECT SUM(num) AS nums,deptname FROM class GROUP BY deptname HAVING nums>=30;
SELECT tmp.*,department.departmentid 
	FROM department,(SELECT SUM(num) AS nums,deptname FROM class GROUP BY deptname HAVING nums>=30) tmp
	WHERE department.deptname = tmp.deptname;
	
INSERT INTO department VALUES('006','物理系');

-- 开始事务
START TRANSACTION;
-- 张三所在班级的人数-1
UPDATE class SET num = num-1 
	WHERE classid = (SELECT classid FROM lzy_student WHERE `name`='张三');
-- 删除张三
DELETE FROM lzy_student WHERE `name`='张三';
-- 提交事务
COMMIT;

SELECT * FROM class;
SELECT * FROM lzy_student;