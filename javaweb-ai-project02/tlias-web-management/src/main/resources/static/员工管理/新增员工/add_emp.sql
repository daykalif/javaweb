-- -------------------------------------- 新增员工 --------------------------------------
-- 保存员工基本信息 - emp
insert into emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)
values ('lingpingzhi', '林平之', 1, '18809091213', 1, 6000,
        'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2020-01-01', 1, '2024-10-01 16:35:33',
        '2024-10-01 16:36:15');

-- 批量保存员工工作经历信息 - emp_expr
insert into emp_expr (emp_id, begin, end, company, job)
values (37, '2020-01-01', '2021-01-01', '百度', 'java开发'),
       (37, '2021-01-01', '2023-01-01', '字节', 'java开发');