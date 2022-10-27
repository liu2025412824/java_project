#insert语句
CREATE TABLE goods (
	id INT,
	good_name VARCHAR(10),
	price DOUBLE);
-- 添加数据
INSERT INTO goods (id,good_name,price) VALUES (1,'芒果',23);
INSERT INTO goods (id,good_name,price) VALUES (2,'菠萝',33);
SELECT * FROM goods;
INSERT INTO goods (id,good_name,price) VALUES (3,'香蕉',34),(4,'苹果',17);

DROP TABLE good;
	
	
#update语句
SELECT * FROM employee;
INSERT INTO employee VALUES 
	(200,'李四','2012-11-11','2012-10-10 10:10:09','搓澡的',5000,'给大王搓澡','e:\\javafiletest');
UPDATE employee SET salary = 4000;

UPDATE employee SET salary=3000 WHERE user_name='张三';

UPDATE employee SET salary=salary+2000 WHERE user_name='李四';


#delete语句
DELETE FROM goods WHERE good_name='苹果';
SELECT * FROM goods;
DELETE FROM goods;

UPDATE goods SET price=NULL;


#select语句[重点 难点]
SELECT * FROM student;
SELECT `name` ,english FROM student;
SELECT DISTINCT english FROM student;
SELECT DISTINCT `name`,english FROM student;

SELECT `name` , (chinese+english+math) FROM student;
SELECT `name` , (chinese+english+math+10) FROM student;
SELECT `name` AS '名字' ,(chinese+english+math) AS 'total_game' FROM student;

SELECT * FROM student WHERE `name` = '赵云';
SELECT * FROM student WHERE english>90;
SELECT `name` FROM student WHERE english>90;
SELECT * FROM student WHERE (chinese+english+math)>200 AND math<chinese AND `name` LIKE '赵%';
SELECT * FROM student WHERE english>=80 AND english <=90;
SELECT * FROM student WHERE english BETWEEN 80 AND 90;
SELECT * FROM student WHERE math=89 OR math=90 OR math=91;
SELECT * FROM student WHERE math IN (89,90,91);
SELECT * FROM student WHERE `name` LIKE '张%' OR `name` LIKE '宋%';
SELECT * FROM student WHERE english-30 >= chinese;

-- order by的使用
SELECT `name`,(chinese+english+math) AS total_name FROM student ORDER BY total_name DESC;
SELECT * FROM student ORDER BY (chinese+english+math) DESC;

#count统计函数
SELECT COUNT(*) FROM student;
SELECT COUNT(*) FROM student WHERE math>85;

#sum统计函数
SELECT SUM(math) FROM student;
SELECT SUM(math) AS math_taotal,SUM(english),SUM(chinese) FROM student;
-- 统计一个班语文成绩平均分
SELECT SUM(chinese)/COUNT(*) FROM student;

#avg合计函数
SELECT AVG(math) FROM student;
SELECT AVG(math+chinese+english) FROM student;

#max和min的使用
SELECT MAX(chinese+math+english),MIN(chinese+math+english) FROM student;
SELECT MAX(math) AS math_high_score,MIN(math) AS math_low_score FROM student;


#group by的使用
-- 显示每个部门的平均工资和最高工资
SELECT AVG(sal),MAX(sal),deptno FROM emp GROUP BY deptno;
-- 显示每个部门的每种岗位的平均工资和最低工资
SELECT AVG(sal),MIN(sal),deptno,job FROM emp GROUP BY deptno,job;
-- 显示平均工资低于2000的部门号和它的平均工资
-- 1.显示各个部门的平均工资和部门号，2.在1的基础上进行过滤，保留avg(sal)<2000
-- 使用别名进行过滤
SELECT AVG(sal),deptno FROM emp GROUP BY deptno HAVING AVG(sal)<2000;
SELECT AVG(sal) AS sal_avg ,deptno FROM emp GROUP BY deptno HAVING sal_avg<2000;/*效率更高*/

