import fr.lesesperluettes.bdd.ActivityType;
import fr.lesesperluettes.bdd.ActivityTypeManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class CreateEvent extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ActivityTypeManager activityTypeManager = new ActivityTypeManager();

        Session session = activityTypeManager.getFactory().openSession();
        session.beginTransaction();
        List<ActivityType> activitiesTypes = session.createSQLQuery("SELECT * FROM ACTIVITYTYPE")
                .addEntity(ActivityType.class)
                .list();
        request.setAttribute("activities", activitiesTypes);
        System.out.println(activitiesTypes.size());
        this.getServletContext().getRequestDispatcher("/create_event.jsp").forward(request, response);
        session.close();
    }
}
