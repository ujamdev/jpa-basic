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

      Member member1 = new Member();
      member1.setName("member1");
      em.persist(member1);

      Member member2 = new Member();
      member2.setName("member2");
      em.persist(member2);

      em.flush();
      em.clear();

      //엔티티를 파라미터로 전달
      String query = "select m.name From Member m where m = :member";

      //식별자를 파라미터로 전달
      String query1 = "select m.name From Member m where m.id = :memberId";

      List<Member> result = em.createQuery(query, Member.class)
          .setParameter("member", member1)
          .getResultList();

      List<Member> result1 = em.createQuery(query, Member.class)
          .setParameter("member", member2.getId())
          .getResultList();

      System.out.println("result = " + result);
      System.out.println("result1 = " + result1);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();

  }
}