#字符串相关函数的使用
SELECT CHARSET(ename) FROM emp;
SELECT CONCAT(ename,' 工作是 ',job) FROM emp;
SELECT INSTR('hanshunping','ping') FROM DUAL;
SELECT LCASE (ename) FROM emp;
SELECT LEFT(ename,3) FROM emp;
SELECT LENGTH(ename) FROM emp;
SELECT ename,REPLACE(job,'MANAGER','经理') FROM emp;
SELECT STRCMP('hsp','ksp') FROM DUAL;
SELECT SUBSTRING(ename,2,3) FROM emp;
SELECT LTRIM(' hello') FROM DUAL;
SELECT TRIM('   hello   ')FROM DUAL;

-- 字符串函数练习
SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)),SUBSTRING(ename,2)) AS new_name FROM emp;
SELECT CONCAT(LCASE(LEFT(ename,1)),SUBSTRING(ename,2)) AS new_name FROM emp;


#数学相关函数的使用
SELECT ABS(-2.13) FROM DUAL;
SELECT BIN(10) FROM DUAL;
SELECT CEILING(-1.1) FROM DUAL;
SELECT CONV(8,10,2) FROM DUAL;
SELECT FLOOR(-1.1) FROM DUAL;
SELECT FORMAT(78.126234,2) FROM DUAL;
SELECT LEAST(0,-1,5,10) FROM DUAL;
SELECT MOD(10,3) FROM DUAL;
SELECT RAND() FROM DUAL;
SELECT FORMAT(RAND(),2)*100 FROM DUAL;


#日期时间相关函数
SELECT CURRENT_DATE() FROM DUAL;
SELECT CURRENT_TIME() FROM DUAL;
SELECT CURRENT_TIMESTAMP() FROM DUAL;

-- 创建测试表
CREATE TABLE mes (id INT,content VARCHAR(30),send_time DATETIME);
INSERT INTO mes VALUES(1,'北京新闻',CURRENT_TIMESTAMP());
INSERT INTO mes VALUES(2,'广州新闻',NOW());
SELECT * FROM mes;

SELECT id,content,DATE(send_time) FROM mes;/*只显示日期，不显时间*/
-- 查询在10分钟内发布的新闻
SELECT * FROM mes WHERE DATE_ADD(send_time,INTERVAL 10 MINUTE) >= NOW();
SELECT * FROM mes WHERE DATE_SUB(NOW(),INTERVAL 10 MINUTE) <= send_time;
-- 求相差多少天
SELECT DATEDIFF('2011-11-11','1990-01-01') FROM DUAL;
-- 假设能活到80岁，求现在还能活多少天[练习] 2001-01-01
SELECT DATEDIFF(DATE_ADD('2001-01-01',INTERVAL 80 YEAR),NOW()) FROM DUAL;

SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
SELECT UNIX_TIMESTAMP() FROM DUAL;
SELECT FROM_UNIXTIME(1665802278,'%Y-%m-%d %H:%i:%s') FROM DUAL;


#加密和系统函数
SELECT USER() FROM DUAL;
SELECT DATABASE();
SELECT MD5('0000') FROM DUAL;
SELECT LENGTH(MD5('0000')) FROM DUAL;
-- 演示用户表存，放密码时，是md5
CREATE TABLE lzy_user(id INT,`name` VARCHAR(32) NOT NULL DEFAULT '',
	pwd CHAR(32) NOT NULL DEFAULT '');
INSERT INTO lzy_user VALUES(100,'刘志远',MD5('0000'));
SELECT * FROM lzy_user;
SELECT * FROM lzy_user WHERE `name`='刘志远' AND pwd = MD5('0000');
SELECT PASSWORD('0000') FROM DUAL;
SELECT * FROM mysql.user;


