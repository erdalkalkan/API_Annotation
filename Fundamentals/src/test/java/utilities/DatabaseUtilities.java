package utilities;

import java.sql.*;

public class DatabaseUtilities {
    private static final String db_url = ConfigReader.getProperty("db_url");
    private static final String db_username = ConfigReader.getProperty("db_username");
    private static final String db_password = ConfigReader.getProperty("db_password");

    private static Connection connection;
    private static Statement statement;
    public static ResultSet resultSet;

    public static Connection createConnection(){
        try {
            connection = DriverManager.getConnection(db_url, db_username, db_password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeQuery(String query) throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        return;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
