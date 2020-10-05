package fr.lesesperluettes.bdd;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Integer id;

    @Audited
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserTeam",
            joinColumns = @JoinColumn(name="team_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private Set<User> users = new HashSet<User>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(User member){
        this.users.add(member);
    }

    public void removeMember(User member){
        this.users.remove(member);
    }

    public Set<User> getMembers() {
        return users;
    }

    public void setMembers(Set<User> members) {
        this.users = members;
    }
}
