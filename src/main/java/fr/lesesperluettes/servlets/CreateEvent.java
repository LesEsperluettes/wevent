package fr.lesesperluettes.servlets;

import fr.lesesperluettes.bdd.*;
import jdk.jfr.events.ExceptionThrownEvent;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.loader.custom.sql.SQLQueryParser;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateEvent extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Activity activity = new Activity();
        try {
            activity.setName(request.getParameter("nomEvenement"));
            activity.setDescription(request.getParameter("descriptionEvenement"));
            activity.setImagePath(request.getParameter("imageIllustration"));
            String startDate = (request.getParameter("dateEvenementDebut"));
            String endDate = (request.getParameter("dateEvenementFin"));
            String location = request.getParameter("lieuEvenement");
            Map<String, String> feedback = new HashMap<String, String>();
            Place place = new Place();
            place.setName(location);
            activity.setPlace(place);
            String sActivityType = request.getParameter("activityType");
            ActivityType activityType = new ActivityType();
            activityType.setName(sActivityType);
            activity.setActivityType(activityType);
            activity.setStartDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(startDate).getTime()));
            activity.setEndDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(endDate).getTime()));
            ActivityManager activityManager = new ActivityManager();
            activityManager.addActivity(activity);
            response.sendRedirect("/evenement?id=" +activity.getId());
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.getServletContext().getRequestDispatcher("/create_event.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ActivityTypeManager activityTypeManager = new ActivityTypeManager();

        Session session = activityTypeManager.getFactory().openSession();
        session.beginTransaction();
        List<ActivityType> activitiesTypes = session.createSQLQuery("SELECT * FROM ACTIVITYTYPE")
                .addEntity(ActivityType.class)
                .list();
        List<String> map = new ArrayList<String>();
        for (int i = 0; i < activitiesTypes.size(); i++) {
            String activityType = activitiesTypes.get(i).getName();
            map.add(activityType);
        }
        request.setAttribute("activitiesTypes", map);
        this.getServletContext().getRequestDispatcher("/create_event.jsp").forward(request, response);
    }
}
