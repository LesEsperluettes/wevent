package fr.lesesperluettes.servlets;

import fr.lesesperluettes.bdd.Activity;
import fr.lesesperluettes.bdd.ActivityManager;
import fr.lesesperluettes.bdd.User;
import fr.lesesperluettes.bdd.UserManager;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "fr.lesesperluettes.servlets.Evenement")
public class Evenement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters
        String subscribe = request.getParameter("subscribe");
        String unsubscribe = request.getParameter("unsubscribe");
        String activityId = request.getParameter("activityId");
        Map<String, String> feedback = new HashMap<String, String>();

        User user = (User) request.getSession().getAttribute("user");

        if(subscribe != null && user != null){
            // Subscribe the user to the activity
            Session sessionActivity = ActivityManager.getFactory().openSession();
            List<Activity> activities = sessionActivity.createSQLQuery("SELECT * FROM activity WHERE id = :id")
                    .setParameter("id",activityId)
                    .addEntity(Activity.class)
                    .list();

            Activity activity = activities.get(0);
            activity.getUsers().add(user);
            sessionActivity.close();

            ActivityManager activityManager = new ActivityManager();
            activityManager.update(activity);

            response.sendRedirect("/evenement?id="+activityId);
            return;
        }else{
            feedback.put("subscribe","Vous devez être connecté pour vous inscrire à un événement");
        }

        if(unsubscribe != null && user != null){
            // unSubscribe the user to the activity
            Session sessionActivity = ActivityManager.getFactory().openSession();
            List<Activity> activities = sessionActivity.createSQLQuery("SELECT * FROM activity WHERE id = :id")
                    .setParameter("id",activityId)
                    .addEntity(Activity.class)
                    .list();

            Activity activity = activities.get(0);

            activity.getUsers().remove(user);
            sessionActivity.close();

            ActivityManager activityManager = new ActivityManager();
            activityManager.update(activity);

            response.sendRedirect("/evenement?id="+activityId);
            return;
        }

        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("/evenement.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if an event is in parameter
        String id = request.getParameter("id");
        Map<String, String> feedback = new HashMap<String, String>();

        if(id != null){
            // Load event
            Session session = ActivityManager.getFactory().openSession();
            List<Activity> activities = session.createSQLQuery("SELECT * FROM activity WHERE id = :id")
                    .setParameter("id",id)
                    .addEntity(Activity.class)
                    .list();

            request.setAttribute("activity",activities.get(0));

            User user = (User) request.getSession().getAttribute("user");
            if(user != null && activities.get(0).getUsers().contains(user)){
                for(User u : activities.get(0).getUsers()){
                    if(u.getId().equals(user.getId())){
                        request.setAttribute("subscribed",true);
                        break;
                    }
                }
            }
        }

        request.setAttribute("feedback", feedback);
        this.getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
    }
}
