package fr.lesesperluettes.bdd;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private Integer id;

    @Audited
    private String name;

    @Audited
    private String description;

    @Audited
    private Date creationDate;

    @Audited
    private String imagePath;

    @Audited
    private Date startDate;

    @Audited
    private Date endDate;

    @Audited
    @ManyToOne(cascade = CascadeType.ALL)
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", imagePath='" + imagePath + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", activityType=" + activityType +
                ", place=" + place +
                ", users=" + users +
                '}';
    }

    public String getTimeText(){
        PrettyTime p = new PrettyTime(new Locale("fr"));
        return p.format(this.creationDate);
    }

    public String formatDate(Date date){
        return new SimpleDateFormat("EEEE dd MMMM (HH:kk)",Locale.getDefault()).format(date);
    }
}