#流程控制函数
SELECT IF(TRUE,'北京','上海') FROM DUAL;
SELECT IFNULL(NULL,'hello') FROM DUAL;
SELECT CASE WHEN TRUE THEN 'a' WHEN FALSE THEN 'b' ELSE 'c' END;
-- 查询emp表
SELECT ename,IF(comm IS NULL,0.0,comm) FROM emp;
SELECT ename,IFNULL(comm,0.0) FROM emp;
/*CASE前有无SELECT都行*/
SELECT ename,(CASE WHEN job='CLERK' THEN '职员' WHEN job='MANAGER' THEN '经理' 
	WHEN job='SALESMAN' THEN '销售人员' ELSE job END) AS job FROM emp;


#查询加强
SELECT * FROM emp WHERE hiredate < '1992-01-01';
SELECT ename,sal FROM emp WHERE ename LIKE 'S%';
SELECT ename,sal FROM emp WHERE ename LIKE '__O%';
SELECT * FROM emp WHERE mgr IS NULL;
SELECT * FROM emp ORDER BY deptno ASC ,sal DESC;

#分页查询
SELECT * FROM emp ORDER BY empno LIMIT 0,3;
SELECT * FROM emp ORDER BY empno LIMIT 3,3;
SELECT * FROM emp ORDER BY empno LIMIT 6,3;


#增强group by的使用
SELECT COUNT(*),AVG(sal),job FROM emp GROUP BY job;
SELECT COUNT(*),COUNT(comm) FROM emp;
SELECT COUNT(*),COUNT(IF(comm IS NULL,1,NULL)) FROM emp;
SELECT COUNT(*),COUNT(*)-COUNT(comm) FROM emp;
SELECT COUNT(DISTINCT mgr) FROM emp;
SELECT MAX(sal)-MIN(sal) FROM emp;

#多子句查询
SELECT AVG(sal) AS avg_sal,deptno FROM emp
	GROUP BY deptno HAVING avg_sal>1000 ORDER BY avg_sal DESC LIMIT 0,2
	
	
#多表查询
SELECT * FROM emp,dept WHERE emp.deptno = dept.deptno;
SELECT ename,sal,dname,emp.deptno FROM emp,dept WHERE emp.deptno = dept.deptno;
SELECT * FROM emp,salgrade;
SELECT ename,sal,grade FROM emp,salgrade WHERE sal BETWEEN losal AND hisal;
SELECT ename,sal,dname FROM emp,dept WHERE emp.deptno=dept.deptno ORDER BY emp.deptno DESC;

-- 多表查询的自连接
SELECT worker.ename AS '职员名',boss.ename AS '上级名' FROM emp worker,emp boss 
	WHERE worker.mgr = boss.empno;
	
#子查询
SELECT * FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='SMITH');
SELECT ename,job,sal,deptno FROM emp WHERE 
	job IN(SELECT DISTINCT job FROM emp WHERE deptno=10)
	AND deptno != 10; /* != 也可以写成 <> */

#all和any的使用
-- all
SELECT ename,sal,deptno FROM emp WHERE 
	sal>ALL(SELECT sal FROM emp WHERE deptno =30);
SELECT ename,sal,deptno FROM emp WHERE
	sal>(SELECT MAX(sal) FROM emp WHERE deptno=30);
-- any
SELECT ename,sal,deptno FROM emp WHERE
	sal>ANY(SELECT sal FROM emp WHERE deptno = 30);
SELECT ename,sal,deptno FROM emp WHERE
	sal>(SELECT MIN(sal) FROM emp WHERE deptno = 30);
	
#多列子查询
SELECT * FROM emp WHERE 
	(deptno,job)=(SELECT deptno,job FROM emp WHERE ename = 'ALLEN')
	AND ename != 'ALLEN';
-- 子查询练习
SELECT deptno,AVG(sal) FROM emp GROUP BY deptno;	
SELECT ename,sal,temp.avg_sal,emp.deptno 
	FROM emp,(SELECT deptno,AVG(sal) AS avg_sal FROM emp GROUP BY deptno) temp 
	WHERE emp.deptno = temp.deptno AND emp.sal > temp.avg_sal
	
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;
SELECT dname,dept.deptno,loc,per_num AS '人数'
	FROM dept,(SELECT deptno,COUNT(*) AS per_num FROM emp GROUP BY deptno) tmp
	WHERE dept.deptno = tmp.deptno;
