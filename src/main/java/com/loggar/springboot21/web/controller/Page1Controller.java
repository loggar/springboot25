package com.loggar.springboot21.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page1")
public class Page1Controller {
	@RequestMapping
	public String page1(Map<String, Object> model) {
		System.out.println("I am here 2");
		model.put("message", "You are in new page !!");
		return "page1";
	}
}
