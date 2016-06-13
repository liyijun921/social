package com.cnnp.social.supervision.manager;

import com.cnnp.social.supervision.manager.dto.SupervisionDto;
import com.cnnp.social.supervision.manager.dto.SupervisionTraceDto;
import com.cnnp.social.supervision.repository.dao.SupervisionDao;
import com.cnnp.social.supervision.repository.dao.SupervisionTraceDao;
import com.cnnp.social.supervision.repository.entity.TSupervision;
import com.cnnp.social.supervision.repository.entity.TSupervisionTrace;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Component

public class SupervisionManager {
	@Autowired
	private SupervisionDao supervisionDao;
	@Autowired
	private SupervisionTraceDao supervisionTraceDao;


	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Transactional
	public void save(SupervisionDto supervision){
		if(supervision==null){
			return;
		}
		//保存督办主表
		TSupervision supervisionEntry=new TSupervision();
		mapper.map(supervision, supervisionEntry);
		supervisionEntry = supervisionDao.save(supervisionEntry);
		if(supervisionEntry==null || supervision.getLatestTrace()==null){
			return;
		}
		//保存督办子表
		TSupervisionTrace supervisionTraceEntry=new TSupervisionTrace();
		mapper.map(supervision.getLatestTrace(), supervisionTraceEntry);
		supervisionTraceEntry.setSupervisionid(supervisionEntry.getId());
		supervisionTraceDao.save(supervisionTraceEntry);

    }

	/**
	 *
	 * @param id
	 * @return
     */
	
	public SupervisionDto findOne(long id){
		TSupervision supervisionEntry = supervisionDao.findOne(id);
		if(supervisionEntry==null){
			return new SupervisionDto();
		}
		SupervisionDto supervisionDto=new SupervisionDto();
		mapper.map(supervisionEntry, supervisionDto);
		TSupervisionTrace supervisionTraceEntry=supervisionTraceDao.find(supervisionDto.getId());
		if(supervisionTraceEntry==null){
			return supervisionDto;
		}
		SupervisionTraceDto supervisionTraceDto=new SupervisionTraceDto();
		mapper.map(supervisionTraceEntry, supervisionTraceDto);
		supervisionDto.setLatestTrace(supervisionTraceDto);
		return supervisionDto;
		
	}
	
}
