//package heap.basic;
//
//import org.h2.util.IOUtils;
//import org.hamcrest.CoreMatchers;
//import org.hamcrest.MatcherAssert;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//class Tr
//{
//
//    @Test
//    void what_is_the_purpose_of_this_test() throws SQLException
//    {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        int message = Integer.MAX_VALUE;
//
//        try(connection; statement; resultSet)
//        {
//            // given
//            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
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
//
//            statement.executeUpdate("INSERT INTO MYTABLE01 VALUES (1);");
//
//            resultSet = statement.executeQuery("SELECT id FROM MYTABLE01 WHERE id = 1");
//
//            if (resultSet.next())
//            {
//                message = resultSet.getInt("id");
//            }
//        }
//        catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//        finally
//        {
//            IOUtils.closeSilently(resultSet);
//            IOUtils.closeSilently(statement);
//            IOUtils.closeSilently(connection);
//        }
//
//
//        // then
//        assertThat(message, equalTo(1));
//    }
//}
