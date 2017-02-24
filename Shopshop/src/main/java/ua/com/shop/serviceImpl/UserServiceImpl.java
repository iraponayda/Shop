package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.UserDao;
import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);// TODO Auto-generated method stub
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);// TODO Auto-generated method stub
		
	}

}
