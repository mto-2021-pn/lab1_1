package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private String discountCause;
    private BigDecimal discount;

    public Discount(String dc, BigDecimal d) {
        setDiscountCause(dc);
        setDiscount(d);
    }

    @Override
    public int hashCode(){
        return Objects.hash(discountCause,discount);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass() || obj == null) {
            return false;
        }

        Discount d = (Discount) obj;
        return discount.equals(d.discount) && discountCause.equals(d.discountCause);
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