-- 另一种写法
SELECT tmp.*,dname,per_num AS '人数'
	FROM dept,(SELECT deptno,COUNT(*) AS per_num FROM emp GROUP BY deptno) tmp
	WHERE dept.deptno = tmp.deptno;
	
 
#表复制
CREATE TABLE my_tab01 (id INT,`name` VARCHAR(32),sal DOUBLE,job VARCHAR(32),deptno INT);
DESC my_tab01;
SELECT * FROM my_tab01;
-- 先把emp表的记录复制到my_tab01
INSERT INTO my_tab01 (id,`name`,sal,job,deptno)
	SELECT empno,ename,sal,job,deptno FROM emp;
-- 自我复制
INSERT INTO my_tab01 SELECT * FROM my_tab01;
SELECT COUNT(*) FROM my_tab01;

-- 如何删除掉一张表的重复记录
CREATE TABLE my_tab02 LIKE emp;
INSERT INTO my_tab02 SELECT * FROM emp; /*插入两次*/
SELECT * FROM my_tab02;
CREATE TABLE my_tmp LIKE my_tab02;
INSERT INTO my_tmp SELECT DISTINCT * FROM my_tab02;
DELETE FROM my_tab02;
INSERT INTO my_tab02 SELECT * FROM my_tmp;
DROP TABLE my_tmp;
SELECT * FROM my_tab02;、

#合并查询
-- union all不会去重
SELECT ename,sal,job FROM emp WHERE sal>2500
UNION ALL
SELECT ename,sal,job FROM emp WHERE job='MANAGER';
-- union 去重
SELECT ename,sal,job FROM emp WHERE sal>2500
UNION
SELECT ename,sal,job FROM emp WHERE job='MANAGER';

#外连接
-- 左连接
SELECT dname,ename,job FROM dept LEFT JOIN emp
	ON dept.deptno = emp.deptno;
-- 右连接
SELECT dname,ename,job FROM emp RIGHT JOIN dept
	ON emp.deptno = dept.deptno;
	
#约束
-- 主键
CREATE TABLE t6(id INT PRIMARY KEY,`name` VARCHAR(32),email VARCHAR(32));
INSERT INTO t6 VALUES(1,'tom','tom@qq.com');
INSERT INTO t6 VALUES(1,'jack','jack@qq.com');
CREATE TABLE t7(id INT,`name` VARCHAR(32),email VARCHAR(32),PRIMARY KEY(id,`name`));
INSERT INTO t7 VALUES(1,'tom','tom@qq.com');
INSERT INTO t7 VALUES(1,'jack','jack@qq.com');
SELECT * FROM t7;
DESC t7;

-- 外键
-- 创建主表
CREATE TABLE my_class(id INT PRIMARY KEY, -- 班级编号
	`name` VARCHAR(32) NOT NULL DEFAULT '');
-- 创建从表
CREATE TABLE my_stu(id INT PRIMARY KEY, -- 学生编号
	`name` VARCHAR(32) NOT NULL DEFAULT '',class_id INT, -- 学生所在班级编号
	FOREIGN KEY(class_id) REFERENCES my_class(id)); -- 指定外键关系
-- 测试数据
INSERT INTO my_class VALUES(100,'java'),(200,'web');
INSERT INTO my_stu VALUES(1,'tom',100),(2,'jack',200);
INSERT INTO my_stu VALUES(3,'lzy',300) -- 这里会失败，因为300班级不存在
INSERT INTO my_stu VALUES(4,'king',NULL) -- 可以，外键没有写not null
SELECT * FROM my_class;
SELECT * FROM my_stu;

-- check mysql5.7只做语法校验，不会生效
CREATE TABLE t8 (id INT PRIMARY KEY,`name` VARCHAR(32),
	sex VARCHAR(6) CHECK(sex IN ('man','woman')),
	sal DOUBLE CHECK(sal > 1000 AND sal < 2000));


#自增长
CREATE TABLE t8 (id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(32) NOT NULL DEFAULT '',`name` VARCHAR(32) NOT NULL DEFAULT '');
	
