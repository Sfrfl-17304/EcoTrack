package com.example.EcoTrack.Controllers;

import com.example.EcoTrack.DTO.EcoActivityDTO;
import com.example.EcoTrack.Entities.EcoActivity;
import com.example.EcoTrack.Services.EcoActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class EcoActivityController {
    private final EcoActivityService ecoActivityService;

    public EcoActivityController(EcoActivityService ecoActivityService) {
        this.ecoActivityService = ecoActivityService;
    }

    @PostMapping
    public ResponseEntity<EcoActivity> createActivity(@RequestBody EcoActivity activity) {
        EcoActivity savedActivity = ecoActivityService.addActivity(activity);
        savedActivity.setCarbonSaved(ecoActivityService.calculateCarbonSaved(savedActivity.getActivityType()));
        return ResponseEntity.ok(savedActivity);
    }

//    @PostMapping
//    public ResponseEntity<EcoActivity> createActivity(@RequestBody EcoActivityDTO activityDTO) {
//        EcoActivity activity = new EcoActivity();
//        activity.setActivityType(activityDTO.getActivityType());
//        activity.setTimestamp(activityDTO.getTimestamp() != null ? activityDTO.getTimestamp() : OffsetDateTime.now());
//        activity.setDescription(activityDTO.getDescription());
//        activity.setParameters(activityDTO.getParameters());
//        activity.setCarbonSaved(ecoActivityService.calculateCarbonSaved(activityDTO.getActivityType()));
//        activity = ecoActivityService.addActivity(activity);
//
//        return ResponseEntity.ok(activity);
//    }


    @GetMapping
    public ResponseEntity<List<EcoActivityDTO>> getAllActivities() {
        return ResponseEntity.ok(ecoActivityService.getAllActivities());
    }
}

