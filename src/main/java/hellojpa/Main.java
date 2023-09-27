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
      
      //비영속
      Member member = new Member();
      member.setId(100L);
      member.setName("HelloJPA");

      //영속 (객체를 저장한 상태)
      em.persist(member);
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}