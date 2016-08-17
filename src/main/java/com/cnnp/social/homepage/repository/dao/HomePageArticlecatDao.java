package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageArticlecat;

@Transactional
public interface HomePageArticlecatDao extends CrudRepository<THomePageArticlecat, Long> ,JpaSpecificationExecutor<THomePageArticlecat>{
	@Query("select hp from THomePageArticlecat hp ")
	public List<THomePageArticlecat> findall();
	@Query("select hp from THomePageArticlecat hp where hp.parent_id = ?1")
	public List<THomePageArticlecat> find(Long parent_id);
	@Query("select hp from THomePageArticlecat hp where hp.id = ?1")
	public THomePageArticlecat findone(Long id);
	@Query("select max(cast(id as float)) from THomePageArticlecat ")
	public long findmaxid();
	@Query("select count(*) from THomePageArticlecat ")
	public long findid();
}
