package com.hcl.portfoliomgmt.trade.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.portfoliomgmt.trade.constants.TradeType;
import com.hcl.portfoliomgmt.trade.entity.Position;
import com.hcl.portfoliomgmt.trade.integration.AbstractContainerBaseTest;
import com.hcl.portfoliomgmt.trade.repository.PositionRepository;
import com.hcl.portfoliomgmt.trade.web.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TradeServiceIntgrationTest extends AbstractContainerBaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenValidCustomerIdAndTrade_create() throws Exception {
        // Given

        Position position = new Position();
        position.setPositionId("1234");
        position.setCustomerId("1L");
        position.setPortfolioId(1L);
        position.setTransactionRef("transactionRef");

        this.positionRepository.save(position);

        Trade trade = new Trade("AAPL", 10L, TradeType.BUY);

        String jsonString = objectMapper.writeValueAsString(trade);

        // When
        ResultActions response = this.mockMvc.perform(post("/trade").content(jsonString)
                .contentType(MediaType.APPLICATION_JSON)
                .header("customer-id", "1L"));

        // Then
        response.andExpect(status().isOk());
    }


}
