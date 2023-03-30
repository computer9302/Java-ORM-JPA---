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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);


            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);


            em.flush();
            em.clear();


            Member m = em.find(Member.class, member1.getId());
            System.out.println("member = " + m.getClass());

            System.out.println("team = " + m.getTeam().getClass());

            System.out.println("=======================");
            System.out.println(m.getTeam().getName());
            System.out.println("=======================");


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
