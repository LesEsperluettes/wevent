package fr.lesesperluettes.bdd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeamManager {
    private static SessionFactory factory;

    public TeamManager(){
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Team.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public Team create(Team team){
        Session session = factory.openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Integer id = (Integer) session.save(team);
            team.setId(id);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return team;
    }

    public void delete(Integer id){
        Session session = factory.openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Team team = session.get(Team.class,id);
            session.delete(team);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Team team){
        Session session = factory.openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Team sessionGroup = session.get(Team.class,team.getId());
            sessionGroup.setMembers(team.getMembers());
            sessionGroup.setName(team.getName());

            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
