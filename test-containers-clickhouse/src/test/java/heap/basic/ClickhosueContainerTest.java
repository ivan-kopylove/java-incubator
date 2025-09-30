package heap.basic;

import org.junit.jupiter.api.Test;
import org.testcontainers.clickhouse.ClickHouseContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;

public class ClickhosueContainerTest
{
    @Test
    void exercise_design_reverse_engineering() throws SQLException
    {
        ClickHouseContainer clickHouseContainer = new ClickHouseContainer(DockerImageName.parse("clickhouse/clickhouse-server:24.5"));

        clickHouseContainer.start();
        clickHouseContainer.stop();
    }
}
