package com.teambuild.clothershop.daoimpl;

import com.teambuild.clothershop.dao.ManageProductDao;
import com.teambuild.clothershop.model.Kind;
import com.teambuild.clothershop.model.Product;
import com.teambuild.clothershop.model.Size;
import javafx.scene.paint.Color;
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
public class ManageProductDaoImpl implements ManageProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List productList() {
        String sql = "FROM product";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public Product selectProductById(int id) {
        Session session = sessionFactory.openSession();
        return session.find(Product.class, id);
    }

    @Override
    public List getAllKind() {
        String sql = "FROM kind";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public List getAllColor() {
        String sql = "FROM color";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public List getAllSize() {
        String sql = "FROM size";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

}
