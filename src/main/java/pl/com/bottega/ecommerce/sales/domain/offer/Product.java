package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
    private String id;
    private String name;
    private String type;
    private Date productSnapshotDate;

    private Money price;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Money getPrice() {
        return price;
    }

    public Product(String id, String name, String type, Money price, Date productSnapshotDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.productSnapshotDate = productSnapshotDate;
    }
}
