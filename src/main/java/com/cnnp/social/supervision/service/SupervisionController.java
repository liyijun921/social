package com.cnnp.social.supervision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.supervision.manager.SupervisionManager;
import com.cnnp.social.supervision.manager.dto.SupervisionDto;

@RestController
@RequestMapping("/supervision")
public class SupervisionController {
	@Autowired
	private SupervisionManager supervisionManger;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody SupervisionDto view(@PathVariable("id") long id) {
		return supervisionManger.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody SupervisionDto supervision) {

		supervisionManger.save(supervision);

	}
}
