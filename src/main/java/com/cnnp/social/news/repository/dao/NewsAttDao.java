package com.cnnp.social.news.repository.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.news.repository.entity.TNews_Att;



@Transactional
public interface NewsAttDao extends CrudRepository<TNews_Att, Long> ,JpaSpecificationExecutor<TNews_Att>{

	@Query("select max(cast(id as float)) from TNews_Att ")
	public long findmaxid();
	@Query("select count(*) from TNews_Att ")
	public long findid();

}
