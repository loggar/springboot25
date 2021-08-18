package com.loggar.springboot25.controller.view;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "", "/" })
public class ViewController {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@RequestMapping({ "", "/" })
	public String index(Map<String, Object> model) {
		logger.debug("View controller: index");
		model.put("message", "You are in the index page");
		return "index";
	}

	@RequestMapping({ "/other" })
	public String page1(Map<String, Object> model) {
		logger.debug("View controller: other");
		model.put("message", "You are in the other page");
		return "other";
	}
}
