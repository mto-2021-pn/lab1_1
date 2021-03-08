package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String id;

    private Money cost;

    private String name;

    private String type;

    private Date snapshotDate;

    public Product(String id, BigDecimal price, String name, String type, Date snapshotDate) {
        this.id = id;
        this.cost = new Money(cost.getAmount(), "EUR");
        this.name = name;
        this.type = type;
        this.snapshotDate = snapshotDate;
    }

    public String getId() {
        return id;
    }

    public Money getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product other = (Product) o;
        if (name == null) {
            if (other.getName() != null) {
                return false;
            }
        } else if (!name.equals(other.getName())) {
            return false;
        }
        if (cost.getAmount() == null) {
            if (other.cost.getAmount() != null) {
                return false;
            }
        } else if (cost.getAmount()
                       .equals(other.cost.getAmount())) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + cost.hashCode();
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        return result;
    }

    public boolean sameAs(Product other) {
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (cost.getAmount() == null) {
            if (other.cost.getAmount() != null) {
                return false;
            }
        } else if (!cost.getAmount()
                        .equals(other.cost.getAmount())) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }
}
