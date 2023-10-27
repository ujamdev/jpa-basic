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
      member2.setName("member1");
      em.persist(member2);

      em.flush();
      em.clear();

      String query1 = "select concat('a', 'b') From Member m";
      String query2 = "select substring(m.name, 2, 3) From Member m";
      String query3 = "select locate('de','abcdegf') From Member m";

      List<Member> result1 = em.createQuery(query1, Member.class)
          .getResultList();
      List<Member> result2 = em.createQuery(query2, Member.class)
              .getResultList();
      List<Integer> result3 = em.createQuery(query3, Integer.class)
              .getResultList();

      System.out.println("result = " + result1);
      System.out.println("result = " + result2);
      System.out.println("result = " + result3);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();

  }
}