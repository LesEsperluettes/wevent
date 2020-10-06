import fr.lesesperluettes.auth.Password;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form request
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Map<String, String> feedback = new HashMap<String, String>();

        // Check for missing fields
        if (login == null || login.equals("")) {
            feedback.put("login", "Merci d'entrer un login");
        }
        if (password == null || password.equals("")) {
            feedback.put("password", "Merci d'entrer un mot de passe");
        }

        if (feedback.size() == 0) {
            //No feedback, try to login the user
            UserManager userManager = new UserManager();
            Session session = userManager.getFactory().openSession();
            try{
                List users = session.createSQLQuery("SELECT * FROM user WHERE email = :email")
                        .setParameter("email", login)
                        .addEntity(User.class)
                        .list();

                if (users.isEmpty()) {
                    feedback.put("login", "Cette combinaison mot de passe login ne correspond à aucun compte, merci de réessayer");
                } else {
                    User user = (User) users.get(0);
                    //Check password
                    if(Password.check(password,user.getPassword())){
                        //Password correct, auth user in session
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("/");
                        return;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                session.close();
            }
        }

        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
