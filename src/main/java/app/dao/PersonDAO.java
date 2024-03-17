package app.dao;
import app.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.config.MYSQLConnection;

public class PersonDAO {
    private static final String INSERT_QUERY = "INSERT INTO persons (id_number, name, age, role, username, password) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM persons";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM persons WHERE id_number = ?";
    private static final String UPDATE_QUERY = "UPDATE persons SET name = ?, age = ?, role = ?, username = ?, password = ? WHERE id_number = ?";
    private static final String DELETE_QUERY = "DELETE FROM persons WHERE id_number = ?";

    public static void addPerson(Person person) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, person.getIdNumber());
            statement.setString(2, person.getName());
            statement.setInt(3, person.getAge());
            statement.setString(4, person.getRole());
            statement.setString(5, person.getUsername());
            statement.setString(6, person.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Person person = new Person();
                person.setIdNumber(resultSet.getString("id_number"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setRole(resultSet.getString("role"));
                person.setUsername(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static Person getPersonByIdNumber(String idNumber) {
        Person person = null;
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setString(1, idNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                person = new Person();
                person.setIdNumber(resultSet.getString("id_number"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setRole(resultSet.getString("role"));
                person.setUsername(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void updatePerson(Person person) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getRole());
            statement.setString(4, person.getUsername());
            statement.setString(5, person.getPassword());
            statement.setString(6, person.getIdNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(String idNumber) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, idNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
