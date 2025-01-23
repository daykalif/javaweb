-- 查询（笛卡尔积）
select *
from emp,
     dept;

-- 查询内连接（消除无效的笛卡尔积）
select *
from emp,
     dept
where emp.dept_id = dept.id;


-- ============================= 内连接 ==========================
-- A. 查询所有员工的ID, 姓名 , 及所属的部门名称 (隐式、显式内连接实现，这两种方式效果是一样的)

-- 隐式
select emp.id,
       emp.name,
       dept.name
from emp,
     dept
where emp.dept_id = dept.id;


-- 显式
select emp.id,
       emp.name,
       dept.name
from emp
         inner join
     dept
     on emp.dept_id = dept.id;


-- 显式（inner关键字可以省略）
select emp.id,
       emp.name,
       dept.name
from emp
         join
     dept
     on emp.dept_id = dept.id;



-- B. 查询 性别为男, 且工资 高于8000 的员工的ID, 姓名, 及所属的部门名称 (隐式、显式内连接实现)

-- 隐式
select emp.id,
       emp.name,
       dept.name
from emp,
     dept
where emp.dept_id = dept.id
  and emp.gender = 1
  and emp.salary > 8000;


-- 显式
select emp.id,
       emp.name,
       dept.name
from emp
         inner join
     dept
     on emp.dept_id = dept.id
where emp.gender = 1
  and emp.salary > 8000;


-- 显式（inner关键字可以省略）
select emp.id,
       emp.name,
       dept.name
from emp
         join
     dept
     on emp.dept_id = dept.id
where emp.gender = 1
  and emp.salary > 8000;


-- 为表起别名
select e.id,
       e.name,
       d.name
from emp as e
         join
     dept as d
     on e.dept_id = d.id
where e.gender = 1
  and e.salary > 8000;
