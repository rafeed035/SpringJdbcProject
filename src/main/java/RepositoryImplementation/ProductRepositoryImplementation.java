package RepositoryImplementation;

import Entity.Product;
import Repositories.ProductRepository;
import RowMapperImplementation.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ProductRepositoryImplementation implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertProduct(Product product) {
        String insertQuery = "insert into product(product_id," +
                " product_name," +
                " product_price," +
                " product_category_id," +
                " product_brand_id) " +
                "values(?, ?, ?, ?, ?)";
        int insertResult = jdbcTemplate.update(insertQuery,
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getCategoryId(),
                product.getBrandId());

        return insertResult;
    }

    @Override
    public int updateProduct(Product product) {
        String updateQuery = "update product set product_name = ?," +
                " product_price = ?," +
                " product_category_id = ?," +
                " product_brand_id = ?" +
                "  where product_id =?";
        int updateResult = jdbcTemplate.update(updateQuery,
                product.getProductName(),
                product.getProductPrice(),
                product.getCategoryId(),
                product.getBrandId(),
                product.getProductId());
        return updateResult;
    }

    @Override
    public int deleteProduct(int productId) {
        String deleteQuery = "delete from product where product_id =?";
        int deleteResult = jdbcTemplate.update(deleteQuery, productId);
        return deleteResult;
    }

    @Override
    public Product getProduct(int productId) {
        String getProductQuery = "select * from product where product_id = ?";
        RowMapper<Product>rowMapper = new ProductRowMapper();
        Product product = jdbcTemplate.queryForObject(getProductQuery, rowMapper, productId);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        String getAllProducts = "select * from product";
        RowMapper<Product>rowMapper = new ProductRowMapper();
        List<Product>products = jdbcTemplate.query(getAllProducts, rowMapper);
        return products;
    }
}
