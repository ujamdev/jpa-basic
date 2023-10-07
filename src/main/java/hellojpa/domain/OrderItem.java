package hellojpa.domain;

import javax.persistence.*;

@Entity
public class OrderItem {
  @Id @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;
  @ManyToOne
  @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
  private Order order;
  @ManyToOne
  @JoinColumn(name = "ITEM_ID", insertable = false, updatable = false)
  private Item item;
  private int orderPrice;
  private int count;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public int getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(int orderPrice) {
    this.orderPrice = orderPrice;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}