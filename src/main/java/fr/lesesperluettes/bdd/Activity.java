package fr.lesesperluettes.bdd;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private Integer id;

    @Audited
    private String name;

    @Audited
    private Date creationDate;

    @Audited
    @ManyToOne
    private ActivityType activityType;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne
    private Place place;

    @ManyToMany
    @JoinTable(
            name = "ActivityUser",
            joinColumns = { @JoinColumn(name = "activity_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
            )
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}