package bg.nbu.citb408.onlinegradebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="topics")
public class Topic {

    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "is_taken")
    boolean taken;

    @Column(name = "taking_date")
    Date takingDate;

    public Topic() {

    }

    public Topic(String topic, boolean taken, Date takingDate) {
        this.topic = topic;
        this.taken = taken;
        this.takingDate = takingDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Date getTakingDate() {
        return takingDate;
    }

    public void setTakingDate(Date takingDate) {
        this.takingDate = takingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
