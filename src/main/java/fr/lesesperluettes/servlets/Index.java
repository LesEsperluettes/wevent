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
import java.util.List;

@WebServlet(name = "Index")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if a search text is here
        String search = request.getParameter("search");

        Session session = ActivityManager.getFactory().openSession();
        List<Activity> events = null;
        if(search == null){
            events = session.createSQLQuery("SELECT * FROM activity INNER JOIN place ON activity.place_id = place.id")
                    .addEntity("activity",Activity.class)
                    .list();
        }else{
            events = session.createSQLQuery("SELECT * FROM activity INNER JOIN place ON activity.place_id = place.id WHERE place.name LIKE :place")
                    .setParameter("place","%"+search)
                    .addEntity("activity",Activity.class)
                    .list();
        }


        request.setAttribute("events",events);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
