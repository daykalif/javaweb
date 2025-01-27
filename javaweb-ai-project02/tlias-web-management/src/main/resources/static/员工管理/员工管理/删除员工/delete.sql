-- 删除员工
delete
from emp
where id in (1, 2, 3);

delete
from emp_expr
where emp_id in (1, 2, 3);
