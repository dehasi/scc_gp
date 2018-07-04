package me.dehasi.contracts.demo.contract;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import me.dehasi.contracts.demo.SccDemoApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SccDemoApplication.class)
public abstract class ExternalContractBase {
    @LocalServerPort
    int port;
    @Autowired
    protected WebApplicationContext webApplicationContext;

    @MockBean
    private RestTemplate restTemplate;

    @Before
    public void configureRestAssured() {
        RestAssured.port = port;
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Before
    public void configureMVCServer(){
        when(restTemplate.getForObject(anyString(), any())).thenReturn(new Object());
    }
}