DESC t8;
INSERT INTO t8 VALUES(NULL,'jack@qq.com','jack');
INSERT INTO t8 (email,`name`) VALUE('tom@qq.com','tom');
SELECT * FROM t8;


#索引
CREATE TABLE t9(id INT,`name` VARCHAR(32));-- ---
CREATE UNIQUE INDEX id_index ON t9(id);
CREATE INDEX id_index ON t9(id);
ALTER TABLE t9 ADD INDEX id_index (id);
CREATE TABLE t10(id INT,`name` VARCHAR(32));-- ---
ALTER TABLE t10 ADD PRIMARY KEY (id);
DROP INDEX id_index ON t9;
ALTER TABLE t9 DROP INDEX id_index;
ALTER TABLE t10 DROP PRIMARY KEY;
SHOW INDEX FROM t9;
SHOW KEYS FROM t10;


#事务
CREATE TABLE t11(id INT,`name` VARCHAR(32));
-- 开始事务
START TRANSACTION;
-- 设置保存点a
SAVEPOINT a;

-- 执行dml操作
INSERT INTO t11 VALUES(100,'tom');
SELECT * FROM t11;
SAVEPOINT b;

-- 执行dml操作
INSERT INTO t11 VALUES(200,'jack');

-- 回退到b
ROLLBACK TO b;
-- 继续回退到a
ROLLBACK TO a;


#视图
CREATE VIEW emp_view01 AS SELECT empno,ename,job,deptno FROM emp;
DESC emp_view01;
SHOW CREATE VIEW emp_view01;
DROP VIEW emp_view01;
CREATE VIEW emp_view02 AS SELECT empno,ename FROM emp_view01;

-- 视图应用实例
CREATE VIEW emp_view03 AS
	SELECT empno,ename,dname,grade FROM emp,dept,salgrade
	WHERE emp.deptno=dept.deptno AND (sal BETWEEN losal AND hisal);
DESC emp_view03;
SELECT * FROM emp_view03;


#用户管理
CREATE USER 'u1'@'localhost' IDENTIFIED BY '0001';
DROP USER 'u1'@'localhost';
SET PASSWORD = PASSWORD('0001');
SET PASSWORD FOR 'u1'@'localhost' = PASSWORD('0001');
SELECT * FROM mysql.user;

-- 用户管理练习题
-- 创建用户zhiyuan 密码0000 ，从本地登录
CREATE USER 'zhiyuan'@'localhost' IDENTIFIED BY '0000';
-- 使用root 用户创建testdb，表news
CREATE DATABASE testdb;
CREATE TABLE news(id INT,content VARCHAR(32));
-- 添加一条数据
INSERT INTO news VALUES(100,'北京新闻');
SELECT * FROM news;
-- 给zhiyuan分配查看news表和添加news的权限
GRANT SELECT,INSERT ON testdb.news TO 'zhiyuan'@'localhost';
-- 可以增加update权限
GRANT UPDATE ON testdb.news TO 'zhiyuan'@'localhost';
-- 回收zhiyuan用户在testdb.news的所有权限
REVOKE SELECT,INSERT,UPDATE ON testdb.news FROM 'zhiyuan'@'localhost';
REVOKE ALL ON testdb.news FROM 'zhiyuan'@'localhost';
-- 删除zhiyuan
DROP USER 'zhiyuan'@'localhost';


#数据库练习题
-- 1
SELECT * FROM emp;
SELECT dname FROM dept;
SELECT ename,(sal+IFNULL(comm,0))*13 AS '年收入' FROM emp;  -- 注意comm要用ifnull，否则年薪也为null
SELECT ename,sal FROM emp WHERE sal>2850;
SELECT ename,sal FROM emp WHERE !(sal>=1500 AND sal<=2850);
SELECT ename,deptno FROM emp WHERE empno=7566;
SELECT ename,sal FROM emp WHERE sal>1500 AND (deptno=10 OR deptno=30);
SELECT ename,job FROM emp WHERE mgr IS NULL;
SELECT ename,job,hiredate FROM emp WHERE hiredate>='1981-02-01' AND hiredate<='1985-05-01' ORDER BY hiredate;

