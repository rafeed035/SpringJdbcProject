package RepositoryImplementation;

import Entity.Brand;
import Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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

        return null;
    }

    @Override
    public List<Brand> getAllBrands() {
        return null;
    }
}
