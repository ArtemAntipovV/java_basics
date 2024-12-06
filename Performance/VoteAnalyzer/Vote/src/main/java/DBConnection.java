import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "F13ynbgj91D!";
    private static StringBuilder insetQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id), KEY(name(50), birthDate))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static int customSelect() throws SQLException {
        String sql = "SELECT id FROM voter_count WHERE name='Исаичев Эмилиан'";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        if (!rs.next()) {
            return -1;
        } else {
            return rs.getInt("id");
        }
    }
    public static void executeMultiInsert () throws SQLException
    {
        String sql = "INSERT INTO voter_count(name, birthDate, `count`) " +
                "VALUES" + insetQuery.toString() +
         "ON DUPLICATE KEY UPDATE `count`=`count`+ 1";
      DBConnection.getConnection().createStatement().execute(sql);

    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');

        if (insetQuery.length() > 0) {
            insetQuery.append(", ");
        }

        insetQuery.append("('")
                .append(name)
                .append("', '")
                .append(birthDay)
                .append("', 1)");
        if(insetQuery.length() > 50_000) {
            executeMultiInsert();
            insetQuery = new StringBuilder();
        }

    }
    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
