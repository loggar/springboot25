package com.loggar.springboot25.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sample")
public class ViewSampleController {
	@RequestMapping(value = "/{pagePath}", method = { RequestMethod.POST, RequestMethod.GET })
	public String pageLink(@PathVariable String pagePath) {
		return pagePath;
	}
}
