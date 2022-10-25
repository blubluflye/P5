package com.openclassroom.safetynetalerts.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.openclassroom.safetynetalerts.model.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends List<MedicalRecord>{

}
