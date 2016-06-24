package com.cnnp.social.supervision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.supervision.manager.SupervisionManager;
import com.cnnp.social.supervision.manager.dto.SupervisionDto;
import com.cnnp.social.supervision.manager.dto.SupervisionSearch;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api(value="Supervision",description="督办管理")
@RestController
@RequestMapping("/api/v1.0/supervision")
public class SupervisionController {
	@Autowired
	private SupervisionManager supervisionManger;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public @ResponseBody SupervisionDto view(@PathVariable("id") long id) {
		return supervisionManger.findOne(id);
	}
	@RequestMapping(value = "/findchildren/{pid}", method = RequestMethod.GET)
	public @ResponseBody List<SupervisionDto> findChildren(@PathVariable("pid") long pid) {
		return supervisionManger.findChildren(pid);
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody SupervisionDto supervision) {
		supervisionManger.save(supervision);

	}

	@ApiOperation(value = "分页查询督办列表", notes = "调用者传入当前页和每页显示数目返回督办列表")
	
	@ApiImplicitParams({
			@ApiImplicitParam(name = "search", value = "查询条件", required = true, dataType = "SupervisionSearch"),
			@ApiImplicitParam(name = "page", value = "当前页码", required = true,paramType="query",dataType = "long"),
			@ApiImplicitParam(name = "size", value = "每页显示数目", required = true,paramType="query",dataType = "long") })
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<SupervisionDto> search(@RequestBody SupervisionSearch search, @RequestParam int page,
			@RequestParam int size) {
		return supervisionManger.search(search, page, size);
	}
}
