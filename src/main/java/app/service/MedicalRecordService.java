package app.service;

import app.dto.MedicalRecordDTO;
import app.models.MedicalRecord;
import app.validators.MedicalRecordValidator;
import app.dao.MedicalRecordDAO;

public class MedicalRecordService {
    public static void registerMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        if (MedicalRecordValidator.validateMedicalRecord(medicalRecordDTO)) {
            MedicalRecord medicalRecord = new MedicalRecord();
            MedicalRecordDAO.addMedicalRecord(medicalRecord);
            System.out.println("Medical record registered successfully.");
        } else {
            System.out.println("Error validating medical record data.");
        }
    }
}
