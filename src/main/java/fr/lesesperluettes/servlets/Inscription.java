package fr.lesesperluettes.servlets;

import fr.lesesperluettes.auth.Password;
import fr.lesesperluettes.bdd.User;
import fr.lesesperluettes.bdd.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "fr.lesesperluettes.servlets.Inscription")
public class Inscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form request
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthdate = request.getParameter("birthdate");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password_confirm");
        Map<String, String> feedback = new HashMap<String, String>();

        // Validate form (empty parameters)
        if (email == null || email.equals("")) {
            feedback.put("email", "Merci d'entrer un email");
        }
        if (name == null || name.equals("")) {
            feedback.put("name", "Merci d'entrer un nom");
        }
        if (surname == null || surname.equals("")) {
            feedback.put("surname", "Merci d'entrer un prénom");
        }
        if (birthdate == null || birthdate.equals("")) {
            feedback.put("birthdate", "Merci d'entrer une date de naissance");
        }
        if (password == null || password.equals("")) {
            feedback.put("password", "Merci d'entrer un mot de passe");
        }
        if (passwordConfirm == null || passwordConfirm.equals("")) {
            feedback.put("password_confirm", "Merci d'entrer une confirmation du mot de passe");
        }

        // Validate form (password)
        if(!password.equals(passwordConfirm)){
            feedback.put("password_confirm", "Merci d'entrer une confirmation du mot de passe");
        }

        try{
            if(feedback.size() == 0){
                // Feedback empty, create user
                User user = new User();
                user.setEmail(email);
                user.setName(name);
                user.setSurname(surname);
                user.setPassword(Password.getSaltedHash(password));
                user.setBirthdate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthdate).getTime()));

                // Save user to database
                UserManager userManager = new UserManager();
                user = userManager.addUser(user);

                // Login user
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/");
                return;
            }
        }catch(Exception e){
            feedback.put("exception","Unexpected error : "+e.getMessage());
        }
        // Send feedback and response
        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("/inscription.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
    }
}
