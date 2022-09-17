import Entity.Brand;
import Entity.Category;
import Entity.Product;
import JdbcConfig.JdbcConfig;
import RepositoryImplementation.BrandRepositoryImplementation;
import RepositoryImplementation.CategoryRepositoryImplementation;
import RepositoryImplementation.ProductRepositoryImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for(int i = 0; i < categories.size(); i++){
                        System.out.println(categories.get(i).getCategoryId() + " " + categories.get(i).getCategoryName());
                    }
                    break;

                case 2:
                    System.out.println("Enter Category Id: ");
                    int choiceCategory = scanner.nextInt();
                    Category category = categoryRepositoryImplementation.getCategory(choiceCategory);
                    System.out.println(category.getCategoryId() + " " + category.getCategoryName());
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
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
