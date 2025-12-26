package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {

    // ✅ MUST MATCH ENTITY FIELD NAME
    List<DiversityTarget> findByYear(Integer year);
}
