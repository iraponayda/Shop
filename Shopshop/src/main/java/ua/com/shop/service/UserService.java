package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.User;

public interface UserService {
	void save(User user);
	User findOne(int id);
	User findByEmail(String email);
}
