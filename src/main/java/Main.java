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

    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);

    public static void main(final String[] args) {
        UserManager userManager = new UserManager();
        TeamManager teamManager = new TeamManager();

        User rt = userManager.addUser(user);
        System.out.println(rt);
    }
}