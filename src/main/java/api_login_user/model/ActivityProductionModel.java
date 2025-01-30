package api_login_user.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activity_production")
public class ActivityProductionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private ActivityModel activityModel;

    @Column(name = "date_activity", nullable = false)
    private LocalDate dateActivity;

    @Column(name = "date_irrigation")
    private LocalDate dateIrrigation;

    @Column(name = "date_harvest")
    private LocalDate dateHarvest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActivityModel getActivityModel() {
        return activityModel;
    }

    public void setActivityModel(ActivityModel activityModel) {
        this.activityModel = activityModel;
    }

    public LocalDate getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(LocalDate dateActivity) {
        this.dateActivity = dateActivity;
    }

    public LocalDate getDateIrrigation() {
        return dateIrrigation;
    }

    public void setDateIrrigation(LocalDate dateIrrigation) {
        this.dateIrrigation = dateIrrigation;
    }

    public LocalDate getDateHarvest() {
        return dateHarvest;
    }

    public void setDateHarvest(LocalDate dateHarvest) {
        this.dateHarvest = dateHarvest;
    }
}
