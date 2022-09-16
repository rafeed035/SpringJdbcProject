package Entity;

public class Brand {
    private int brandId;
    private String brandName;
    private int category_id;

    public Brand(int brandId, String brandName, int category_id) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.category_id = category_id;
    }

    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
