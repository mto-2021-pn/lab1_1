/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

class Money{
    private String currency;
    private BigDecimal amount;

    Money(String currency, BigDecimal amount){
        this.currency = currency;
        this.amount = amount;
    }

    Money(){ }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.currency == null ? 0 : this.currency.hashCode());
        result = prime * result + (this.amount == null ? 0 : this.amount.hashCode());
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
        Money other = (Money) obj;
        if (this.getAmount() == null) {
            if (other.getAmount() != null) {
                return false;
            }
        } else if (!this.getAmount().equals(other.getAmount())) {
            return false;
        }
        if (this.getCurrency() == null) {
            if (other.getCurrency() != null) {
                return false;
            }
        } else if (!this.getCurrency().equals(other.getCurrency())) {
            return false;
        }
        return true;
    }
}

class Discount{
    private String discountCause;
    private BigDecimal discount;

    Discount(String discountCause, BigDecimal discount){
        this.discountCause = discountCause;
        this.discount = discount;
    }

    Discount(){ }

    public String getDiscountCause() {
        return discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.discountCause == null ? 0 : this.discountCause.hashCode());
        result = prime * result + (this.discount == null ? 0 : this.discount.hashCode());
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
        Discount other = (Discount) obj;
        if (this.getDiscount() == null) {
            if (other.getDiscount() != null) {
                return false;
            }
        } else if (!this.getDiscount().equals(other.getDiscount())) {
            return false;
        }
        if (this.getDiscountCause() == null) {
            if (other.getDiscountCause() != null) {
                return false;
            }
        } else if (!this.getDiscountCause().equals(other.getDiscountCause())) {
            return false;
        }
        return true;
    }
}

class Product{
    private String id;
    private BigDecimal price;
    private String name;
    private Date snapshotDate;
    private String type;

    Product(String id, BigDecimal price, String name, Date snapshotDate, String type){
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    Product() { }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.getName() == null ? 0 : this.getName().hashCode());
        result = prime * result + (this.getPrice() == null ? 0 : this.getPrice().hashCode());
        result = prime * result + (this.getId() == null ? 0 : this.getId().hashCode());
        result = prime * result + (this.getType() == null ? 0 : this.getType().hashCode());
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
        if (this.getName() == null) {
            if (other.getName() != null) {
                return false;
            }
        } else if (!this.getName().equals(other.getName())) {
            return false;
        }
        if (this.getPrice() == null) {
            if (other.getPrice() != null) {
                return false;
            }
        } else if (!this.getPrice().equals(other.getPrice())) {
            return false;
        }
        if (this.getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!this.getId().equals(other.getId())) {
            return false;
        }
        if (this.getType() != other.getType()) {
            return false;
        }
        return true;
    }
}

public class OfferItem {

    private Product product;

    private int quantity;

    private BigDecimal totalCost;

    private Money currency;

    private Discount discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null, null);
    }

    public OfferItem(Product product, int quantity, Discount discount, Money money) {

        this.product = product;

        this.quantity = quantity;

        this.discount = discount;

        this.currency = money;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getDiscount());
        }

        this.totalCost = product.getPrice().multiply(new BigDecimal(quantity)).subtract(discountValue);
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Money getCurrency() {
        return currency;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        result = prime * result + (product == null ? 0 : product.hashCode());
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
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }
        if (currency == null) {
            if (other.currency != null) {
                return false;
            }
        } else if (!currency.equals(other.currency)) {
            return false;
        }
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            if (other.totalCost != null) {
                return false;
            }
        } else if (!totalCost.equals(other.totalCost)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
