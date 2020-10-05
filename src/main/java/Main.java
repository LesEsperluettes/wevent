import fr.lesesperluettes.bdd.User;
import fr.lesesperluettes.bdd.UserManager;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {

    public static void main(final String[] args) throws Exception {
        UserManager userManager = new UserManager();
        User user = new User();
        user.setName("POUPELIN2");
        user.setSurname("Alexis");
        user.setAge(20);
        user.setEmail("alexis.poupelin@viacesi.fr");

        User rt = userManager.addUser(user);
        System.out.println(rt);
    }
}