package kz.vev.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kz.vev.app.domain.Product;


public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setMark(rs.getString("mark"));
		product.setAmount(rs.getDouble("amount"));
		return product;
	}
}
