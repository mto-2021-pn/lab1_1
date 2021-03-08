package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
  private String id;
  private String type;
  private String name;
  private Date productSnapshotDate;
  private Money price;

  public Product(String id, String type, String name, Date productSnapshotDate, Money price) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.productSnapshotDate = productSnapshotDate;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getProductSnapshotDate() {
    return productSnapshotDate;
  }

  public void setProductSnapshotDate(Date productSnapshotDate) {
    this.productSnapshotDate = productSnapshotDate;
  }

  public Money getPrice() {
    return price;
  }

  public void setPrice(Money price) {
    this.price = price;
  }
}
