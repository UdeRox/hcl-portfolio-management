package com.hcl.portfoliomgmt.trade.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;

@Slf4j
public class AbstractContainerBaseTest {

    static final KafkaContainer kafka;
    static final MySQLContainer MY_SQL_CONTAINER;
    static {
        kafka=new KafkaContainer();
        kafka.start();
        MY_SQL_CONTAINER = new MySQLContainer()
                .withDatabaseName("db")
                .withUsername("user")
                .withPassword("password");
        MY_SQL_CONTAINER.start();
       /* var containerDelegate = new JdbcDatabaseDelegate(MY_SQL_CONTAINER, "");
        ScriptUtils.runInitScript(containerDelegate, "sql/scripts_test.sql");*/
    }

    @DynamicPropertySource
    static void dynamicPropertySource(final DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
        registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
    }
}
