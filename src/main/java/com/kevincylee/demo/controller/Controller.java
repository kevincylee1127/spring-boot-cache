package com.kevincylee.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kevincylee.demo.entity.User;
import com.kevincylee.demo.service.UserService;

/**
 * ClassName: Controller
 * 
 * @author Chen Yuan Lee (Kevin)
 * @version 1.0
 * @createTime: 2018/07/15 20:42:52
 */

@RestController
public class Controller {

	private final static Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	UserService service;

	@GetMapping("/")
	private ModelAndView index() {
		logger.info("Request /");
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = service.findAll();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/{name}")
	public String getUserByName(@PathVariable String name) {
		logger.info("Request /{name}");
		return service.findByName(name).getEmail();
	}

	@GetMapping("/get")
	public String getUserById(@RequestParam Integer id) {
		logger.info("Request /get");
		return service.findById(id).getName();
	}

}
