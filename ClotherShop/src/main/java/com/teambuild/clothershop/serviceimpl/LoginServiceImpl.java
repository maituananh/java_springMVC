package com.teambuild.clothershop.serviceimpl;

import com.teambuild.clothershop.daoimpl.LoginDaoImpl;
import com.teambuild.clothershop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDaoImpl loginDaoImpl;

    @Override
    public List singleUserList(String userName, String password) {
        return loginDaoImpl.singleUserList(userName, password);
    }
}
