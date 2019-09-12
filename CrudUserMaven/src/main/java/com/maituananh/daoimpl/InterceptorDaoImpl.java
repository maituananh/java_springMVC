package com.maituananh.daoimpl;

import com.maituananh.dao.InterceptorDao;
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
public class InterceptorDaoImpl implements InterceptorDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List loadMenu() {
        String sql = "FROM menu";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }
}
