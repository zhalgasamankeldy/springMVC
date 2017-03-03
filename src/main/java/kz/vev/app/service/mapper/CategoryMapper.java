package kz.vev.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kz.vev.app.domain.Category;
import kz.vev.app.domain.Product;

public class CategoryMapper implements RowMapper<Category>{

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setId(rs.getLong("id"));
		category.setName(rs.getString("name"));
		return category;
	}
}
