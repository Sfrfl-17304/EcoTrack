package com.example.EcoTrack.DTO;

public class ActivityImageDTO {
    private Long id;
    private String imageUrl;
    private Long ecoActivityId;  // Links to the activity

    public ActivityImageDTO(Long id, String imageUrl, Long ecoActivityId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.ecoActivityId = ecoActivityId;
    }

    public Long getId() { return id; }
    public String getImageUrl() { return imageUrl; }
    public Long getEcoActivityId() { return ecoActivityId; }
}

