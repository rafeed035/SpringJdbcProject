package RepositoryImplementation;

import Entity.Category;
import Repositories.CategoryRepository;
import RowMapperImplementation.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class CategoryRepositoryImplementation implements CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertCategory(Category category) {
        String insertQuery = "insert into category(category_id, category_name) values (?, ?)";
        int insertResult = jdbcTemplate.update(insertQuery,
                category.getCategoryId(),
                category.getCategoryName());
        return insertResult;
    }

    @Override
    public int updateCategory(Category category) {
        String updateQuery = "update category set category_name = ? where category_id = ?";
        int updateResult = jdbcTemplate.update(updateQuery,
                category.getCategoryName(),
                category.getCategoryId());
        return updateResult;
    }

    @Override
    public int deleteCategory(int categoryId) {
        String deleteQuery = "delete from category where category_id = ?";
        int deleteResult = jdbcTemplate.update(deleteQuery, categoryId);
        return deleteResult;
    }

    @Override
    public Category getCategory(int categoryId) {
        String selectCategoryQuery = "select * from category where category_id = ?";
        RowMapper<Category> rowMapper = new CategoryRowMapper();
        Category category = jdbcTemplate.queryForObject(selectCategoryQuery, rowMapper, categoryId);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        String selectAllCategoriesQuery = "select * from category";
        RowMapper<Category> categoryRowMapper = new CategoryRowMapper();
        List<Category> categories = jdbcTemplate.query(selectAllCategoriesQuery, categoryRowMapper);
        return categories;
    }
}
