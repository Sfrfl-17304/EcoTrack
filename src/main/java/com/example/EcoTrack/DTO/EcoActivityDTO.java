package com.example.EcoTrack.DTO;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class EcoActivityDTO {
    private Long id;
    private String activityType;
    private OffsetDateTime timestamp;
    private double carbonSaved;
    private String description;
    private Map<String, Object> parameters;  // JSONB data
    private List<String> imageUrls;  // Instead of full image objects
    private UserDTO user;  // To avoid exposing full User entity

    public EcoActivityDTO(Long id, String activityType, OffsetDateTime timestamp, double carbonSaved,
                          String description, Map<String, Object> parameters, List<String> imageUrls, UserDTO user) {
        this.id = id;
        this.activityType = activityType;
        this.timestamp = timestamp;
        this.carbonSaved = carbonSaved;
        this.description = description;
        this.parameters = parameters;
        this.imageUrls = imageUrls;
        this.user = user;
    }

    public Long getId() { return id; }
    public String getActivityType() { return activityType; }
    public OffsetDateTime getTimestamp() { return timestamp; }
    public double getCarbonSaved() { return carbonSaved; }
    public String getDescription() { return description; }
    public Map<String, Object> getParameters() { return parameters; }
    public List<String> getImageUrls() { return imageUrls; }
    public UserDTO getUser() { return user; }
}

