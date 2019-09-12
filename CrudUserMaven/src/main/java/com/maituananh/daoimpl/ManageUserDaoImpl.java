package com.maituananh.daoimpl;

import com.maituananh.dao.ManageUserDao;
import com.maituananh.model.Role;
import com.maituananh.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ManageUserDaoImpl implements ManageUserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getAllUser() {
        String sql = "FROM user";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User userDelete = session.get(User.class, id);
        session.delete(userDelete);
    }

    @Override
    public User inForEditUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User userUpdate = session.get(User.class, id);
        return userUpdate;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User saveUser = session.get(User.class, user.getIduser());
        saveUser.setAge(user.getAge());
        saveUser.setName(user.getName());
        saveUser.setUsername(user.getUsername());
        saveUser.setPassword(user.getPassword());

        Role role = new Role();
        role.setIdrole(user.getRole().getIdrole());
        saveUser.setRole(role);
        session.update(saveUser);
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public List searchUser(String name) {
        String sql = "FROM user WHERE name = " + name;
        Session session = sessionFactory.getCurrentSession();
        List<User> userSearch = (List<User>) session.createQuery(sql).getSingleResult();
        return userSearch;
    }
}
