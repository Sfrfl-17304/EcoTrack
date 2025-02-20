package com.example.EcoTrack.Services;

import com.example.EcoTrack.Entities.ActivityImage;
import com.example.EcoTrack.Entities.EcoActivity;
import com.example.EcoTrack.Repositories.ActivityImageRepository;
import com.example.EcoTrack.Repositories.EcoActivityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

@Service
public class ActivityImageService {
    private final ActivityImageRepository activityImageRepository;
    private final EcoActivityRepository ecoActivityRepository;

    public ActivityImageService(ActivityImageRepository activityImageRepository, EcoActivityRepository ecoActivityRepository) {
        this.activityImageRepository = activityImageRepository;
        this.ecoActivityRepository = ecoActivityRepository;
    }

    public String uploadImage(Long activityId, MultipartFile file) throws IOException {
        EcoActivity activity = ecoActivityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        String filename = file.getOriginalFilename();
        Path path = Paths.get("./uploads/" + filename);
        Files.write(path, file.getBytes());

        ActivityImage image = new ActivityImage();
        image.setActivity(activity);
        image.setImagePath("/uploads/" + filename);
        activityImageRepository.save(image);

        return image.getImagePath();
    }

    public List<ActivityImage> getImagesByActivityId(Long activityId) {
        return activityImageRepository.findByActivityId(activityId);
    }
}

