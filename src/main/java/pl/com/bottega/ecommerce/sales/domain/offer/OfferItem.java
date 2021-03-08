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

public class OfferItem {

    private Product product;

    private Date productSnapshotDate;

    private int quantity;

    private Money offerCost;

    private Discount discount;

    public OfferItem(Product product, Date productSnapshotDate, int quantity) {
        this(product, productSnapshotDate, quantity, null, "zloty");
    }

    public OfferItem(Product product, Date productSnapshotDate, int quantity, Discount discount, String currency) {

        this.product = product;
        this.productSnapshotDate = productSnapshotDate;

        this.quantity = quantity;
        this.discount = discount;

        BigDecimal totalCost = product.getProductPrice().getAmount().multiply(new BigDecimal(quantity));
        if (discount != null) {
            totalCost = totalCost.multiply(discount.getDiscountRate());
        }

        this.offerCost = new Money(totalCost, currency);
    }

    public Product getProduct() {
        return product;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public Money getOfferCost() {
        return offerCost;
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
        result = prime * result + (product == null ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + (offerCost == null ? 0 : offerCost.hashCode());
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
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (offerCost == null) {
            if (other.offerCost != null) {
                return false;
            }
        } else if (!offerCost.equals(other.offerCost)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param other
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {

        if (quantity != other.quantity) {
            return false;
        }

        if(!product.sameAs(other.product)) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (offerCost.getAmount().compareTo(other.offerCost.getAmount()) > 0) {
            max = offerCost.getAmount();
            min = other.offerCost.getAmount();
        } else {
            max = other.offerCost.getAmount();
            min = offerCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
