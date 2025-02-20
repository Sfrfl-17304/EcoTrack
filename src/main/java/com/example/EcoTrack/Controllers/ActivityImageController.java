package com.example.EcoTrack.Controllers;

import com.example.EcoTrack.Entities.ActivityImage;
import com.example.EcoTrack.Services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/activity-images")
public class ActivityImageController {
    private final ActivityImageService activityImageService;

    public ActivityImageController(ActivityImageService activityImageService) {
        this.activityImageService = activityImageService;
    }

    @PostMapping("/{activityId}/upload")
    public ResponseEntity<?> uploadImage(@PathVariable Long activityId, @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = activityImageService.uploadImage(activityId, file);
            return ResponseEntity.ok("Image uploaded successfully: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Image upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<List<ActivityImage>> getImagesByActivityId(@PathVariable Long activityId) {
        return ResponseEntity.ok(activityImageService.getImagesByActivityId(activityId));
    }
}

