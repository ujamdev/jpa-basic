package hellojpa;

import hellojpa.domain.Address;
import hellojpa.domain.Member;

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
      em.persist(member);

      TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
      TypedQuery<Member> query2 = em.createQuery("select m.username from Member m", Member.class);
      Query query3 = em.createQuery("select m.username from Member m");


      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();

  }
}