-- 2
SELECT * FROM emp WHERE IFNULL(comm,0)>sal;
SELECT DISTINCT job FROM emp WHERE comm IS NOT NULL;
SELECT * FROM emp WHERE comm IS NULL OR IFNULL(comm,0)<100;
SELECT * FROM emp WHERE LAST_DAY(hiredate)-2 = hiredate;
SELECT * FROM emp WHERE DATE_ADD(hiredate,INTERVAL 12 YEAR) < NOW();
SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)),SUBSTRING(ename,2)) FROM emp;
SELECT * FROM emp WHERE LENGTH(ename) = 5;
SELECT * FROM emp WHERE ename LIKE '_____';

-- 3
SELECT * FROM emp WHERE ename NOT LIKE '%R%';
SELECT LEFT(ename,3) FROM emp;
SELECT REPLACE(ename,'A','a') FROM emp;
SELECT ename,hiredate FROM emp WHERE DATE_ADD(hiredate,INTERVAL 10 YEAR) < NOW();
SELECT ename,hiredate FROM emp ORDER BY hiredate ASC;
SELECT ename,job,sal FROM emp ORDER BY job DESC,sal;
SELECT ename,CONCAT(YEAR(hiredate),'-',MONTH(hiredate)) FROM emp ORDER BY MONTH(hiredate),YEAR(hiredate);
SELECT ename,FLOOR(sal/30),sal/30 FROM emp; -- 忽略余数，向下取整
SELECT * FROM emp WHERE MONTH(hiredate) = 2;
SELECT ename,DATEDIFF(NOW(),hiredate) FROM emp;
SELECT ename,FROM_DAYS(DATEDIFF(NOW(),hiredate)) FROM emp;

-- 4
SELECT COUNT(*) AS c,deptno FROM emp GROUP BY deptno HAVING c>=1;
SELECT * FROM emp WHERE sal > (
	SELECT sal FROM emp WHERE ename='SMITH');
SELECT worker.ename AS '员工名',worker.hiredate AS "员工入职时间",
	leader.ename AS '上级名',leader.hiredate AS '上级入职时间'
	FROM emp worker,emp leader WHERE
	worker.hiredate > leader.hiredate AND worker.mgr=leader.empno;
SELECT dname,emp.* FROM dept LEFT JOIN emp ON dept.deptno = emp.deptno;
SELECT MIN(sal),job FROM emp GROUP BY job HAVING MIN(sal)>1500;
SELECT ename,dname FROM emp,dept WHERE emp.deptno=dept.deptno AND dname='SALES';
SELECT * FROM emp WHERE sal > (SELECT AVG(sal) FROM emp);

-- 5
SELECT * FROM emp WHERE job = (SELECT job FROM emp WHERE ename='SCOTT');
SELECT ename,sal FROM emp WHERE 
	sal > (SELECT MAX(sal) FROM emp WHERE deptno=30);
SELECT COUNT(*) AS '员工数量',AVG(sal) AS '平均工资',
	AVG(DATEDIFF(NOW(),hiredate)) AS '平均服务期限',deptno FROM emp GROUP BY deptno;
SELECT dept.*,tmp.c AS '部门人数'
	FROM dept,(SELECT COUNT(*) AS c,deptno FROM emp GROUP BY emp.deptno) tmp
	WHERE dept.deptno = tmp.deptno;
SELECT dept.*,tmp.c AS '部门人数'
	FROM dept LEFT JOIN (SELECT COUNT(*) AS c,deptno FROM emp GROUP BY emp.deptno) tmp
	ON dept.deptno = tmp.deptno;
SELECT MIN(sal),job FROM emp GROUP BY job;
SELECT MIN(sal) FROM emp WHERE job='MANAGER';
SELECT ename,(sal+IFNULL(comm,0))*13 AS year_sal FROM emp ORDER BY year_sal;