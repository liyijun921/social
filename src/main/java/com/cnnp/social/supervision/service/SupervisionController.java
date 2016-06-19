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

@RestController
@RequestMapping("/api/v1.0/supervision")
public class SupervisionController {
	@Autowired
	private SupervisionManager supervisionManger;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public @ResponseBody SupervisionDto view(@PathVariable("id") long id) {
		return supervisionManger.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody SupervisionDto supervision) {
//test
		supervisionManger.save(supervision); 

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces="application/json",consumes="application/json")
	public @ResponseBody List<SupervisionDto> search(@RequestBody SupervisionSearch search,@RequestParam int page, @RequestParam int size) {
		return supervisionManger.search(search, page, size);
	}
}
