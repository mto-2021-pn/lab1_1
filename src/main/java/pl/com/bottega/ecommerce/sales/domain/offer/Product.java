package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
    private String id;
    private String type;
    private String name;
    private Money cost;
    private Date snapshotDate;

    public Product(String id, String type, String name, Money cost, Date snapshotDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.snapshotDate = snapshotDate;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Money getCost() {
        return cost;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 :name.hashCode());
        result = prime * result + (cost == null ? 0 : cost.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        return result;
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
        } else if (!cost.getAmount().equals(other.cost.getAmount())) {
            return false;
        }

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }
}
