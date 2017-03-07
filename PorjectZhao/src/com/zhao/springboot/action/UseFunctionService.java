package com.zhao.springboot.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhao.springboot.service.FunctionService;

@Service
public class UseFunctionService {

	@Autowired
	FunctionService functionService;
	
	public String SayHello(String word) {
		return functionService.sayHello(word);
	}
}
