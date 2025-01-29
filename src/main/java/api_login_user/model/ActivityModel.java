package api_login_user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "activity_model")
@AllArgsConstructor
public class ActivityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    public ActivityModel(String name) {
    }

    public ActivityModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ActivityModel{" +
                "name='" + name + '\'' + '}';
    }
}
