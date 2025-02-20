package com.example.EcoTrack.Entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Type;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "eco_activities")
public class EcoActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String activityType;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime timestamp;

    private double carbonSaved;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Using PostgreSQL's JSONB type for flexible activity parameters
    @Column(columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private Map<String, Object> parameters;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<ActivityImage> images = new ArrayList<>();

    @Version
    private Long version;


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getActivityType() {
        return activityType;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public double getCarbonSaved() {
        return carbonSaved;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public List<ActivityImage> getImages() {
        return images;
    }

    public Long getVersion() {
        return version;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setCarbonSaved(double carbonSaved) {
        this.carbonSaved = carbonSaved;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void setImages(List<ActivityImage> images) {
        this.images = images;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}


