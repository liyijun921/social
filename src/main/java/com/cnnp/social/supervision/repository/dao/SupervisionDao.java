package com.cnnp.social.supervision.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.supervision.repository.entity.TSupervision;

@Transactional
public interface SupervisionDao extends CrudRepository<TSupervision, Long>,JpaSpecificationExecutor<TSupervision>{
	
}
