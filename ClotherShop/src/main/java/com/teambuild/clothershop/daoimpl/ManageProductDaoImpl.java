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

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
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
    public int updateProductById(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        return product.getIdProduct();
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
    public Object findByItem(String nameItem, String typeItem) {
        Session session = sessionFactory.openSession();
        if (typeItem.equals("SIZE")) {
            String sqlSize = "FROM size where number = :key";
            return session.createQuery(sqlSize).setParameter("key", nameItem).getSingleResult();
        } else if (typeItem.equals("COLOR")) {
            String sqlColor = "FROM color where nameColor = :key";
            return session.createQuery(sqlColor).setParameter("key", nameItem).getSingleResult();
        } else if (typeItem.equals("KIND")) {
            String sqlKind = "FROM kind where nameKind = :key";
            return session.createQuery(sqlKind).setParameter("key", nameItem).getSingleResult();
        } else if (typeItem.equals("PRODUCER")) {
            String sqlProducer = "FROM producer where nameProducer = :key";
            return session.createQuery(sqlProducer).setParameter("key", nameItem).getSingleResult();
        }
        return null;
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

    @Override
    public List getAllCart() {
        String sql = "FROM cart";
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(sql).getResultList();
    }

    @Override
    public List getAllCartDT(Cart cart) {
        String sql = "FROM cartdetails WHERE idCart_CD = :key";
        Session session = sessionFactory.openSession();
        return session.createQuery(sql).setParameter("key", cart).getResultList();
    }

    @Override
    public int addCart(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cart);
        return cart.getIdCart();
    }

    @Override
    public Cart findIdUserTableCart(int id) {
        try {
            Session session = sessionFactory.openSession();
            String sql = "FROM cart where idUser = :key";
            return (Cart) session.createQuery(sql).setParameter("key", id).uniqueResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public CartDetails findIdPDTAndIDUSTblCartDT(int idProductDT, int idCartCD) {
        try {
            Session session = sessionFactory.openSession();
            String sql = "FROM cartdetails where idProductDetails_CD = :key AND idCart_CD = :key2";
            return (CartDetails) session.createQuery(sql).setParameter("key", getProductDetailById(idProductDT))
                    .setParameter("key2", findIdCart(idCartCD)).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Cart findIdCart(int idCart) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Cart.class, idCart);
    }

    @Override // update quantity after buy product
    public int updateQuantityInProductDT(CartDetails cartDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cartDetails);
        return cartDetails.getIdCartDetails();
    }

    @Override
    public int addCartDetails(CartDetails cartDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cartDetails);
        return cartDetails.getIdCartDetails();
    }

    @Override // chưa dùng
    public Long sumPriceInCartDetails(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT SUM(quantity) FROM cartdetails where idCart_CD = :key";
        return (Long) session.createQuery(sql).setParameter("key", cart).getSingleResult();
    }

    @Override
    public int updatePriceOfCart(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cart);
        return cart.getIdCart();
    }

    @Override
    public int deleteCartDetails(int idCartDetails) {
        Session session = sessionFactory.getCurrentSession();
        CartDetails ent = session.load(CartDetails.class, idCartDetails);
        session.delete(ent);
        return ent.getIdCartDetails();
    }

    @Override
    public int updateQuantityInCartDetails(int idCartDetails, int quantity) {
        Session session = sessionFactory.getCurrentSession();
        CartDetails ent = session.load(CartDetails.class, idCartDetails);
        ent.setQuantity(quantity);
        session.update(ent);
        return ent.getIdCartDetails();
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        try {
            Session session = sessionFactory.openSession();
            String sql = "FROM product where nameProduct like concat('%',:key,'%') or nameProduct like concat(:key,'%')"
                    + " or nameProduct like concat('%',:key) or nameProduct like :key";
            return session.createQuery(sql).setParameter("key", nameProduct).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
