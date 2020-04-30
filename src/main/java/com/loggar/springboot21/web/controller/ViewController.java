package com.loggar.springboot21.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "", "/" })
public class ViewController {
	@RequestMapping({ "", "/" })
	public String index(Map<String, Object> model) {
		System.out.println("[log] view controller: index");
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}

	@RequestMapping({ "/other" })
	public String page1(Map<String, Object> model) {
		System.out.println("[log] view controller: other");
		model.put("message", "You are in new page !!");
		return "other";
	}
}
