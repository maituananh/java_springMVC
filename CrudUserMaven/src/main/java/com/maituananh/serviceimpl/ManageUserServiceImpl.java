package com.maituananh.serviceimpl;

import com.maituananh.daoimpl.ManageUserDaoImpl;
import com.maituananh.model.User;
import com.maituananh.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserServiceImpl implements ManageUserService {
    @Autowired
    ManageUserDaoImpl manageUserDaoImpl;

    @Override
    public List getAllUser() {
        return manageUserDaoImpl.getAllUser();
    }

    @Override
    public void deleteUser(int id) {
        manageUserDaoImpl.deleteUser(id);
    }

    @Override
    public User inForEditUser(int id) {
        return manageUserDaoImpl.inForEditUser(id);
    }

    @Override
    public void saveUser(User user) {
        manageUserDaoImpl.saveUser(user);
    }

    @Override
    public void addUser(User user) {
        manageUserDaoImpl.addUser(user);
    }

    @Override
    public List searchUser(String name) {
        return manageUserDaoImpl.searchUser(name);
    }
}
