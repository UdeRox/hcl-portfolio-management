package com.hcl.portfoliomgmt.trade.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.portfoliomgmt.trade.entity.Position;
import com.hcl.portfoliomgmt.trade.repository.PositionRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PositionControllerTest extends AbstractContainerBaseTest{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    //JUnit test for Valid customer id when get positions retrieve positions of current customer
    @DisplayName("Unit test for Valid customer id when get positions retrieve positions of current customer")
    @Test
    public void givenValidCustomerId_whenGetPositions_ThenGetListOfPositionsWithOneEntry() throws Exception {
        // Given
        String customerId = "test@gmail.com";
        /*private Long id;
        private String positionId;
        private String transactionRef;
        private Long portfolioId;
        private Long instrumentId;
        private String customerId;*/
        Position position = new Position();
        position.setPositionId("1234");
        position.setCustomerId(customerId);
        position.setPortfolioId(1L);
        position.setTransactionRef("transactionRef");

        this.positionRepository.save(position);

        // When
        ResultActions response = this.mockMvc.perform(get("/position")
                .contentType(MediaType.APPLICATION_JSON)
                .header("customer-id", customerId));

        // Then
        /*response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountType", is("Savings")));*/
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(1)));
    }
}
