package kz.vev.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kz.vev.app.domain.Category;
import kz.vev.app.domain.Product;
import kz.vev.app.service.mapper.CategoryMapper;
import kz.vev.app.service.mapper.ProductMapper;

@Service("categoryService")
@Transactional
public class CategoryService {
	protected static Logger logger = Logger.getLogger("service Product");
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Category> getCategoryByName(String name) {
		String sql;
		List<Category> listCategory = new ArrayList<Category>();
		if(name != "") {
			sql = "SELECT * FROM s_category where name like ?";	
			listCategory = jdbcTemplate.query(sql, new CategoryMapper(), name);
		}
		else {
			sql = "SELECT * FROM s_category";
			listCategory = jdbcTemplate.query(sql, new CategoryMapper());
		}
		return listCategory;		
	}

	public Category getCategoryByID(Long id) {
		
		String sql = "SELECT * FROM s_category WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new CategoryMapper(), id);
		
	}
	
	public boolean addCategory(Category category) {
		 
		String sql = "insert into s_category (name) values (?)";
		int row = jdbcTemplate.update(sql, new Object[]{ category.getName()});		
		return (row != 0) ? true : false;
	}
	
	public void updCategory(Category category) {		

		String sql = "UPDATE FROM s_category SET name = ? WHERE id = ? ";
		jdbcTemplate.update(sql, new Object[] {category.getName(),category.getId()});
	}
	
	public void delCategory(Long id) {		

		String sql = "DELETE FROM s_category WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
