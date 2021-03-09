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
import java.util.Objects;

public class OfferItem {

    private BigDecimal productPrice;

    private Date productSnapshotDate;

    private int quantity;

    private BigDecimal totalCost;

    public Money money;
    public Discount discountObject;
    public Product product;

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType, int quantity, BigDecimal discount, String discountCause) {
        product.setProductId(productId);
        this.productPrice = productPrice;
        product.setProductName(productName);
        this.productSnapshotDate = productSnapshotDate;
        product.setProductType(productType);

        this.quantity = quantity;
        discountObject.setDiscount(discount);
        discountObject.setDiscountCause(discountCause);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalCost = productPrice.multiply(new BigDecimal(quantity)).subtract(discountValue);
    }


    @Override
    public int hashCode() {
        return Objects.hash(productPrice, productSnapshotDate, quantity, money, discountObject, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass() || obj == null) {
            return false;
        }
        OfferItem oi = (OfferItem) obj;

        return productPrice.equals(oi.productPrice) && productSnapshotDate.equals(oi.productSnapshotDate) &&
                quantity==oi.quantity && totalCost.equals(oi.totalCost)&& money.equals(oi.money) &&
                discountObject.equals(oi.discountObject)&& product.equals(oi.product);
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getProductName() == null) {
            if (other.product.getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.product.getProductName())) {
            return false;
        }
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
            return false;
        }
        if (product.getProductId() == null) {
            if (other.product.getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.product.getProductId())) {
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
