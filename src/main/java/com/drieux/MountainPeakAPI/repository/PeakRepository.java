package com.drieux.MountainPeakAPI.repository;

import com.drieux.MountainPeakAPI.model.Peak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeakRepository extends JpaRepository<Peak, Long> {
    @Query("SELECT * FROM Peak p WHERE p.latitude BETWEEN :la1 AND :la2 AND p.longitude BETWEEN :lo1 AND :lo2;")
    List<Peak> findByArea(@Param("la1") float la1, @Param("la2") float la2, @Param("lo1") float lo1, @Param("lo2") float lo2);
}
