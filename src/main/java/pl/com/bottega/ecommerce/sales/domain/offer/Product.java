package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Product {

    private String productId;
    private String productType;
    private String productName;

    public Product(String id, String pt, String pn) {
        this.productId=id;
        this.productType=pt;
        this.productName=pn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productType, productName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass() || obj == null) {
            return false;
        }

        Product pr = (Product) obj;

        return Objects.equals(productId, pr.productId) && Objects.equals(productType, pr.productType)
                && Objects.equals(productName, pr.productName);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
