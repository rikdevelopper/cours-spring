package fr.aceko.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/supmaison";
    private static final String user = "postgres";
    private static final String password = "spring";

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
