package com.ude.hackathon.hcl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(ContainerConfig.class)
class PortfolioApplicationTests {

    @Test
    void contextLoads() {}
}
