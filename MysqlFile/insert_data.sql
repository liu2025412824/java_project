CREATE TABLE student(
	id INT NOT NULL DEFAULT 1,
	`name` VARCHAR(20) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0);
	
INSERT INTO student(id,`name`,chinese,english,math) VALUES(1,'韩顺平',89,78,90);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(2,'张飞',67,98,56);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(3,'宋江',87,78,77);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(4,'关羽',88,98,90);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(5,'赵云',82,64,67);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(6,'欧阳锋',55,85,45);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(7,'黄蓉',75,65,30);

SELECT * FROM student;


-- 部门表
CREATE TABLE dept(
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
	dname VARCHAR(20) NOT NULL DEFAULT '',
	loc VARCHAR(13) NOT NULL DEFAULT '');
INSERT INTO dept VALUES(10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),
	(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');
	
-- 创建EMP雇员
CREATE TABLE emp(
	empno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*编号*/
	ename VARCHAR(20) NOT NULL DEFAULT '',/*名字*/
	job VARCHAR(9) NOT NULL DEFAULT '',/*工作*/
	mgr MEDIUMINT UNSIGNED,/*上级编号*/
	hiredate DATE NOT NULL,/*入职时间*/
	sal DECIMAL(7,2) NOT NULL,/*薪水*/
	comm DECIMAL(7,2),/*红利*/
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0);/*部门编号*/
	
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800.00,NULL,20);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7521, 'WARD', 'SALESMAN', 7698, '1981-2-22', 1250, 500, 30);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7566, 'JONES', 'MANAGER', 7839, '1981-4-2', 2975, NULL, 20);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7654, 'MARTIN', 'SALESMAN', 7698, '1981-9-28', 1250, 1400, 30);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7698, 'BLAKE', 'MANAGER', 7839, '1981-5-1', 2850, NULL, 30);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7782, 'CLARK', 'MANAGER', 7839, '1981-6-9', 2450, NULL, 10);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7788, 'SCOTT', 'ANALYST', 7566, '1987-4-19', 3000, NULL, 20);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7844, 'TURNER', 'SALESMAN', 7698, '1981-9-8', 1500, 0, 30);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-5-23', 1100, NULL, 20);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-3', 950, NULL, 30);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( 7902, 'FORD', 'ANALYST', 7566, '1981-12-3', 3000, NULL, 20);
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-1-23', 1300, NULL, 10);

SELECT * FROM emp;

-- 工资级别表
CREATE TABLE salgrade(
	grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*工资级别*/
	losal DECIMAL(17,2) NOT NULL,/*该级别的最低工资*/
	hisal DECIMAL(17,2) NOT NULL);/*该级别的最高工资*/
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);

SELECT * FROM salgrade;

-- 创建测试表 演员表
CREATE TABLE actor(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(32) NOT NULL DEFAULT '',
	sex CHAR(1) NOT NULL DEFAULT '女',
	borndate DATETIME,
	phone VARCHAR(12));
	
INSERT INTO actor VALUES(NULL,'马德华','男','1990-12-21','12307');
INSERT INTO actor VALUES(NULL,'张白嫖','女','1998-11-25','12308');

SELECT * FROM actor;

-- 创建表测试sql注入问题
CREATE TABLE admin(
	NAME VARCHAR(32) NOT NULL UNIQUE,
	pwd VARCHAR(32) NOT NULL DEFAULT '') CHARACTER SET utf8;
INSERT INTO admin VALUES('tom','123');
INSERT INTO admin VALUES('jack','1234');
SELECT * FROM admin WHERE `name`='1' OR' and pwd='OR '1'='1';

-- 创建测试表，用于演示事务
CREATE TABLE ACCOUNT(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(32) NOT NULL DEFAULT '',
	balance DOUBLE NOT NULL DEFAULT 0) CHARACTER SET utf8;
INSERT INTO ACCOUNT VALUES(NULL,'马云',3000);
INSERT INTO ACCOUNT VALUES(NULL,'马化腾',10000);
SELECT * FROM ACCOUNT;

-- 创建测试表，用于演示批处理
CREATE TABLE admin2(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(32) NOT NULL,
	`password` VARCHAR(32) NOT NULL);
	
SELECT COUNT(*) FROM admin2;
DROP TABLE admin2;