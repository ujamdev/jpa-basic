package hellojpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member extends BaseEntity {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String name;

  @Embedded
  private Address homeAddress;

  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
      @JoinColumn(name = "MEMBER_ID")
  )
  @Column(name = "FOOD_NAME")
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "ADDRESS", joinColumns =
      @JoinColumn(name = "MEMBER_ID")
  )
  @Column(name = "FOOD_NAME")
  private List<Address> addressHistory = new ArrayList<>();

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
