package com.ude.hackathon.hcl;

import com.ude.hackathon.hcl.model.Portfolio;
import com.ude.hackathon.hcl.repo.PortfolioRepository;
import com.ude.hackathon.hcl.service.PortfolioService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PortFolioServiceTest {

    @Autowired
    private PortfolioService portfolioService;

    @Mock
    private PortfolioRepository portfolioRepository;

//    @InjectMocks
//    private PortfolioService portfolioService;

    @Test
    public void getProtfolioById(){
        Portfolio portfolio= portfolioService.getById(1L);
        Assert.assertNotNull(portfolio);
    }

//    @Test
//    public void getProtfolioById(){
//        Portfolio value = new Portfolio();
//        Mockito.when(portfolioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(value));
//        Portfolio portfolio= portfolioService.getById(1L);
//        Assert.assertNotNull(portfolio);
//    }


}
