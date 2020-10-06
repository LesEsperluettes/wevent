package fr.lesesperluettes.servlets;

import fr.lesesperluettes.bdd.Activity;
import fr.lesesperluettes.bdd.ActivityManager;
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
        }

        request.setAttribute("feedback", feedback);
        this.getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
    }
}
