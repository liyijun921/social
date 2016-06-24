package com.cnnp.social.supervision.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.base.BaseSetting;
import com.cnnp.social.news.manager.NewsSetting;
import com.cnnp.social.supervision.manager.dto.SupervisionDto;
import com.cnnp.social.supervision.manager.dto.SupervisionSearch;
import com.cnnp.social.supervision.manager.dto.SupervisionTraceDto;
import com.cnnp.social.supervision.repository.dao.SupervisionDao;
import com.cnnp.social.supervision.repository.entity.TSupervision;
import com.cnnp.social.supervision.repository.entity.TSupervisionTrace;

@EnableTransactionManagement
@Component

public class SupervisionManager {
	@Autowired
	private SupervisionDao supervisionDao;
	
	@Autowired
	private BaseSetting setting;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Transactional
	public void save(SupervisionDto supervision) {
		if (supervision == null) {
			return;
		}
		// 保存督办主表
		TSupervision supervisionEntry = new TSupervision();
		mapper.map(supervision, supervisionEntry);

		SupervisionTraceDto traceDto = supervision.getLatestTrace();
		if (traceDto != null) {
			TSupervisionTrace supervisionTraceEntry = new TSupervisionTrace();
			mapper.map(traceDto, supervisionTraceEntry);
			if (supervisionEntry.getTraces() == null) {
				supervisionEntry.setTraces(new ArrayList<TSupervisionTrace>());
			}
			supervisionEntry.getTraces().add(supervisionTraceEntry);
		}

		supervisionDao.save(supervisionEntry);

	}

	/**
	 *
	 * @param id
	 * @return
	 */

	public SupervisionDto findOne(long id) {
		TSupervision supervisionEntry = supervisionDao.findOne(id);
		if (supervisionEntry == null) {
			return new SupervisionDto();
		}
		return convertSupervisionEntrytoDto(supervisionEntry);

	}

	private SupervisionDto convertSupervisionEntrytoDto(TSupervision supervisionEntry) {
		SupervisionDto supervisionDto = new SupervisionDto();
		mapper.map(supervisionEntry, supervisionDto);
		List<TSupervisionTrace> traces = supervisionEntry.getTraces();
		if (traces == null || traces.size() < 1) {
			return supervisionDto;
		}
		TSupervisionTrace trace = traces.get(0);
		SupervisionTraceDto supervisionTraceDto = new SupervisionTraceDto();
		mapper.map(trace, supervisionTraceDto);
		supervisionDto.setLatestTrace(supervisionTraceDto);
		return supervisionDto;
	}
	
	public List<SupervisionDto> findChildren(long pid) {
		List<TSupervision> supervisionEntries=supervisionDao.findChildren(pid);
		if(supervisionEntries==null){
			return new ArrayList<SupervisionDto>();
		}
		List<SupervisionDto> rsList = new ArrayList<SupervisionDto>();
		for(TSupervision supervisionEntry : supervisionEntries ){
			rsList.add(convertSupervisionEntrytoDto(supervisionEntry));
		}
		return rsList;
	}

	public List<SupervisionDto> search(final SupervisionSearch search, int page, int size) {
		Sort sort = new Sort(Direction.DESC, "estimatedcompletetiontime");
		Pageable pageable = new PageRequest(page, size, sort);
		Page<TSupervision> pageSet = supervisionDao.findAll(new Specification<TSupervision>() {
			@Override
			public Predicate toPredicate(Root<TSupervision> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> areaPath = root.get("area");
				Path<Date> estimateDate = root.get("estimatedcompletetiontime");
				Path<String> accountableSN = root.get("accountablesn");
				Path<String> responsibleSN = root.get("responsiblesn");
				Path<String> source = root.get("source");
				Path<String> scopePath = root.get("scope");
				List<Predicate> predicateList = new ArrayList<Predicate>();

				if (StringUtils.isNoneBlank(search.getAreaCode())) {
					String[] areacodes=search.getAreaCode().split(setting.getSplitchar());
					List<Predicate> orPredicateList = new ArrayList<Predicate>();
					for(String areacode : areacodes){
						orPredicateList.add(cb.like(areaPath, areacode));
					}
					Predicate[] orPredicates = new Predicate[orPredicateList.size()];
					orPredicateList.toArray(orPredicates);
					predicateList.add(cb.or(orPredicates));

				}
				if (StringUtils.isNoneBlank(search.getSearchBeginDate())
						&& StringUtils.isNotBlank(search.getSearchEndDate())) {
					try {
						predicateList.add(
								cb.between(estimateDate, DateUtils.parseDate(search.getSearchBeginDate(), "yyyy-MM-dd"),
										DateUtils.parseDate(search.getSearchEndDate(), "yyyy-MM-dd")));
					} catch (Exception err) {

					}
				}
				if (StringUtils.isNoneBlank(search.getAccountableSN())&& !StringUtils.isNoneBlank(search.getResponsibleSN())) {
					predicateList.add(cb.equal(accountableSN, search.getAccountableSN()));
				}
				if (StringUtils.isNoneBlank(search.getResponsibleSN())&& !StringUtils.isNoneBlank(search.getAccountableSN())) {
					predicateList.add(cb.equal(responsibleSN, search.getResponsibleSN()));
				}
				if (StringUtils.isNoneBlank(search.getResponsibleSN())&& StringUtils.isNoneBlank(search.getAccountableSN())) {
					predicateList.add(cb.or(cb.equal(responsibleSN, search.getResponsibleSN()),
							cb.equal(accountableSN, search.getAccountableSN())));
				}
				if (StringUtils.isNoneBlank(search.getSource())) {
					String[] sourcecodes=search.getSource().split(setting.getSplitchar());
					List<Predicate> orPredicateList = new ArrayList<Predicate>();
					for(String sourcecode : sourcecodes){
						orPredicateList.add(cb.equal(source, sourcecode));
					}
					Predicate[] orPredicates = new Predicate[orPredicateList.size()];
					orPredicateList.toArray(orPredicates);
					predicateList.add(cb.or(orPredicates));
				}
				if (StringUtils.isNoneBlank(search.getScope())) {
					String[] scopes=search.getScope().split(setting.getSplitchar());
					List<Predicate> orPredicateList = new ArrayList<Predicate>();
					for(String scope : scopes){
						orPredicateList.add(cb.equal(scopePath, scope));
					}
					Predicate[] orPredicates = new Predicate[orPredicateList.size()];
					orPredicateList.toArray(orPredicates);
					predicateList.add(cb.or(orPredicates));
				}
				Predicate[] predicates = new Predicate[predicateList.size()];
				predicateList.toArray(predicates);
				query.where(predicates);
				return null;
			}
		}, pageable);
		// pageSet.
		final List<SupervisionDto> rsList = new ArrayList<SupervisionDto>();
		List<TSupervision> pageSetList = pageSet.getContent();
		for (TSupervision supervison : pageSetList) {
			SupervisionDto dto = new SupervisionDto();
			mapper.map(supervison, dto);

			if (supervison.getTraces().size() > 0) {
				TSupervisionTrace trace = supervison.getTraces().get(0);
				SupervisionTraceDto traceDto = new SupervisionTraceDto();
				mapper.map(trace, traceDto);
				dto.setLatestTrace(traceDto);
			}
			rsList.add(dto);
		}
		return rsList;
	}
}
