package hellojpa.domain;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String name;

  @Embedded
  private Address homeAddress;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }
}
