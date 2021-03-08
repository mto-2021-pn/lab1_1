package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String id;

    private Money price;

    private String name;
    
    private String type;

    private Date snapshotDate;

    public Product(String id, Money price, String name, String type, Date snapshotDate) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.snapshotDate = snapshotDate;
    }

    public String getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                price.equals(product.price) &&
                name.equals(product.name) &&
                type.equals(product.type) &&
                snapshotDate.equals(product.snapshotDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (price == null ? 0 : price.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + ( type == null ? 0 : type.hashCode());
        return result;
    }


    public boolean sameAs(Product other){
        if (name == null) {
            if (other.getName() != null) {
                return false;
            }
        } else if (!name.equals(other.getName())) {
            return false;
        }

        if (price == null) {
            if (other.getPrice() != null) {
                return false;
            }
        } else if (!price.equals(other.getPrice())) {
            return false;
        }

        if (id == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!id.equals(other.getId())) {
            return false;
        }

        if (type != other.getType()) {
            return false;
        }

        return true;
    }

}
