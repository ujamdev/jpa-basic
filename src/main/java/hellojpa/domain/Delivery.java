package hellojpa.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity {

  @Id @GeneratedValue
  private Long id;

  private String city;

  private String street;

  @OneToOne(fetch = LAZY, mappedBy = "delivery")
  private Order order;
}
