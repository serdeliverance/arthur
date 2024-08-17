package org.arthur.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceConfig {
    public static DataSource getDataSource(String connUrl, String username, String password) {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(connUrl);
        config.setUsername(username);
        config.setPassword(password);

        // Optional: HikariCP settings
        config.setMaximumPoolSize(10);          // Maximum number of connections in the pool
        config.setMinimumIdle(5);               // Minimum number of idle connections in the pool
        config.setConnectionTimeout(30000);     // Maximum wait for a connection in milliseconds
        config.setIdleTimeout(600000);          // Maximum time that a connection is allowed to sit idle in milliseconds
        config.setMaxLifetime(1800000);         // Maximum lifetime of a connection in the pool in milliseconds


        return new HikariDataSource(config);
    }
}
