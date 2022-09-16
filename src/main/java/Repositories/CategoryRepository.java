package Repositories;

import Entity.Category;

import java.util.List;

public interface CategoryRepository {
    int insertCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(int categoryId);
    Category getCategory(int categoryId);
    List<Category>getAllCategories();
}
