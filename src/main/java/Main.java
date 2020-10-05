
import fr.lesesperluettes.bdd.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);

    public static void main(final String[] args) {
        UserManager userManager = new UserManager();
        User user = new User();
        user.setName("POUPELIN2");
        user.setSurname("Alexis");
        user.setAge(20);
        user.setEmail("alexis.poupelin@viacesi.fr");

        User rt = userManager.addUser(user);
        logger.log(Level.INFO, rt);
        Place Place = new Place();
        Place.setAddress("8 rue Chasse Royale");
        Place.setName("Le Mans");
        PlaceManager placeManager = new PlaceManager();
        Place rL = placeManager.addPlace(Place);
        logger.log(Level.INFO, rL);
        ActivityType activityType = new ActivityType();
        activityType.setDescription("Football description...");
        activityType.setName("Football");
        ActivityTypeManager activityTypeManager = new ActivityTypeManager();
        ActivityType rAT = activityTypeManager.addActivityType(activityType);
        System.out.println(rAT);
        logger.log(Level.INFO, rAT);
        Activity activity = new Activity();
        activity.setName("Foot");
        activity.setPlace(Place);
        activity.setActivityType(activityType);
        Set<User> users =  new HashSet<User>();
        activity.setUsers(users);
    }
}