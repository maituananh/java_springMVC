package com.teambuild.clothershop.service;

import com.teambuild.clothershop.model.User;

import java.util.List;

public interface ManageUserService {
    User findID(int id);
    List listAllUser();
    void addUser(User user);
    void editRoleUser(int id, int role);
}
