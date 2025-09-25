package heap.basic;

import org.h2.util.IOUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FixMe01
{
    @Test
    void what_is_wrong_here() throws SQLException
    {
        boolean thrown = false;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int message = Integer.MAX_VALUE;


        try
        {
            // given
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            statement = conn.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS MYTABLE01;");
            statement.executeUpdate("""
                                            CREATE TABLE MYTABLE01
                                            (
                                                id INT
                                            );
                                            """);

            statement.executeUpdate("INSERT INTO MYTABLE01 VALUES (1);");


            resultSet = statement.executeQuery("SELECT id FROM MYTABLE01 WHERE id = 1");

            if (resultSet.next())
            {
                message = resultSet.getInt("message");
            }
        }
        catch (SQLException ex)
        {
            thrown = true;
        }
        finally
        {
            IOUtils.closeSilently(resultSet);
            IOUtils.closeSilently(statement);
            IOUtils.closeSilently(connection);
        }

        assertThat(thrown, is(true));
    }
}