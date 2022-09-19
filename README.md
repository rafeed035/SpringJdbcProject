# SpringJdbcProject
A basic demo shop inventory project using spring jdbc. 
The project will demonstrate the basic crud operations.

Technologies used - Java, Spring Framework, MySQL database.

**How to run the application:**
1. Clone/Download the project.
2. Import/Open the project in any IDE (example - Intellij IDEA [community/ultimate], NetBeans, etc).
3. Open MySQL workbench or any other MySQL work environment.
4. Create a database and name it - "spring_core_db"
5. Create the category, brand, and the product table.
6. To Create the **category** table copy-paste and run the following on the MySQL workbench- 
`     create table category(
            category_id int primary key not null,
            category_name varchar(100) not null
     );`
7. To create the **brand** table copy-paste and run the following on the MySQL workbench-
`     create table brand(
            brand_id int primary key not null,
            brand_name varchar(100) not null,
            brand_category_id int,

            foreign key(brand_category_id)
            references category(category_id)
            on delete cascade
            on update cascade
     );`
8. To create the **product** table copy-paste and run the following on the MySQL workbench-
`     create table product(
            product_id int primary key not null,
            product_name varchar(100) not null,
            product_price int not  null,
            product_category_id int not null,
            product_brand_id int,

            foreign key(product_category_id)
            references category(category_id)
            on delete cascade
            on update cascade,

            foreign key(product_brand_id)
            references brand(brand_id)
            on delete cascade
            on update cascade
     );`
9. Open the Project file, and go to the class - JdbcConfig.class under the JdbcConfig package.
10. Find the following bean, and change the **userName** and the **password** to **your MySQL userName and password**.
`    @Bean
    public DriverManagerDataSource getDriverManagerDataSource(){
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_core_db");
    driverManagerDataSource.setUsername("<_Your user name_>");
    driverManagerDataSource.setPassword("<_Your password_>");

        return driverManagerDataSource;
    }`
11. Run the application.
