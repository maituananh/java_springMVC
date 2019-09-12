package com.teambuild.clothershop.daoimpl;

import com.teambuild.clothershop.dao.LoginDao;
import com.teambuild.clothershop.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginDaoImpl implements LoginDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List singleUserList(String userName, String password) {
        String sql = "from user WHERE userName =:userName AND password =:password";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        List<User> getSingleResult = query.list();
        return getSingleResult;
    }
}
