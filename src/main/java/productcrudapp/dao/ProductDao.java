package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	HibernateTemplate hibernateTemplate ;
	
	@Transactional
	public void createProdect( Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	public List<Product> getProducts(){
		
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	public void deleteProdect(int pid) {
		
		Product product = this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(product);
	}
	
	
	public Product getProduct(int pId) {
		return  this.hibernateTemplate.get(Product.class, pId);
	}
	
}
