import Entity.Brand;
import Entity.Category;
import Entity.Product;
import JdbcConfig.JdbcConfig;
import RepositoryImplementation.BrandRepositoryImplementation;
import RepositoryImplementation.CategoryRepositoryImplementation;
import RepositoryImplementation.ProductRepositoryImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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




        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean runApplication = true;
        while(runApplication){
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
                    "\n\n16. Exit");

            System.out.println("\n=================Your Choice=================");
            System.out.println("\nYour Choice: ");

            try {
                int choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice){

                    //category
                    //view all categories
                    case 1:
                        for(int i = 0; i < categories.size(); i++){
                            System.out.println(categories.get(i).getCategoryId() + " " + categories.get(i).getCategoryName());
                        }
                        System.out.println("\n");
                        break;

                    //view a category
                    case 2:
                        System.out.println("Enter Category Id: ");
                        int choiceCategory = Integer.parseInt(bufferedReader.readLine());

                        Category category = categoryRepositoryImplementation.getCategory(choiceCategory);
                        System.out.println(category.getCategoryId() + " " + category.getCategoryName());
                        System.out.println("\n");
                        break;

                    //add a new category
                    case 3:
                        System.out.println("Enter Category Id: ");
                        int categoryId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Category Name: ");
                        String categoryName = bufferedReader.readLine();

                        Category categoryNew = new Category(categoryId, categoryName);
                        int insertCategory = categoryRepositoryImplementation.insertCategory(categoryNew);
                        System.out.println("New category Inserted with id = " + insertCategory);
                        System.out.println("\n");
                        break;

                    //update a category
                    case 4:
                        System.out.println("Enter Category Id: ");
                        int categoryUpdateId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Category Name: ");
                        String categoryUpdateName = bufferedReader.readLine();

                        Category categoryUpdate = new Category(categoryUpdateId, categoryUpdateName);
                        int updateCategory = categoryRepositoryImplementation.updateCategory(categoryUpdate);
                        System.out.println("Updated category with id = " + updateCategory);
                        System.out.println("\n");
                        break;

                    //delete a category
                    case 5:
                        System.out.println("Enter Category Id: ");
                        int categoryDeleteId = Integer.parseInt(bufferedReader.readLine());

                        int deleteCategory = categoryRepositoryImplementation.deleteCategory(categoryDeleteId);
                        System.out.println("Deleted category with id = " + deleteCategory);
                        System.out.println("\n");
                        break;

                    //brands
                    //view all brands
                    case 6:
                        for(int i = 0; i < brands.size(); i++){
                            Category brandCategory = categoryRepositoryImplementation.getCategory(brands.get(i).getCategory_id());
                            String allBrandCategoryName = brandCategory.getCategoryName();
                            System.out.println(brands.get(i).getBrandId() +
                                    " | " +
                                    brands.get(i).getBrandName() +
                                    " | Category : " + allBrandCategoryName);

                        }
                        System.out.println("\n");
                        break;

                    //view a particular brand
                    case 7:
                        System.out.println("Enter Brand Id: ");
                        int brandId = Integer.parseInt(bufferedReader.readLine());

                        Brand brand = brandRepositoryImplementation.getBrand(brandId);
                        Category brandCategory = categoryRepositoryImplementation.getCategory(brand.getCategory_id());
                        String brandCategoryName = brandCategory.getCategoryName();
                        System.out.println(brand.getBrandId() +
                                " | " +
                                brand.getBrandName() +
                                " | " +
                                "Category : " + brandCategoryName);
                        System.out.println("\n");
                        break;

                    //add a new brand
                    case 8:
                        System.out.println("Enter Brand Id: ");
                        int newBrandId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Brand Name: ");
                        String newBrandName = bufferedReader.readLine();

                        System.out.println("Enter Category Id: ");
                        int brandCategoryId = Integer.parseInt(bufferedReader.readLine());

                        Brand brandNew = new Brand(newBrandId, newBrandName, brandCategoryId);
                        int brandInsertResult = brandRepositoryImplementation.insertBrand(brandNew);
                        System.out.println("New Brand Inserted with id = " + brandInsertResult);

                        System.out.println("\n");
                        break;

                    //update a new brand
                    case 9:
                        System.out.println("Enter Brand Id: ");
                        int updateBrandId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Brand Name: ");
                        String updateBrandName = bufferedReader.readLine();

                        System.out.println("Enter Category Id: ");
                        int updateBrandCategoryId = Integer.parseInt(bufferedReader.readLine());

                        Brand brandUpdate = new Brand(updateBrandId, updateBrandName, updateBrandCategoryId);
                        int brandUpdateResult = brandRepositoryImplementation.updateBrand(brandUpdate);
                        System.out.println("Brand updated with id = " + brandUpdateResult);

                        System.out.println("\n");
                        break;

                    // delete a brand
                    case 10:
                        System.out.println("Enter Brand Id: ");
                        int brandDeleteId = Integer.parseInt(bufferedReader.readLine());

                        int deleteBrandResult = brandRepositoryImplementation.deleteBrand(brandDeleteId);
                        System.out.println("Deleted category with id = " + deleteBrandResult);

                        System.out.println("\n");
                        break;

                        //Product
                    //view all products
                    case 11:
                        for(int i = 0; i < products.size(); i++){
                            Category productCategory = categoryRepositoryImplementation.getCategory(products.get(i).getCategoryId());
                            String allProductCategoryName = productCategory.getCategoryName();
                            Brand productBrand = brandRepositoryImplementation.getBrand(products.get(i).getBrandId());
                            String allProductBrandName = productBrand.getBrandName();
                            System.out.println(products.get(i).getProductId() +
                                    " " + products.get(i).getProductName() +
                                    " | Price : " + products.get(i).getProductPrice() +
                                    " | Category : " + allProductCategoryName +
                                    " | Brand : " + allProductBrandName);
                        }
                        System.out.println("\n");
                        break;

                    //view a product
                    case 12:
                        System.out.println("Enter Product Id: ");
                        int productId = Integer.parseInt(bufferedReader.readLine());

                        Product product = productRepositoryImplementation.getProduct(productId);
                        Brand productBrand = brandRepositoryImplementation.getBrand(product.getBrandId());
                        Category productCategory = categoryRepositoryImplementation.getCategory(product.getCategoryId());
                        String productCategoryName = productCategory.getCategoryName();
                        String productBrandName = productBrand.getBrandName();
                        System.out.println(product.getProductId() +
                                " " + product.getProductName() +
                                " | Price : " + product.getProductPrice() +
                                " | Category : " + productCategoryName +
                                " | Brand : " + productBrandName);

                        System.out.println("\n");
                        break;

                    //add a new product
                    case 13:
                        System.out.println("Enter Product Id: ");
                        int newProductId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Name: ");
                        String newProductName = bufferedReader.readLine();

                        System.out.println("Enter Product Price: ");
                        int newProductPrice = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Category Id: ");
                        int newProductCategoryId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Brand Id: ");
                        int newProductBrandId = Integer.parseInt(bufferedReader.readLine());

                        Product productNew = new Product(newProductId,
                                newProductName,
                                newProductPrice,
                                newProductCategoryId,
                                newProductBrandId);
                        int insertProductResult = productRepositoryImplementation.insertProduct(productNew);
                        System.out.println("New Product Inserted with id = " + insertProductResult);

                        System.out.println("\n");
                        break;

                    //update a new product
                    case 14:
                        System.out.println("Enter Product Id: ");
                        int updateProductId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Name: ");
                        String updateProductName = bufferedReader.readLine();

                        System.out.println("Enter Product Price: ");
                        int updateProductPrice = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Category Id: ");
                        int updateProductCategoryId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Product Brand Id: ");
                        int updateProductBrandId = Integer.parseInt(bufferedReader.readLine());

                        Product productUpdate = new Product(updateProductId,
                                updateProductName,
                                updateProductPrice,
                                updateProductCategoryId,
                                updateProductBrandId);
                        int productUpdateResult = productRepositoryImplementation.updateProduct(productUpdate);
                        System.out.println("Brand updated with id = " + productUpdateResult);

                        System.out.println("\n");
                        break;

                    //delete a product
                    case 15:
                        System.out.println("Enter Product Id: ");
                        int productDeleteId = Integer.parseInt(bufferedReader.readLine());

                        int deleteProductResult = productRepositoryImplementation.deleteProduct(productDeleteId);
                        System.out.println("Deleted Product with id = " + deleteProductResult);

                        System.out.println("\n");
                        break;

                    case 16:
                        runApplication = false;
                        break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("The Application is now closing.");
    }
}
