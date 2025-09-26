//package heap.basic;
//
//import org.apache.commons.io.IOUtils;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.testcontainers.containers.PostgreSQLContainer;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Awaiting
//{
//    private static PostgreSQLContainer postgresContainer = new PostgreSQLContainer();
//
//    @BeforeAll
//    public static void populate()
//    {
//        postgresContainer.start();
//    }
//
//    @AfterAll
//    public static void destroy()
//    {
//        postgresContainer.stop();
//    }
//
//    @Test
//    void what_is_the_purpose_of_this_test() throws SQLException
//    {
//        createTable();
//
//        Connection tx1 = getConnection();
//        tx1.setAutoCommit(false);
//
//        Connection tx2 = getConnection();
//        tx2.setAutoCommit(false);
//
//        Statement statement1 = tx1.createStatement();
//
//        int tx1Update = statement1.executeUpdate("UPDATE MYTABLE01 SET ID = 2 WHERE id = 1;");
//        System.out.println("rows update: " + tx1Update);
//
//        Statement statement2 = tx2.createStatement();
//        int tx2Update = statement2.executeUpdate("UPDATE MYTABLE01 SET ID = 3 WHERE id = 1;");
//        System.out.println("rows update: " + tx2Update);
//
//        tx2.commit();
//        tx1.commit();
//
//        Connection readTx = getConnection();
//
//        Statement statement3 = readTx.createStatement();
//        ResultSet resultSet = statement3.executeQuery("SELECT id FROM MYTABLE01");
//
//        if (resultSet.next())
//        {
//            System.out.println(resultSet.getInt("id"));
//        }
//    }
//
//    private static Connection getConnection() throws SQLException
//    {
//        String jdbcUrl = postgresContainer.getJdbcUrl();
//        String username = postgresContainer.getUsername();
//        String password = postgresContainer.getPassword();
//
//        return DriverManager.getConnection(jdbcUrl, username, password);
//    }
//
//    private static void createTable()
//    {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        int message = Integer.MAX_VALUE;
//
//        try
//        {
//            Connection conn = getConnection();
//            conn.setAutoCommit(false);
//
//            statement = conn.createStatement();
//
//            statement.executeUpdate("DROP TABLE IF EXISTS MYTABLE01;");
//            statement.executeUpdate("""
//                                            CREATE TABLE MYTABLE01
//                                            (
//                                                id INT
//                                            );
//                                            """);
//        }
//        catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//        finally
//        {
//            IOUtils.closeQuietly(connection);
//            IOUtils.closeQuietly(statement);
//            IOUtils.closeQuietly(connection);
//        }
//    }
//}
