package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (getProductName() == null) {
            if (other.getProductName() != null) {
                return false;
            }
        } else if (!getProductName().equals(other.getProductName())) {
            return false;
        }
        if (getPrice() == null) {
            if (other.getPrice() != null) {
                return false;
            }
        } else if (!getPrice().equals(other.getPrice())) {
            return false;
        }
        if (getProductId() == null) {
            if (other.getProductId() != null) {
                return false;
            }
        } else if (!getProductId().equals(other.getProductId())) {
            return false;
        }
        return getProductType().equals(other.getProductType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productType, price);
    }


}
