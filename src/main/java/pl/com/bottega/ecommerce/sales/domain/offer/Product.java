package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Product {

    private String id;
    private String name;
    private String type;
    private Money productPrice;

    public Product(String id, Money productPrice, String name, String type) {
        this.id = id;
        this.productPrice = productPrice;
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Product other = (Product) obj;
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (productPrice == null ? 0 : productPrice.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        return result;
    }

    /**
     *
     * @param other
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(Product other) {
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (!type.equals(other.type)) {
            return false;
        }

        return true;
    }

    public String getId() {
        return id;
    }

    public Money getProductPrice() {
        return productPrice;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
