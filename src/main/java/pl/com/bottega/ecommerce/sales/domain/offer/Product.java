package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Product {

    private final String productId;
    private final String productName;
    private final String productType;
    private final Money price;

    public Product(String productId, String productName, String productType, Money price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
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

    public Money getPrice() {
        return price;
    }
}
