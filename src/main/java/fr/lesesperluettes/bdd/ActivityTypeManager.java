package fr.lesesperluettes.bdd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ActivityTypeManager {

    private static SessionFactory factory;

    public ActivityTypeManager(){

    }

    public static SessionFactory getFactory() {
        if(factory == null){
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(ActivityType.class)
                    .buildSessionFactory();
        }
        return factory;
    }

    public ActivityType addActivityType(ActivityType activityType) {
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Integer id = (Integer) session.save(activityType);
            activityType.setId(id);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return activityType;
    }

    public void deleteActivityType(Integer id){
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            ActivityType activityType = session.get(ActivityType.class,id);
            session.delete(activityType);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(ActivityType activityType){
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            ActivityType sessionActivityType = session.get(ActivityType.class,activityType.getId());
            sessionActivityType.setName(activityType.getName());
            sessionActivityType.setDescription(activityType.getDescription());
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
