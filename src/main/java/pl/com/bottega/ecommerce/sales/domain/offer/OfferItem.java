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
    private int quantity;
    private Money totalCost;
    private Discount discount;


    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getDiscount());
        }

        this.totalCost.setAmount( product.getPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountValue)  );
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + (product == null ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
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
            if (other.getDiscount() != null) {
                return false;
            }
        } else if (!discount.equals(other.getDiscount())) {
            return false;
        }

        if (product == null) {
            if (other.getProduct() != null) {
                return false;
            }
        } else if (!product.equals(other.getProduct())) {
            return false;
        }

        if (quantity != other.getQuantity()) {
            return false;
        }

        if (totalCost == null) {
            if (other.getTotalCost() != null) {
                return false;
            }
        } else if (!totalCost.equals(other.getTotalCost())) {
            return false;
        }

        return true;
    }


    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {

        if(!product.sameAs(other.getProduct()))
            return false;

        if (quantity != other.getQuantity()) {
            return false;
        }


        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.getTotalCost()) > 0) {
            max = totalCost.getAmount();
            min = other.getTotalCost().getAmount();
        } else {
            max = other.getTotalCost().getAmount();
            min = totalCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }


    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Discount getDiscount() {
        return discount;
    }
}
