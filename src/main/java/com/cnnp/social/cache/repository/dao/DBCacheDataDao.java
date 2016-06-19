package com.cnnp.social.cache.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cnnp.social.cache.repository.entity.TDicData;

public interface DBCacheDataDao extends CrudRepository<TDicData, Long> {
	
	/**
	 * 根据数据字典类型查找数据项
	 * @param dicType 字典类型<String>
	 * @return TDicData
	 */
	@Query("select dic from TDicData dic where dic.dictype = ?1")
	List<TDicData> findByType(String dicType);
	
	/**
	 * 根据上级字典ID查找数据下一级数据项
	 * @param PID <long>上级字典ID
	 * @return TDicData
	 */
	@Query("select dic from TDicData dic where dic.parentid = ?1")
	List<TDicData> findByPID(long PID);
	
}
