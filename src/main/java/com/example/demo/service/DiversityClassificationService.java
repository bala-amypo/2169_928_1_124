package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {

    DiversityClassification createClassification(DiversityClassification c);

    DiversityClassification updateClassification(Long id, DiversityClassification c);

    DiversityClassification getById(Long id);

    List<DiversityClassification> getAllClassifications();

    void deactivateClassification(Long id);
}
