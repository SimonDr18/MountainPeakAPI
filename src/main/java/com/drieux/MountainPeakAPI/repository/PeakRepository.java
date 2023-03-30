package com.drieux.MountainPeakAPI.repository;

import com.drieux.MountainPeakAPI.model.Peak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeakRepository extends JpaRepository<Peak, Long> {
    //List<Peak> findByLatitudeFieldBetweenAndLongitudeFieldBetween(float x1, float x2, float y1, float y2);
}
