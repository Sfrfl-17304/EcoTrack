package com.example.EcoTrack.Repositories;

import com.example.EcoTrack.Entities.ActivityImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityImageRepository extends JpaRepository<ActivityImage, Long> {
    List<ActivityImage> findByActivityId(Long activityId);
}
