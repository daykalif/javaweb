
-- ====================================== 案例 ===================================================================
-- 需求:
-- --------------------------- 1. 查询 "教研部" 性别为 男，且在 "2011-05-01" 之后入职的员工信息 。 ---------------------------
-- 表：dept，emp
select *
from emp
where dept_id = (select id from dept where name = '教研部')
  and gender = 1
  and entry_date > '2011-05-01';

-- 内连接
select e.*
from emp e,
     dept d
where e.dept_id = d.id
  and d.name = '教研部'
  and e.gender = 1
  and e.entry_date > '2011-05-01';


-- --------------------------- 2. 查询工资 低于公司平均工资的 且 性别为男 的员工信息 。 ---------------------------
-- 表：emp
-- a.查询 公司平均工资
select avg(salary)
from emp;

-- b.查询工资 低于公司平均工资的 且 性别为男 的员工信息 。
select *
from emp
where salary < (select avg(salary) from emp)
  and gender = 1;


-- --------------------------- 3. 查询部门人数超过 10 人的部门名称 。 ---------------------------
-- 表：dept，emp
select d.name, count(*)
from emp e,
     dept d
where d.id = e.dept_id
group by d.name
having count(*) > 10;


-- --------------------------- 4. 查询在 "2010-05-01" 后入职，且薪资高于 10000 的 "教研部" 员工信息，并根据薪资倒序排序。 ---------------------------
-- 表：dept，emp
-- 内连接
select *
from emp e,
     dept d
where e.dept_id = d.id
  and e.entry_date > '2010-05-01'
  and e.salary > 10000
  and d.name = '教研部'
order by e.salary desc;

-- --------------------------- 5. 查询工资 低于本部门平均工资的员工信息 。 ---------------------------
-- 5.1 查询每个部门的平均工资
select dept_id, avg(salary)
from emp
group by dept_id;

-- 5.2 查询工资 低于本部门平均工资的员工信息
select *
from emp e,
     (select dept_id, avg(salary) as avg_salary
      from emp
      group by dept_id) t
where e.dept_id = t.dept_id
  and e.salary < t.avg_salary;
