package com.example.EcoTrack.Repositories;


import com.example.EcoTrack.Entities.EcoActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EcoActivityRepository extends JpaRepository<EcoActivity, Long> {
    List<EcoActivity> findByUserId(Long userId);
}

