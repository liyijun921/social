package com.cnnp.social.supervision.repository.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.supervision.repository.entity.TSupervision;

@Transactional
@CacheConfig(cacheNames = "cnnp.portal.socail.supervision")
public interface SupervisionDao extends CrudRepository<TSupervision, Long>,JpaSpecificationExecutor<TSupervision>{
	
	@Query("select supervision from TSupervision supervision where supervision.pid = ?1 or supervision.id=?1")
	public List<TSupervision> findChildren(long pid);

	
	
	
	
	
}
