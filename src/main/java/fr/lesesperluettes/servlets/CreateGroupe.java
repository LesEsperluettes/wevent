package fr.lesesperluettes.servlets;

import fr.lesesperluettes.bdd.Team;
import fr.lesesperluettes.bdd.TeamManager;
import fr.lesesperluettes.bdd.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "fr.lesesperluettes.servlets.CreateGroupe")
public class CreateGroupe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // nomGroupe / descriptionGroupe / user.getSession (créateur groupe)
        Team team = new Team();
        try {
            User groupAdmin = (User) request.getSession().getAttribute("user");
            team.addMember(groupAdmin);
            String mailMember = request.getParameter("ajoutMembreGroupe");
            User member = new User();
            member.setEmail(mailMember);
            team.addMember(member);
            team.setName(request.getParameter("nomGroupe"));
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
