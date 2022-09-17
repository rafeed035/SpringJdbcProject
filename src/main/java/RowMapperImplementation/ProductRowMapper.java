package RowMapperImplementation;

import Entity.Product;
import Repositories.ProductRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductPrice(rs.getInt("product_price"));
        product.setCategoryId(rs.getInt("product_category_id"));
        product.setBrandId(rs.getInt("product_brand_id"));
        return product;
    }
}
