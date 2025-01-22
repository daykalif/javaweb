-- ========================= 子查询 ================================
-- 标量子查询
-- -------------------- A. 查询 最早入职 的员工信息 --------------------

-- a.获取 最早入职 的员工的员工信息
select min(entry_date)
from emp;
-- b.获取到最早入职时间
select *
from emp
where entry_date = '2000-01-01';

-- --合并：-----标量子查询---------
select *
from emp
where entry_date = (select min(entry_date)
                    from emp);



-- -------------------- B. 查询在 "阮小五" 入职之后入职的员工信息 --------------------
-- a.查询 “阮小五” 的入职时间
select entry_date
from emp
where name = '阮小五';
-- b.查询在 该时间 之后入职的员工信息
select *
from emp
where entry_date > '2015-01-01';

-- ---合并：----表子查询---------
select *
from emp
where entry_date > (select entry_date
                    from emp
                    where name = '阮小五');

-- 列子查询
-- -------------------- A. 查询 "教研部" 和 "咨询部" 的所有员工信息 --------------------
-- a.查询 "教研部" 和 "咨询部" 的部门ID
select id
from dept
where name = '教研部'
   or name = '咨询部';

select id
from dept
where name in ('教研部', '咨询部');

-- b.查询指定部门ID的员工信息
select *
from emp
where dept_id in (2, 3);

-- ---合并：-------------
select *
from emp
where dept_id in (select id from dept where name in ('教研部', '咨询部'));


-- 行子查询
-- -------------------- A. 查询与 "李忠" 的薪资 及 职位都相同的员工信息 --------------------
-- a.获取 "李忠" 的薪资 及 职位
select salary, job
from emp
where name = '李忠';

-- b.查询指定薪资和职位的员工信息
select *
from emp
where salary = 5000
  and job = 5;

-- ---合并：-------------
select *
from emp
where salary = (select salary
                from emp
                where name = '李忠')
  and job = (select job
             from emp
             where name = '李忠');

-- 优化
select *
from emp
where (salary, job) = (select salary, job
                       from emp
                       where name = '李忠');


-- 表子查询
-- -------------------- A. 获取每个部门中薪资最高的员工信息 --------------------
-- a.获取每个部门的最高薪资
select dept_id, max(salary)
from emp
group by dept_id;

-- b.查询每个部门最高薪资对应的员工信息
select *
from emp e,
     (select dept_id, max(salary) as max_salary
      from emp
      group by dept_id) t
where e.dept_id = t.dept_id
  and e.salary = t.max_salary;

-- 优化：
select *
from emp
where (dept_id, salary) in (select dept_id, max(salary)
                            from emp
                            group by dept_id);


