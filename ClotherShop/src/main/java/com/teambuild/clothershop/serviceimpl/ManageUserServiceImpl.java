package com.teambuild.clothershop.serviceimpl;

import com.teambuild.clothershop.daoimpl.ManageUserDaoImpl;
import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserServiceImpl implements ManageUserService {

    @Autowired
    ManageUserDaoImpl manageUserDaoImpl;

    @Override
    public User findID(int id) {
        return manageUserDaoImpl.findID(id);
    }

    @Override
    public List listAllUser() {
        return manageUserDaoImpl.listAllUser();
    }

    @Override
    public void addUser(User user) {
        manageUserDaoImpl.addUser(user);
    }

    @Override
    public void editRoleUser(int id, int role) {
        manageUserDaoImpl.editRoleUser(id, role);
    }
}
