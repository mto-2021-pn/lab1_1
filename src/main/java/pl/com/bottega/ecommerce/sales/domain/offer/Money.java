package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Money {
    private String currency;

    public Money(String c) {
        setCurrency(c);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode(){
        return Objects.hash(currency);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass() || obj == null) {
            return false;
        }

        Money m = (Money) obj;

        return  Objects.equals(currency,m.currency);
    }
}
