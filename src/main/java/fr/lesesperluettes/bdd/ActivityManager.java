package fr.lesesperluettes.bdd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ActivityManager {
    private static SessionFactory factory;

    public ActivityManager(){

    }

    public static SessionFactory getFactory() {
        if(factory == null){
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Activity.class)
                    .buildSessionFactory();
        }
        return factory;
    }

    public Activity addActivity(Activity activity){
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Integer id = (Integer) session.save(activity);
            activity.setId(id);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return activity;
    }

    public void deleteUser(Integer id){
        Session session = getFactory().openSession();
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            Activity act = session.get(Activity.class,id);
            session.delete(act);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Activity act){
        Session session = getFactory().openSession();
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            Activity sessionActivity = session.get(Activity.class,act.getId());
            sessionActivity.setName(act.getName());
            sessionActivity.setPlace(act.getPlace());
            sessionActivity.setUsers(act.getUsers());
            sessionActivity.setActivityType(act.getActivityType());

            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}