package com.cnnp.social.homepage.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.homepage.repository.entity.THomePageAdmin;




@Transactional
public interface HomePageAdminDao extends CrudRepository<THomePageAdmin, Long> ,JpaSpecificationExecutor<THomePageAdmin>{
	@Query("select hp from THomePageAdmin hp where hp.hpid = ?1 and hp.columnid = '0'")
	public List<THomePageAdmin> findHPadmin(Long hpid);
	@Query("select hp from THomePageAdmin hp where columnid = ?1 ")
	public List<THomePageAdmin> findcolumnadmin(long columnid);
	@Query("select hp from THomePageAdmin hp where hp.userid = ?1 and hp.columnid = '0'")
	public List<THomePageAdmin> findHP(String userid);

	@Query("select max(cast(id as float)) from THomePageAdmin ")
	public long findmaxid();
}
