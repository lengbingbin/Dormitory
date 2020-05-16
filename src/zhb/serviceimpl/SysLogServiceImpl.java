package zhb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhb.dao.SysLogMapper;
import zhb.pojo.SysLog;
import zhb.service.SysLogService;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService{

	@Autowired
	private SysLogMapper sysLogMapper;
	@Override
	public void save(SysLog syslog) throws Exception {
		// TODO Auto-generated method stub
		sysLogMapper.save(syslog);
	}

}
