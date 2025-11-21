package heap.basic;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class H2JDBCHelloWorld
{
    @Test
    void what_if_there_is_no_x()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE greetings (id INT PRIMARY KEY, message VARCHAR(255))");
            statement.executeUpdate("INSERT INTO greetings (id, message) VALUES (1, 'Hello, H2 JDBC!')");

            resultSet = statement.executeQuery("SELECT message FROM greetings WHERE id = 1");

            if (resultSet.next())
            {
                String message = resultSet.getString("message");
                System.out.println(message);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
