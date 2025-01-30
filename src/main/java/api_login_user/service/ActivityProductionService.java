package api_login_user.service;

import api_login_user.Dtos.ActivityProductionDto;
import api_login_user.model.ActivityModel;
import api_login_user.model.ActivityProductionModel;
import api_login_user.repository.ActivityProductionRepository;
import api_login_user.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivityProductionService {

    @Autowired
    private ActivityProductionRepository activityProductionRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public ResponseEntity<?> register(ActivityProductionDto dto) {
        ActivityModel activityModel = activityRepository.findById(dto.getActivityId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atividade não encontrada"));

        ActivityProductionModel activityProduction = new ActivityProductionModel();
        activityProduction.setActivityModel(activityModel);
        activityProduction.setDateActivity(dto.getDateActivity());
        activityProduction.setDateIrrigation(dto.getDateIrrigation());
        activityProduction.setDateHarvest(dto.getDateHarvest());

        activityProductionRepository.save(activityProduction);
        return ResponseEntity.ok().body("Atividade salva com sucesso: " + activityProduction);
    }

    public List<ActivityProductionModel> findAll() {
        return activityProductionRepository.findAll();
    }

    public ResponseEntity<?> updateByName(String activityName, ActivityProductionModel updatedProduction, Long newActivityId) {
        ActivityModel activityModel = activityRepository.findByName(activityName);
        ActivityProductionModel existingProduction = activityProductionRepository.findByActivityModelId(activityModel.getId());

        if (existingProduction != null) {
            ActivityModel activity = activityRepository.findById(newActivityId).orElse(null);

            if (activity != null) {
                existingProduction.setActivityModel(activity);
                existingProduction.setDateActivity(updatedProduction.getDateActivity());
                existingProduction.setDateIrrigation(updatedProduction.getDateIrrigation());
                existingProduction.setDateHarvest(updatedProduction.getDateHarvest());

                activityProductionRepository.save(existingProduction);

                return ResponseEntity.ok().body("Atividade alterada com sucesso: " + existingProduction);
            } else {
                return ResponseEntity.badRequest().body("Atividade não encontrada com ID: " + newActivityId);
            }
        } else {
            return ResponseEntity.badRequest().body("Produção não encontrada para a atividade: " + activityName);
        }
    }

    public ResponseEntity<?> deleteByName(String activityName) {
        ActivityModel activityModel = activityRepository.findByName(activityName);

        if (activityModel == null) {
            return ResponseEntity.badRequest().body("Atividade não encontrada com nome: " + activityName);
        }

        ActivityProductionModel existingProduction = activityProductionRepository.findByActivityModelId(activityModel.getId());

        if (existingProduction != null) {
            activityProductionRepository.delete(existingProduction);
            return ResponseEntity.ok("Produção deletada com sucesso para a atividade: " + activityName);
        } else {
            return ResponseEntity.badRequest().body("Produção não encontrada para a atividade: " + activityName);
        }
    }
}
