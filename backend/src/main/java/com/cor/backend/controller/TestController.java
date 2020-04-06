package com.cor.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cor.backend.model.TestText;
import com.cor.backend.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping
	public String test() {
		return "Working!";
	}

	@RequestMapping(value = "/isWorking", method = RequestMethod.GET, produces = "application/json")
	public TestText testIfWorking(@RequestParam String txt) {
		TestText tt = new TestText();
		tt.setText(txt);
		
		tt = testService.fireDroolsRules(tt);
		
		return tt;
	}
}
