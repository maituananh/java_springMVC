package com.teambuild.clothershop.daoimpl;

import com.teambuild.clothershop.dao.ManageProductDao;
import com.teambuild.clothershop.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ManageProductDaoImpl implements ManageProductDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List productList(int position, int page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM product");
        query.setFirstResult(position);
        query.setMaxResults(page);
        return query.getResultList();
    }

    @Override
    public List getAllProduct() {
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
    public void insertProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
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

    @Override
    public List getAllProducer() {
        String sql = "FROM producer";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public void addKind(Kind kind) {
        Session session = sessionFactory.getCurrentSession();
        session.save(kind);
    }

    @Override
    public void addColor(Color color) {
        Session session = sessionFactory.getCurrentSession();
        session.save(color);
    }

    @Override
    public void addSize(Size size) {
        Session session = sessionFactory.getCurrentSession();
        session.save(size);
    }

    @Override
    public void addProducer(Producer producer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(producer);
    }

    @Override
    public List recentProducts(int start, int end) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM product order by created_date asc");
        query.setFirstResult(start);
        query.setMaxResults(end);
        return query.getResultList();
    }
}
