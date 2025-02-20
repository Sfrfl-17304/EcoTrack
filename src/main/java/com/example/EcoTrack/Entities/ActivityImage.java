package com.example.EcoTrack.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "activity_images")
public class ActivityImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id", nullable = false)
    private EcoActivity activity;  // Reference to the EcoActivity this image belongs to

    @Column(nullable = false)
    private String imagePath;  // Path to the image file

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EcoActivity getActivity() { return activity; }
    public void setActivity(EcoActivity activity) { this.activity = activity; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}

