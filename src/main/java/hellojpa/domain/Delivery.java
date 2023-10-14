package hellojpa.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

  @Id @GeneratedValue
  private Long id;

  private String city;

  private String street;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery")
  private Order order;
}
