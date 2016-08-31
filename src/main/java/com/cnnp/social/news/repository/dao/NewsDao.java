package com.cnnp.social.news.repository.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.news.repository.entity.TNews;



@Transactional
public interface NewsDao extends CrudRepository<TNews, Long> ,JpaSpecificationExecutor<TNews>{

	@Query("select max(cast(id as float)) from TNews ")
	public long findmaxid();
	@Query("select count(*) from TNews ")
	public long findid();

}
