package fr.lesesperluettes.bdd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PlaceManager {

    private static SessionFactory factory;

    public PlaceManager(){
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Place.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public Place addPlace(Place place){
        Session session = factory.openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Integer id = (Integer) session.save(place);
            place.setId(id);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return place;
    }

    public void deleteplace(Integer id){
        Session session = factory.openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Place place = session.get(Place.class,id);
            session.delete(place);
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Place place){
        Session session = factory.openSession();
        Transaction tr = null;

        try{
            tr = session.beginTransaction();
            Place sessionplace = session.get(Place.class,place.getId());
            sessionplace.setName(place.getName());
            sessionplace.setAddress(place.getAddress());
            tr.commit();
        }catch(HibernateException e){
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
