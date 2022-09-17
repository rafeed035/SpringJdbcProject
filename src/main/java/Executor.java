import Entity.Brand;
import Entity.Category;
import Entity.Product;
import JdbcConfig.JdbcConfig;
import RepositoryImplementation.BrandRepositoryImplementation;
import RepositoryImplementation.CategoryRepositoryImplementation;
import RepositoryImplementation.ProductRepositoryImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
        CategoryRepositoryImplementation categoryRepositoryImplementation =
                applicationContext
                        .getBean("getCategoryRepositoryImplementation",
                        CategoryRepositoryImplementation.class);

        BrandRepositoryImplementation brandRepositoryImplementation =
                applicationContext
                        .getBean("getBrandRepositoryImplementation",
                                BrandRepositoryImplementation.class);

        ProductRepositoryImplementation productRepositoryImplementation =
                applicationContext.getBean("getProductRepositoryImplementation",
                        ProductRepositoryImplementation.class);

        System.out.println("==================Welcome to Demo Inventory=================");
        System.out.println("\n");

        List<Category>categories = categoryRepositoryImplementation.getAllCategories();
        System.out.println("Total Categories : " + categories.size());

        List<Brand>brands = brandRepositoryImplementation.getAllBrands();
        System.out.println("Total Brands : " + brands.size());

        List<Product>products = productRepositoryImplementation.getAllProducts();
        System.out.println("Total Products : " + products.size());
        System.out.println("\n");
        System.out.println("=================Options=================");
        System.out.println("\n1. View all Categories  " +
                "2. View a Category  " +
                "3. Add new Category  " +
                "4. Update a Category  " +
                "5. Delete a Category  " +
                "\n\n6. View all Brands  " +
                "7. View a brand  " +
                "8. Add new Brand  " +
                "9. Update a Brand  " +
                "10. Delete a Brand  " +
                "\n\n11. View all Products  " +
                "12. View a Product  " +
                "13. Add new Product  " +
                "14. Update a Product  " +
                "15. Delete a Product  " +
                "\n16. Exit");

        System.out.println("\n=================Your Choice=================");
        System.out.println("\nYour Choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
            switch (choice){
                //view all categories
                case 1:
                    for(int i = 0; i < categories.size(); i++){
                        System.out.println(categories.get(i).getCategoryId() + " " + categories.get(i).getCategoryName());
                    }
                    break;

                    //view a category
                case 2:
                    System.out.println("Enter Category Id: ");
                    int choiceCategory = scanner.nextInt();
                    Category category = categoryRepositoryImplementation.getCategory(choiceCategory);
                    System.out.println(category.getCategoryId() + " " + category.getCategoryName());
                    break;

                    //add a new category
                case 3:
                    System.out.println("Enter Category Id: ");
                    int categoryId = scanner.nextInt();
                    System.out.println("Enter Category Name: ");
                    String categoryName = scanner.next();
                    scanner.nextLine();
                    Category categoryNew = new Category(categoryId, categoryName);
                    int insertCategory = categoryRepositoryImplementation.insertCategory(categoryNew);
                    System.out.println("New category Inserted with id = " + insertCategory);
                    break;

                    //update a category
                case 4:
                    System.out.println("Enter Category Id: ");
                    int categoryUpdateId = scanner.nextInt();
                    System.out.println("Enter Category Name: ");
                    String categoryUpdateName = scanner.next();
                    scanner.nextLine();
                    Category categoryUpdate = new Category(categoryUpdateId, categoryUpdateName);
                    int updateCategory = categoryRepositoryImplementation.updateCategory(categoryUpdate);
                    System.out.println("Updated category with id = " + updateCategory);
                    break;

                    //delete a category
                case 5:
                    System.out.println("Enter Category Id: ");
                    int categoryDeleteId = scanner.nextInt();
                    scanner.nextLine();
                    int deleteCategory = categoryRepositoryImplementation.deleteCategory(categoryDeleteId);
                    System.out.println("Deleted category with id = " + deleteCategory);
                    break;

                    //brands
                //view all brands
                case 6:
                    for(int i = 0; i < brands.size(); i++){
                        Category brandCategory = categoryRepositoryImplementation.getCategory(brands.get(i).getCategory_id());
                        String allBrandCategoryName = brandCategory.getCategoryName();
                        System.out.println(brands.get(i).getBrandId() +
                                " " + brands.get(i).getBrandName() +
                                " Category : " + allBrandCategoryName);
                    }
                    break;

                    //view a particular brand
                case 7:
                    System.out.println("Enter Brand Id: ");
                    int brandId = scanner.nextInt();
                    Brand brand = brandRepositoryImplementation.getBrand(brandId);
                    Category brandCategory = categoryRepositoryImplementation.getCategory(brand.getCategory_id());
                    String brandCategoryName = brandCategory.getCategoryName();
                    System.out.println(brand.getBrandId() + " " +
                            brand.getBrandName() +
                            " " +
                            "Category : " + brandCategoryName);
                    break;

                    //add a new brand
                case 8:
                    System.out.println("Enter Brand Id: ");
                    int newBrandId = scanner.nextInt();
                    System.out.println("Enter Brand Name: ");
                    String newBrandName = scanner.next();
                    scanner.nextLine();
                    int brandCategoryId = scanner.nextInt();
                    scanner.nextLine();
                    Brand brandNew = new Brand(newBrandId, newBrandName, brandCategoryId);
                    int brandInsertResult = brandRepositoryImplementation.insertBrand(brandNew);
                    System.out.println("New Brand Inserted with id = " + brandInsertResult);
                    break;

                    //update a new brand
                case 9:
                    System.out.println("Enter Brand Id: ");
                    int updateBrandId = scanner.nextInt();
                    System.out.println("Enter Brand Name: ");
                    String updateBrandName = scanner.next();
                    scanner.nextLine();
                    int updatebrandCategoryId = scanner.nextInt();
                    scanner.nextLine();
                    Brand brandUpdate = new Brand(updateBrandId, updateBrandName, updatebrandCategoryId);
                    int brandUpdateResult = brandRepositoryImplementation.updateBrand(brandUpdate);
                    System.out.println("Brand updated with id = " + brandUpdateResult);
                    break;

                    // delete a brand
                case 10:
                    System.out.println("Enter Brand Id: ");
                    int brandDeleteId = scanner.nextInt();
                    scanner.nextLine();
                    int deleteBrandResult = brandRepositoryImplementation.deleteBrand(brandDeleteId);
                    System.out.println("Deleted category with id = " + deleteBrandResult);
                    break;

                    //view all products
                case 11:
                    for(int i = 0; i < products.size(); i++){
                        Category productCategory = categoryRepositoryImplementation.getCategory(products.get(i).getCategoryId());
                        String allProductCategoryName = productCategory.getCategoryName();
                        Brand productBrand = brandRepositoryImplementation.getBrand(products.get(i).getBrandId());
                        String allProductBrandName = productBrand.getBrandName();
                        System.out.println(products.get(i).getProductId() +
                                " " + products.get(i).getProductName() +
                                " Price : " + products.get(i).getProductPrice() +
                                " Category : " + allProductCategoryName +
                                " Brand : " + allProductBrandName);
                    }
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
            }
//        for(int i = 0; i < categories.size(); i++){
//            System.out.println(categories.get(i).getCategoryId() + " " + categories.get(i).getCategoryName());
//        }

    }
}
