package pl.com.bottega.ecommerce.sales.domain.offer;

public class Product {

    private final String productId;
    private final String productName;
    private final String productType;

    public Product(String productId, String productName, String productType) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }
}
