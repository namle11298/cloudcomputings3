package com.cc.three.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.three.components.UserDao;
import com.cc.three.model.User;

@Service
public class UserService implements CrudService<User> {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userCrudDao) {
        this.userDao = userCrudDao;
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User read(String userId) {
        return userDao.read(userId);
    }
    
    public User readByEmail(String email) {
    	return userDao.readByEmail(email);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(String userId) {
        userDao.delete(userId);
    }
}