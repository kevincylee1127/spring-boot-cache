package com.kevincylee.demo.service;

import java.util.List;

import com.kevincylee.demo.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findByName(String name);
	public User findById(Integer id);
}
