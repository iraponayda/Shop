package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.User;

public interface UserService {
	void save(User user);
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
}
