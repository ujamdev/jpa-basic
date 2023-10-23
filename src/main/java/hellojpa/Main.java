package hellojpa;

import hellojpa.domain.Address;
import hellojpa.domain.Member;
import hellojpa.domain.MemberDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Member member = new Member();
      member.setName("member1");
      member.setAge(10);
      em.persist(member);

      em.flush();
      em.clear();

      List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.name, m.age) from Member m", MemberDTO.class)
          .getResultList();

      MemberDTO memberDTO = result.get(0);
      System.out.println("memberDTO = " + memberDTO.getName());
      System.out.println("memberDTO = " + memberDTO.getAge());
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();

  }
}