package fr.lesesperluettes.bdd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserManager {
    private static SessionFactory factory;

    public UserManager(){

    }

    public static SessionFactory getFactory() {
        if(factory == null){
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return factory;
    }

    public User addUser(User user){
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Integer id = (Integer) session.save(user);
            user.setId(id);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return user;
    }

    public void deleteUser(Integer id){
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            User user = session.get(User.class,id);
            session.delete(user);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(User user){
        Session session = getFactory().openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            User sessionUser = session.get(User.class,user.getId());
            sessionUser.setSurname(user.getSurname());
            sessionUser.setName(user.getName());
            sessionUser.setEmail(user.getEmail());
            sessionUser.setAge(user.getAge());
            sessionUser.setPassword(user.getPassword());

            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
