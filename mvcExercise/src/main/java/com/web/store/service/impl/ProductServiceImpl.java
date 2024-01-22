package com.web.store.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.ProductDao;
import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
import com.web.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao;
	
//	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Transactional
	@Override
	public List<BookBean> getAllProducts() {
		return productDao.getAllProducts();
	}
	@Transactional
	@Override
	public void updateAllStocks() {
		 List<BookBean> beans = getAllProducts();
		 for(BookBean bean : beans) {
			 if(bean.getStock() != null && bean.getStock() < 50) {
				 productDao.updateStock(bean.getBookId(), bean.getStock() + 50);
			 }
		 }
//		 throw new RuntimeException("測試用...");
	}
	@Transactional
	@Override
	public List<String> getAllCategories() {
		return productDao.getAllCategories();
	}
	@Transactional
	@Override
	public List<BookBean> getProductsByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}
	@Transactional
	@Override
	public BookBean getProductById(int productId) {
		return productDao.getProductById(productId);
	}

	@Transactional
	@Override
	public void addProduct(BookBean product) {
		productDao.addProduct(product);
	}

	@Transactional
	@Override
	public CompanyBean getCompanyById(int companyId) {
		return productDao.getCompanyById(companyId);
	}

	@Transactional
	@Override
	public List<CompanyBean> getCompanyList() {
		return productDao.getCompanyList();
	}
}
