import java.sql.*;
public class Database {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement statement = null;

        try{
            System.out.println("Connecting to DB...");
            Connection con = DriverManager.getConnection(DB_URL,"student", "STUDENT");

            statement = conn.createStatement();

            String sql = "SELECT * FROM STUDENTI";

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.err.println("Cannot connect to DB " + e);
        }
        finally {
            if(conn != null) conn.close();
        }

    }
}
