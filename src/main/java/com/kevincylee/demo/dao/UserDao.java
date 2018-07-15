package com.kevincylee.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevincylee.demo.entity.User;

public interface UserDao extends JpaRepository<User, Serializable>{

	User findByName(String name);

}
