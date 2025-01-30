package api_login_user.Dtos;

import api_login_user.model.ActivityModel;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityProductionDto {


    private Long activityId;
    private ActivityModel activityModel;
    private LocalDate dateActivity;
    private LocalDate dateIrrigation;
    private LocalDate dateHarvest;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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
