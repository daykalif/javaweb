-- ----------------------------------------员工信息统计----------------------------------------------------------------------------
-- 统计每一种职位对应的人数
select job, count(*)
from emp
group by job;


-- case函数：根据条件进行分组；case 表达式 when 值 then 结果 [when 值 then 结果] [else 结果] end

-- 方式一：只适用于等值匹配，如果是范围匹配就不适用了
select (case job
            when 1 then '班主任'
            when 2 then '讲师'
            when 3 then '学工主管'
            when 4 then '教研主管'
            when 5 then '咨询师'
            else '其他' end) pos,
       count(*)              num
from emp
group by job
order by num;

-- 或者

-- 方式二：适用等值匹配，也适用于范围匹配
select case
           when job = 1 then '班主任'
           when job = 2 then '讲师'
           when job = 3 then '学工主管'
           when job = 4 then '教研主管'
           when job = 5 then '咨询师'
           else '其他'
           end as job_name,
       count(*) as count
from emp
group by job;
