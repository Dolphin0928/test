package com.web.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.web.store.dao.ProductDao;
import com.web.store.exception.ProductNotFoundException;
import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	SessionFactory factory;
	
//	@Autowired
	public ProductDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<BookBean> getAllProducts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookBean";
		List<BookBean> beans = session.createQuery(hql,BookBean.class)
									   .getResultList();
		return beans;
	}

	@Override
	public void updateStock(int productId, int newQuantity) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE BookBean SET stock = :stk WHERE bookId = :id";
		session.createQuery(hql)
				.setParameter("stk", newQuantity)
				.setParameter("id", productId)
				.executeUpdate();
	}

	@Override
	public List<String> getAllCategories() {
		Session session = factory.getCurrentSession();
		String hql = "SELECT DISTINCT category FROM BookBean";
		List<String> categories = session.createQuery(hql,String.class)
				   						 .getResultList();
		return categories;
	}

	@Override
	public List<BookBean> getProductsByCategory(String category) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookBean WHERE category = :cate";
		List<BookBean> beans = session.createQuery(hql,BookBean.class)
									  .setParameter("cate", category)
									  .getResultList();
		return beans;
	}

	@Override
	public BookBean getProductById(int productId) {
		Session session = factory.getCurrentSession();
		BookBean bb = session.get(BookBean.class, productId);
		if (bb == null) {
			throw new ProductNotFoundException("產品編號：" + productId + "找不到");
		}
		return bb;
	}

	
	@Override
	public void addProduct(BookBean product) {
	    Session session = factory.getCurrentSession();
	    CompanyBean cb = getCompanyById(product.getCompanyId());
	    product.setCompanyBean(cb);
	    session.save(product);
	}
	@Override
	public CompanyBean getCompanyById(int companyId) {
	    CompanyBean cb = null;
	    Session session = factory.getCurrentSession();
	    cb = session.get(CompanyBean.class, companyId);
	    return cb;
	}
	@Override
	public List<CompanyBean> getCompanyList() {
		Session session = factory.getCurrentSession();
	    String hql = "FROM CompanyBean";
	    List<CompanyBean> list = session.createQuery(hql, CompanyBean.class)
	    		                        .getResultList();
	    return list;
	}
}
