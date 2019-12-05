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
        Session session = sessionFactory.getCurrentSession();
        Product product = session.find(Product.class, id);
        session.clear();
        return product;
    }

    @Override
    public void insertProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public List getAllKind() {
        String sql = "FROM kind order by idKind asc";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public List getAllColor() {
        String sql = "FROM color order by idColor asc";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public List getAllSize() {
        String sql = "FROM size order by idSize asc";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public List getAllProducer() {
        String sql = "FROM producer order by idProducer asc";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public int addKind(Kind kind) {
        Session session = sessionFactory.getCurrentSession();
        session.save(kind);
        return kind.getIdKind();
    }

    @Override
    public int addColor(Color color) {
        Session session = sessionFactory.getCurrentSession();
        session.save(color);
        return color.getIdColor();
    }

    @Override
    public int addSize(Size size) {
        Session session = sessionFactory.getCurrentSession();
        session.save(size);
        return size.getIdSize();
    }

    @Override
    public int addProducer(Producer producer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(producer);
        return producer.getIdProducer();
    }

    @Override
    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = new Product();
        product.setIdProduct(id);
        session.delete(product);
    }

    @Override
    public void deleteProductDetail(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductDetails productDetails = new ProductDetails();
        productDetails.setIdProductDetails(id);
        session.delete(productDetails);
    }

    @Override
    public ProductDetails getProductDetailById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(ProductDetails.class, id);
    }

    @Override
    public void updateProductDetailById(ProductDetails productDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.update(productDetails);
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
