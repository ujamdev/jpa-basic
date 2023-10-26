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

      List<Member> result = em.createQuery("select case when m.age <= 19 then '학생요금' when m.age >= 60 then '경로요금' else '일반요금' end from Member m", Member.class)
          .getResultList();

      System.out.println("result = " + result);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();

  }
}