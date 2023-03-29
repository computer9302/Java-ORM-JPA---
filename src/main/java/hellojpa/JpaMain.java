package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();


            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference = " + reference.getClass());
            //reference.getUsername();
            System.out.println("isLoaded = "+emf.getPersistenceUnitUtil().isLoaded(reference));
            org.hibernate.Hibernate.initialize(reference);

            //em.detach(reference);
            //em.close();
            em.clear();

            reference.getUsername();


            tx.commit();
        }catch(Exception e){
            tx.rollback();
            System.out.println("e = " + e);
        }finally {
            em.close();
        }

        emf.close();
    }
}
