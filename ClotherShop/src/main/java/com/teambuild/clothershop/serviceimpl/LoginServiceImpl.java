package com.teambuild.clothershop.serviceimpl;

import com.teambuild.clothershop.daoimpl.LoginDaoImpl;
import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDaoImpl loginDaoImpl;

    @Override
    public User findByUsernameAndPassword(String userName, String password) {
        return loginDaoImpl.findByUsernameAndPassword(userName, password);
    }
}
