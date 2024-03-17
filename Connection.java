package app;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Connection {
	 Connection connection = connectToDatabase();
	
    private static Connection connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/veterinaria20241";
            String user = "tu_usuario";
            String password = "tu_contraseña";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
