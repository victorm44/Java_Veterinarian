package app.dao;

import app.models.MedicalRecord;

public class MedicalRecordDAO {
    private static final MedicalRecord[] medicalRecords = new MedicalRecord[100];
    private static int numberOfRecords = 0;

    public static void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords[numberOfRecords++] = medicalRecord;


    }
}
