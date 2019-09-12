package com.teambuild.clothershop.daoimpl;

import com.teambuild.clothershop.model.Slide;
import com.teambuild.clothershop.service.SlideInterceptorService;
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
public class SlideInterceptorDaoImpl implements SlideInterceptorService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Slide> loadMenu() {
        String sql = "FROM slide";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }
}
