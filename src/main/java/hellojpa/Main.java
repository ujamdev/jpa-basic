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

      List<MemberDTO> result = em.createQuery("select m from Member m order by m.age desc", MemberDTO.class)
          .setFirstResult(1)
          .setMaxResults(10)
          .getResultList();

      System.out.println("result.size = " + result.size());

      for (MemberDTO member1 : result) {
        System.out.println("member1 = " + member1);
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();

  }
}