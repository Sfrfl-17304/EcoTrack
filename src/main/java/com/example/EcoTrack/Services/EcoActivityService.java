package com.example.EcoTrack.Services;

import com.example.EcoTrack.DTO.EcoActivityDTO;
import com.example.EcoTrack.Entities.EcoActivity;
import com.example.EcoTrack.Repositories.EcoActivityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcoActivityService {
    private final EcoActivityRepository ecoActivityRepository;

    public EcoActivityService(EcoActivityRepository ecoActivityRepository) {
        this.ecoActivityRepository = ecoActivityRepository;
    }

    public EcoActivity addActivity(EcoActivity activity) {
        activity.setCarbonSaved(calculateCarbonSaved(activity.getActivityType()));
        return ecoActivityRepository.save(activity);
    }

    public List<EcoActivityDTO> getAllActivities() {
        return ecoActivityRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EcoActivityDTO convertToDTO(EcoActivity activity) {
        return new EcoActivityDTO(
                activity.getId(),
                activity.getActivityType(),
                activity.getTimestamp(),
                activity.getCarbonSaved(),
                activity.getDescription(),
                activity.getParameters(),
                null, // Image URLs will be added later
                null  // UserDTO will be added later
        );
    }

    public double calculateCarbonSaved(String activityType) {
        return switch (activityType.toLowerCase()) {
            case "cycling" -> 0.21;   // Saves 0.21 kg CO₂ per km
            case "recycling" -> 0.35; // Saves 0.35 kg CO₂ per kg
            case "tree planting" -> 22.0; // A tree absorbs ~22kg CO₂ per year
            default -> 0.0;
        };
    }
}
