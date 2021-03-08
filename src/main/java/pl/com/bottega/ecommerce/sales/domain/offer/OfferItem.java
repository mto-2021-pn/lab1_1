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
  private final int quantity;

  private Product product;

  private Discount discount;

  private Money money;

  public OfferItem(
      String productId,
      BigDecimal productPrice,
      String currency,
      String productName,
      Date productSnapshotDate,
      String productType,
      int quantity,
      BigDecimal discount,
      String discountCause) {
    this.product =
        new Product(
            productId,
            productType,
            productName,
            productSnapshotDate,
            new Money(productPrice, currency));
    this.discount = new Discount(discountCause, discount);
    this.quantity = quantity;

    BigDecimal discountValue = new BigDecimal(0);
    if (discount != null) {
      discountValue = discountValue.subtract(discount);
    }

    this.money =
        new Money(
            productPrice.multiply(new BigDecimal(quantity)).subtract(discountValue), currency);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (discount == null ? 0 : discount.hashCode());
    result = prime * result + (product.getName() == null ? 0 : product.getName().hashCode());
    result = prime * result + (product.getPrice() == null ? 0 : product.getPrice().hashCode());
    result = prime * result + (product.getId() == null ? 0 : product.getId().hashCode());
    result = prime * result + (product.getType() == null ? 0 : product.getType().hashCode());
    result = prime * result + quantity;
    result = prime * result + (money.getPrice() == null ? 0 : money.getPrice().hashCode());
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
    if (product.getName() == null) {
      if (other.product.getName() != null) {
        return false;
      }
    } else if (!product.getName().equals(other.product.getName())) {
      return false;
    }
    if (product.getPrice() == null) {
      if (other.product.getPrice() != null) {
        return false;
      }
    } else if (!product.getPrice().equals(other.product.getPrice())) {
      return false;
    }
    if (product.getId() == null) {
      if (other.product.getId() != null) {
        return false;
      }
    } else if (!product.getId().equals(other.product.getId())) {
      return false;
    }
    if (product.getType() != other.product.getType()) {
      return false;
    }
    if (quantity != other.quantity) {
      return false;
    }
    if (money.getPrice() == null) {
      if (other.money.getPrice() != null) {
        return false;
      }
    } else if (!money.getPrice().equals(other.money.getPrice())) {
      return false;
    }
    return true;
  }

  /**
   * @param item
   * @param delta acceptable percentage difference
   * @return
   */
  public boolean sameAs(OfferItem other, double delta) {
    if (product.getName() == null) {
      if (other.product.getName() != null) {
        return false;
      }
    } else if (!product.getName().equals(other.product.getName())) {
      return false;
    }
    if (product.getPrice() == null) {
      if (other.product.getPrice() != null) {
        return false;
      }
    } else if (!product.getPrice().equals(other.product.getPrice())) {
      return false;
    }
    if (product.getId() == null) {
      if (other.product.getId() != null) {
        return false;
      }
    } else if (!product.getId().equals(other.product.getId())) {
      return false;
    }
    if (product.getType() != other.product.getType()) {
      return false;
    }

    if (quantity != other.quantity) {
      return false;
    }

    BigDecimal max;
    BigDecimal min;
    if (money.getPrice().compareTo(other.money.getPrice()) > 0) {
      max = money.getPrice();
      min = other.money.getPrice();
    } else {
      max = other.money.getPrice();
      min = money.getPrice();
    }

    BigDecimal difference = max.subtract(min);
    BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

    return acceptableDelta.compareTo(difference) > 0;
  }

  public String getProductId() {
    return product.getId();
  }
}
