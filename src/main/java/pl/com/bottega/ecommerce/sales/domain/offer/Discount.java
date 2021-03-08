package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String discountCause;
    private BigDecimal discountRate;

    public Discount(String discountCause, BigDecimal discountRate) {
        this.discountCause = discountCause;
        this.discountRate = discountRate;
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
        if (discountRate == null) {
            if (other.discountRate != null) {
                return false;
            }
        } else if (!discountRate.equals(other.discountRate)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discountRate == null ? 0 : discountRate.hashCode());
        return result;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public String getDiscountCause() {
        return discountCause;
    }
}
