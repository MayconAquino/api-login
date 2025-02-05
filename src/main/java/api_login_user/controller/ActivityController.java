package api_login_user.controller;

import api_login_user.Dtos.ActivityDto;
import api_login_user.model.ActivityModel;
import api_login_user.model.AtualizarNomeRequest;
import api_login_user.service.ActivityService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ActivityDto request) {
        ActivityModel activityExist = activityService.findByName(request.getName());
        if ( activityExist == null || StringUtils.isBlank(activityExist.getName())) {
            ActivityModel activity = new ActivityModel();
            activity.setName(request.getName());
            return ResponseEntity.ok(activityService.register(activity));
        } else {
            return ResponseEntity.badRequest().body("Activity already in use");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        ActivityModel activity = activityService.findByName(name);
        if (activity != null) {
            return ResponseEntity.ok(activity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(activityService.findAll());
    }

    @PutMapping("/NewName")
    public ResponseEntity<?> update(@RequestBody AtualizarNomeRequest request) {
        ResponseEntity<?> activityModel = activityService.updateNameActivity(request);
        return ResponseEntity.ok(activityModel);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        boolean deleted = activityService.deleteByName(name);
        if (deleted) {
            return ResponseEntity.ok("Activity deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Activity not found.");
        }
    }
}
