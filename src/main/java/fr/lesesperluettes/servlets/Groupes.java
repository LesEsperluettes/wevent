package fr.lesesperluettes.servlets;

import fr.lesesperluettes.bdd.Team;
import fr.lesesperluettes.bdd.TeamManager;
import fr.lesesperluettes.bdd.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "fr.lesesperluettes.servlets.Groupes")
public class Groupes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            Session session = TeamManager.getFactory().openSession();
            List<Team> teamList = session
                    .createSQLQuery("SELECT * FROM team INNER JOIN userteam ON team.id = userteam.team_id INNER JOIN user ON userteam.user_id = user.id WHERE user.id = :user_id")
                    .setParameter("user_id",user.getId())
                    .addEntity(Team.class)
                    .list();

            request.setAttribute("teams",teamList);
            session.close();
        }
        this.getServletContext().getRequestDispatcher("/groupes.jsp").forward(request, response);

    }
}
