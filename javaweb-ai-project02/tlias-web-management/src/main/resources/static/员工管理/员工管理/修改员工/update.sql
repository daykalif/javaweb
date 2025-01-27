-- 根据ID查询员工基本信息(emp)及员工工作经历信息(emp_expr)
-- 外连接（包含左表的信息，即使没有右表的信息，也会查询出来）
select e.*,
       ee.id      ee_id,
       #          给emp_expr表的属性起别名 ee.emp_id  ee_empid, ee.begin ee_begin,
       ee.end     ee_end,
       ee.company ee_company,
       ee.job     ee_job
from emp e
         left join emp_expr ee on e.id = ee.emp_id
where e.id = 40;