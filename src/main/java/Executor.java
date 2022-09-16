import Entity.Category;
import JdbcConfig.JdbcConfig;
import RepositoryImplementation.CategoryRepositoryImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Executor {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
        CategoryRepositoryImplementation categoryRepositoryImplementation =
                applicationContext
                        .getBean("getCategoryRepositoryImplementation",
                        CategoryRepositoryImplementation.class);

        System.out.println("==================Welcome to Demo Inventory=================");
        System.out.println("\n\n\n");

        List<Category>categories = categoryRepositoryImplementation.getAllCategories();
        System.out.println("Total Categories : " + categories.size());

//        for(int i = 0; i < categories.size(); i++){
//            System.out.println(categories.get(i).getCategoryId() + " " + categories.get(i).getCategoryName());
//        }

    }
}
