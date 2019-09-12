package com.teambuild.clothershop.dao;


import java.util.List;

public interface LoginDao {
    List singleUserList(String userName, String password);
}
