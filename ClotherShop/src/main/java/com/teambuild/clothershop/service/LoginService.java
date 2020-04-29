package com.teambuild.clothershop.service;


import com.teambuild.clothershop.model.User;

public interface LoginService {
    User findByUsernameAndPassword(String userName, String password);
}
