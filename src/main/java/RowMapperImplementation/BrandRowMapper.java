package RowMapperImplementation;

import Entity.Brand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
        Brand brand = new Brand();
        brand.setBrandId(rs.getInt("brand_id"));
        brand.setBrandName(rs.getString("brand_name"));
        brand.setCategory_id(rs.getInt("brand_category_id"));
        return brand;
    }
}
