import fr.lesesperluettes.bdd.Team;
import fr.lesesperluettes.bdd.TeamManager;
import fr.lesesperluettes.bdd.User;
import fr.lesesperluettes.bdd.UserManager;

public class Main {

    public static void main(final String[] args) throws Exception {
        UserManager userManager = new UserManager();
        TeamManager teamManager = new TeamManager();

        User alexis = new User();
        User arthur = new User();

        alexis.setName("POUPELIN");
        alexis.setSurname("Alexis");
        alexis.setAge(20);
        alexis.setEmail("alexis.poupelin@viacesi.fr");

        arthur.setName("CHERAMY");
        arthur.setSurname("Arthur");
        arthur.setAge(20);
        arthur.setEmail("arthur.cheramy@viacesi.fr");

        alexis = userManager.addUser(alexis);
        arthur = userManager.addUser(arthur);

        Team team = new Team();
        team.setName("Les Esperluettes");
        team.addMember(alexis);
        team.addMember(arthur);

        teamManager.create(team);
    }
}