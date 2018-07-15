package com.kevincylee.demo.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kevincylee.demo.dao.UserDao;
import com.kevincylee.demo.entity.User;
import com.kevincylee.demo.service.UserService;

/**
 * ClassName: UserServiceImpl
 * 
 * @author Chen Yuan Lee (Kevin)
 * @version 1.0
 * @createTime: 2018/07/15 20:42:52
 */

@Service
public class UserServiceImpl implements UserService {

	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao dao;

	@Cacheable(value = "user")
	public List<User> findAll() {
		logger.info("findAll Create Cache from DB!!");
		return dao.findAll();
	}

	@Cacheable(value = "user", key = "#name")
	public User findByName(String name) {
		logger.info("findByName Create Cache from DB!!");
		return dao.findByName(name);
	}

	@Cacheable(value = "user", key = "#id")
	public User findById(Integer id) {
		logger.info("findById Create Cache from DB!!");
		return dao.findOne(id);
	}
}
