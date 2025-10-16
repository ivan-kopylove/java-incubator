package heap.basic;

import org.junit.jupiter.api.Test;
import org.testcontainers.clickhouse.ClickHouseContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;

class ClickhosueContainerTest
{
    @Test
    void exercise_design_reverse_engineering() throws SQLException
    {
        ClickHouseContainer clickHouseContainer = new ClickHouseContainer(DockerImageName.parse("clickhouse/clickhouse-server:25.8"));

        clickHouseContainer.start();
        clickHouseContainer.stop();
    }
}
