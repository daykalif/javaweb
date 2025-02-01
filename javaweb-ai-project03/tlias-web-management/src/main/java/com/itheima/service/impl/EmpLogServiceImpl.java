package com.itheima.service.impl;

import com.itheima.mapper.EmpLogMapper;
import com.itheima.pojo.EmpLog;
import com.itheima.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

	@Autowired
	private EmpLogMapper empLogMapper;

	@Transactional(propagation = Propagation.REQUIRES_NEW)  // 需要在一个新的事务中运行，如果有当前事务，并且当前事务中有异常，则回滚当前事务，并不会影响这个新的事务
	@Override
	public void insertLog(EmpLog empLog) {
		empLogMapper.insert(empLog);
	}
}
