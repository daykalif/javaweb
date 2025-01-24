-- ========================================== 准备工作 ===========================================================================
-- --------------------------------------查询所有的员工信息，以及该员工归属的部门名称--------------------------------------
-- （左外连接）
select e.*, d.name
from emp e
         left join dept d on e.dept_id = d.id;


-- ======================================= 分页查询 ==============================================================================
-- --------------------------------------原始方式--------------------------------------
-- limit 起始索引，每页展示记录数
-- 查询第 page 页数据，每页展示 pageSize 条
-- 起始索引 = (page - 1) * pageSize

-- 查询第1页数据，每页展示5条
select e.*, d.name
from emp e
         left join dept d on e.dept_id = d.id limit 0, 5;

-- 查询第2页数据，每页展示5条
select e.*, d.name
from emp e
         left join dept d on e.dept_id = d.id limit 5, 5;

-- 查询第3页数据，每页展示5条
select e.*, d.name
from emp e
         left join dept d on e.dept_id = d.id limit 10, 5;

-- 查询总记录数
select count(*)
from emp e
         left join dept d on e.dept_id = d.id;


-- -------------------------------------- 条件查询 --------------------------------------
select e.*, d.name deptName
from emp e
         left join dept d on e.dept_id = d.id
where e.name like '%阮%' # 根据姓名模糊查询
  and e.gender = 1                                       # 根据性别进行精确查询
  and e.entry_date between '2010-01-01' and '2020-01-01' # 根据入职日期进行范围查询
order by e.update_time desc;

