package heap.basic;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2JDBCHelloWorld
{
    @Test
    void what_will_be_printed()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            // 1. Establish Connection
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            // 2. Create Statement
            statement = connection.createStatement();

            // 3. Execute SQL: Create table and insert data
            statement.executeUpdate("CREATE TABLE greetings (id INT PRIMARY KEY, message VARCHAR(255))");
            statement.executeUpdate("INSERT INTO greetings (id, message) VALUES (1, 'Hello, H2 JDBC!')");

            // 4. Execute SQL: Query data
            resultSet = statement.executeQuery("SELECT message FROM greetings WHERE id = 1");

            // 5. Process Results
            if (resultSet.next())
            {
                String message = resultSet.getString("message");
                System.out.println(message); // Output: Hello, H2 JDBC!
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
