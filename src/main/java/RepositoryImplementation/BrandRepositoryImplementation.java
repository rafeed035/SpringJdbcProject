package RepositoryImplementation;

import Entity.Brand;
import Repositories.BrandRepository;
import RowMapperImplementation.BrandRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class BrandRepositoryImplementation implements BrandRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertBrand(Brand brand) {
        String insertQuery = "insert into brand(brand_id, brand_name, category_id) values(?, ?, ?)";
        int insertResult = jdbcTemplate.update(insertQuery,
                brand.getBrandId(),
                brand.getBrandName(),
                brand.getCategory_id());
        return insertResult;
    }

    @Override
    public int updateBrand(Brand brand) {
        String updateQuery = "update brand set brand_name = ? where brand_id = ?";
        int updateResult = jdbcTemplate.update(updateQuery,
                brand.getBrandName(),
                brand.getBrandId());
        return updateResult;
    }

    @Override
    public int deleteBrand(int brandId) {
        String deleteQuery = "delete from brand where brand_id = ?";
        int deleteResult = jdbcTemplate.update(deleteQuery, brandId);
        return deleteResult;
    }

    @Override
    public Brand getBrand(int brandId) {
        String getBrandQuery = "select * from brand where brand_id = ?";
        RowMapper<Brand> rowMapper = new BrandRowMapper();
        Brand brand = jdbcTemplate.queryForObject(getBrandQuery,rowMapper, brandId);
        return brand;
    }

    @Override
    public List<Brand> getAllBrands() {
        String getAllBrandsQuery = "select * from brand";
        RowMapper<Brand> rowMapper = new BrandRowMapper();
        List<Brand>brands = jdbcTemplate.query(getAllBrandsQuery, rowMapper);
        return brands;
    }
}
