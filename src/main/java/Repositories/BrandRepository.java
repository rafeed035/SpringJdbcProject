package Repositories;

import Entity.Brand;

import java.util.List;

public interface BrandRepository{
    int insertBrand(Brand brand);
    int updateBrand(Brand brand);
    int deleteBrand(int brandId);
    Brand getBrand(int brandId);
    List<Brand>getAllBrands();
}
