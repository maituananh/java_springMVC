package com.teambuild.clothershop.daoimpl;

import com.teambuild.clothershop.dao.ManageUserDao;
import com.teambuild.clothershop.model.Gender;
import com.teambuild.clothershop.model.Role;
import com.teambuild.clothershop.model.User;
import com.teambuild.clothershop.model.Verification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ManageUserDaoImpl implements ManageUserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findID(int id) {
        Session session = sessionFactory.getCurrentSession();
        User userId = session.get(User.class, id);
        return userId;
    }

    @Override
    public List<User> listAllUser() {
        String hql = "FROM user";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(hql).getResultList();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User userAdd = new User();
        userAdd.setName(user.getName());
        userAdd.setUserName(user.getUserName());
        userAdd.setPassword(user.getPassword());
        userAdd.setPhone(user.getPhone());
        userAdd.setAddress(user.getAddress());
        userAdd.setBirthday(user.getBirthday());
        userAdd.setHometown(user.getHometown());
        userAdd.setAge(user.getAge());
        userAdd.setEmail(user.getEmail());
        userAdd.setAvatar(user.getAvatar());

        Role roleAdd = new Role();
        roleAdd.setIdRole(2); // role mặc định user
        userAdd.setRole(roleAdd);

        Gender gender = new Gender();
        gender.setIdGender(user.getGender().getIdGender());
        userAdd.setGender(gender);

        Verification verification = new Verification();
        verification.setCodes(""); // code mặc định ""
        userAdd.setVerification(verification);

        session.save(userAdd);
    }

    @Override
    public void editRoleUser(int id, int role) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        Role roleEdit = new Role();
        roleEdit.setIdRole(role);
        user.setRole(roleEdit);

        session.update(user);
    }
}
