package Repositories;

import Entity.Product;

import java.util.List;

public interface ProductRepository {
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(int productId);
    Product getProduct(int productId);
    List<Product> getAllProducts();
}
