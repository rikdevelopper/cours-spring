package fr.aceko.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    public static final String url = "jdbc:postgresql://localhost:5432/supmaison";
    public static final String user = "postgres";
    public static final String password = "spring";
    public static final String driver = "org.postgresql.Driver";

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
