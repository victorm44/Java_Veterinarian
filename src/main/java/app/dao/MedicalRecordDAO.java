package app.dao;

import app.models.MedicalRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.config.MYSQLConnection;

public class MedicalRecordDAO {
    private static final String INSERT_QUERY = "INSERT INTO medical_records (pet_id, date, veterinarian_id, reason_for_visit, symptoms, diagnosis, procedure, medication, medication_dose, vaccination_history, allergy_medications, procedure_details, order_cancellation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM medical_records";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM medical_records WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE medical_records SET pet_id = ?, date = ?, veterinarian_id = ?, reason_for_visit = ?, symptoms = ?, diagnosis = ?, procedure = ?, medication = ?, medication_dose = ?, vaccination_history = ?, allergy_medications = ?, procedure_details = ?, order_cancellation = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM medical_records WHERE id = ?";

    public static void addMedicalRecord(MedicalRecord medicalRecord) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, medicalRecord.getPetId());
            statement.setString(2, medicalRecord.getDate());
            statement.setString(3, medicalRecord.getVeterinarianId());
            statement.setString(4, medicalRecord.getReasonForVisit());
            statement.setString(5, medicalRecord.getSymptoms());
            statement.setString(6, medicalRecord.getDiagnosis());
            statement.setString(7, medicalRecord.getProcedure());
            statement.setString(8, medicalRecord.getMedication());
            statement.setString(9, medicalRecord.getMedicationDose());
            statement.setString(10, medicalRecord.getVaccinationHistory());
            statement.setString(11, medicalRecord.getAllergyMedications());
            statement.setString(12, medicalRecord.getProcedureDetails());
            statement.setString(13, medicalRecord.getOrderCancellation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<MedicalRecord> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                MedicalRecord medicalRecord = new MedicalRecord();

                medicalRecord.setPetId(resultSet.getString("pet_id"));
                medicalRecord.setDate(resultSet.getString("date"));
                medicalRecord.setVeterinarianId(resultSet.getString("veterinarian_id"));
                medicalRecord.setReasonForVisit(resultSet.getString("reason_for_visit"));
                medicalRecord.setSymptoms(resultSet.getString("symptoms"));
                medicalRecord.setDiagnosis(resultSet.getString("diagnosis"));
                medicalRecord.setProcedure(resultSet.getString("procedure"));
                medicalRecord.setMedication(resultSet.getString("medication"));
                medicalRecord.setMedicationDose(resultSet.getString("medication_dose"));
                medicalRecord.setVaccinationHistory(resultSet.getString("vaccination_history"));
                medicalRecord.setAllergyMedications(resultSet.getString("allergy_medications"));
                medicalRecord.setProcedureDetails(resultSet.getString("procedure_details"));
                medicalRecord.setOrderCancellation(resultSet.getString("order_cancellation"));
                medicalRecords.add(medicalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecords;
    }

    public static MedicalRecord getMedicalRecordById(String id) {
        MedicalRecord medicalRecord = null;
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                medicalRecord = new MedicalRecord();

                medicalRecord.setPetId(resultSet.getString("pet_id"));
                medicalRecord.setDate(resultSet.getString("date"));
                medicalRecord.setVeterinarianId(resultSet.getString("veterinarian_id"));
                medicalRecord.setReasonForVisit(resultSet.getString("reason_for_visit"));
                medicalRecord.setSymptoms(resultSet.getString("symptoms"));
                medicalRecord.setDiagnosis(resultSet.getString("diagnosis"));
                medicalRecord.setProcedure(resultSet.getString("procedure"));
                medicalRecord.setMedication(resultSet.getString("medication"));
                medicalRecord.setMedicationDose(resultSet.getString("medication_dose"));
                medicalRecord.setVaccinationHistory(resultSet.getString("vaccination_history"));
                medicalRecord.setAllergyMedications(resultSet.getString("allergy_medications"));
                medicalRecord.setProcedureDetails(resultSet.getString("procedure_details"));
                medicalRecord.setOrderCancellation(resultSet.getString("order_cancellation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecord;
    }

    public static void updateMedicalRecord(MedicalRecord medicalRecord) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, medicalRecord.getPetId());
            statement.setString(2, medicalRecord.getDate());
            statement.setString(3, medicalRecord.getVeterinarianId());
            statement.setString(4, medicalRecord.getReasonForVisit());
            statement.setString(5, medicalRecord.getSymptoms());
            statement.setString(6, medicalRecord.getDiagnosis());
            statement.setString(7, medicalRecord.getProcedure());
            statement.setString(8, medicalRecord.getMedication());
            statement.setString(9, medicalRecord.getMedicationDose());
            statement.setString(10, medicalRecord.getVaccinationHistory());
            statement.setString(11, medicalRecord.getAllergyMedications());
            statement.setString(12, medicalRecord.getProcedureDetails());
            statement.setString(13, medicalRecord.getOrderCancellation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMedicalRecord(String id) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}