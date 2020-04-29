package com.teambuild.clothershop.dao;


import com.teambuild.clothershop.model.User;

public interface LoginDao {
    User findByUsernameAndPassword(String userName, String password);
}
