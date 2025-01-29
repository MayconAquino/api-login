package api_login_user.service;

import api_login_user.model.ActivityModel;
import api_login_user.model.AtualizarNomeRequest;
import api_login_user.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityModel register(ActivityModel activity) {
        return activityRepository.save(activity);
    }

    public ActivityModel findByName(String name) {
        return activityRepository.findByName(name);
    }

    public List<ActivityModel> findAll() {
        return activityRepository.findAll();
    }

   public ResponseEntity <?> updateNameActivity(AtualizarNomeRequest request) {
        ActivityModel activityModel = activityRepository.findByName(request.getNomeAntigo());
        if(activityModel != null) {
            activityModel.setName(request.getNomeNovo());
            ActivityModel updatedActivity = activityRepository.save(activityModel);
            return ResponseEntity.ok(updatedActivity);
        } else {
            return ResponseEntity.badRequest().body("Activity noy foud" + request.getNomeAntigo());
        }
   }

    public boolean deleteByName(String name) {
        ActivityModel existingActivity = activityRepository.findByName(name);
        if (existingActivity != null) {
            activityRepository.delete(existingActivity);
            return true;
        }
        return false;
    }
}
