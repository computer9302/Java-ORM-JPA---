package hellojpa.jpql;

import javax.persistence.*;

import static org.h2.index.ViewIndex.setParameter;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            Member result = em.createQuery("select m from Member m where m.username= : username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();
            System.out.println("singleResult = " + result.getUsername());

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
