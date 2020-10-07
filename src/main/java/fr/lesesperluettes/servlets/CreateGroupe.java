package fr.lesesperluettes.servlets;

import fr.lesesperluettes.bdd.Team;
import fr.lesesperluettes.bdd.TeamManager;
import fr.lesesperluettes.bdd.User;
import fr.lesesperluettes.bdd.UserManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "fr.lesesperluettes.servlets.CreateGroupe")
public class CreateGroupe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // nomGroupe / descriptionGroupe / user.getSession (créateur groupe)
        Team team = new Team();
        try {
            team.setName(request.getParameter("nomGroupe"));

            User groupAdmin = (User) request.getSession().getAttribute("user");

            Session session = UserManager.getFactory().openSession();
            List<User> users = session.createSQLQuery("SELECT * FROM user WHERE id = :id")
                    .setParameter("id",groupAdmin.getId())
                    .addEntity(User.class)
                    .list();

            groupAdmin = users.get(0);
            team.addMember(groupAdmin);
            session.close();

            String mailMember = request.getParameter("ajoutMembreGroupe");
            if(mailMember != null && !mailMember.equals("")){
                List<User> users2 = session.createSQLQuery("SELECT * FROM user WHERE email = :email")
                        .setParameter("email",mailMember)
                        .addEntity(User.class)
                        .list();

                team.addMember(users2.get(0));
            }

            TeamManager teamManager = new TeamManager();
            teamManager.create(team);

            response.sendRedirect("/groupes");
            return;
        }catch(Exception e){
            System.out.println("Error " +e.getMessage());
        }
        this.getServletContext().getRequestDispatcher("/create_groupe.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/create_groupe.jsp").forward(request, response);
    }
}
