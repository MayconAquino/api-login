package api_login_user.controller;

import api_login_user.Dtos.ActivityProductionDto;
import api_login_user.model.ActivityProductionModel;
import api_login_user.service.ActivityProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/production")
public class ActivityProductionController {

    @Autowired
    private ActivityProductionService activityProductionService;

    @PostMapping("/register")
    public ResponseEntity<ResponseEntity<?>> salvar(@RequestBody ActivityProductionDto dto) {
        ResponseEntity<?> saved = activityProductionService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/update/{activityName}")
    public ResponseEntity<ResponseEntity<?>> updateProduction(
            @PathVariable String activityName,
            @RequestBody ActivityProductionModel productionModel,
            @RequestParam Long newActivityId) {
        ResponseEntity<?> updatedProduction = activityProductionService.updateByName(activityName, productionModel, newActivityId);
        return ResponseEntity.ok(updatedProduction);
    }

    @DeleteMapping("/delete/{activityName}")
    public ResponseEntity<?> deleteProduction(@PathVariable String activityName) {
        return activityProductionService.deleteByName(activityName);
    }
}
