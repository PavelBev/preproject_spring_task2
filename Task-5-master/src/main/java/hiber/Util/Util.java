package hiber.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String DB_URL = "db.url";
    public static final String USER = "db.username";
    public static final String PASSWORD = "db.password";
    public static Connection connection;

    private Util() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        PropertiesUtil.getProperty(DB_URL),
                        PropertiesUtil.getProperty(USER),
                        PropertiesUtil.getProperty(PASSWORD));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при подключении к БД", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC драйвер не найден", e);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
