-- 查询所有的员工信息，以及该员工归属的部门名称
-- （左外连接）
select e.*, d.name
from emp e
         left join dept d on e.dept_id = d.id;


