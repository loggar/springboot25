package com.loggar.springboot21.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "", "/" })
public class IndexController {
	@RequestMapping
	public String home(Map<String, Object> model) {
		System.out.println("I am here");
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}
}
