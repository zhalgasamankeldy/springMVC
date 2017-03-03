package kz.vev.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kz.vev.app.domain.Product;
import kz.vev.app.service.mapper.ProductMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Service for processing Products
 * 
 */
@Service("productService")
@Transactional
public class ProductService {
	
	protected static Logger logger = Logger.getLogger("service Product");
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> getProductByName(String name) {
		String sql;
		List<Product> listProduct = new ArrayList<Product>();
		if(name != "") {
				sql = "SELECT * FROM d_product where name like ?";	
				listProduct = jdbcTemplate.query(sql, new ProductMapper(), name);
			}
		else {
				sql = "SELECT * FROM d_product";
				listProduct = jdbcTemplate.query(sql, new ProductMapper());
		}
		return listProduct;
	}
	
	public Product getProductByID(Long id) {
		
		String sql = "SELECT * FROM d_product WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
		
	}
	
	public boolean addProduct(Product product) {
		 
		String sql = "insert into d_product (name, description, mark, amount) values (?, ?, ?, ?)";
		int row = jdbcTemplate.update(sql, new Object[]{ product.getName(), product.getDescription(), product.getMark(), product.getAmount() });
		
		return (row != 0) ? true : false;
	}

	public void updProduct(Product product) {		

		String sql = "UPDATE FROM d_product SET name = ?, description = ?, mark = ?, amount = ? WHERE id = ? ";
		jdbcTemplate.update(sql, new Object[] {product.getName(), product.getDescription(), product.getMark(), product.getAmount(), product.getId()});
	}
	
	public void delProduct(Long id) {		

		String sql = "DELETE FROM d_product WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
