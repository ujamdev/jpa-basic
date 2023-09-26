package hellojpa;

import javax.persistence.*;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      // JPA를 사용하여 업데이트
      // Member findMember = em.find(Member.class, 1L);
      // findMember.setName("HelloJPA");

      // JPQL을 사용하여 페이지네이션
      List<Member> result = em.createQuery("select m from Member as m", Member.class)
          .setFirstResult(1)
          .setMaxResults(10)
          .getResultList();

      for (Member member : result) {
        System.out.println("member.name = " + member.getName());
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