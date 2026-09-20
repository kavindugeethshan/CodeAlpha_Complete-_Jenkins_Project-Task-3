package com.example.javagradledevops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DevOpsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 1: Verify Spring application context starts successfully")
    void contextLoads() {
        // Verifies the Spring application context initializes without errors
    }

    @Test
    @DisplayName("Test 2: Verify GET / returns HTTP 200 and expected JSON")
    void testRootEndpoint() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Java Gradle DevOps Application is running"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    @DisplayName("Test 3: Verify GET /api/hello returns HTTP 200")
    void testHelloEndpointStatus() throws Exception {
        mockMvc.perform(get("/api/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test 4: Verify GET /api/hello returns expected message")
    void testHelloEndpointMessage() throws Exception {
        mockMvc.perform(get("/api/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Hello from Java Gradle Application"));
    }

    @Test
    @DisplayName("Test 5: Verify GET /api/info returns HTTP 200 and application details")
    void testInfoEndpoint() throws Exception {
        mockMvc.perform(get("/api/info")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.application").value("Java Gradle DevOps App"))
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.java").value("21"))
                .andExpect(jsonPath("$.buildTool").value("Gradle"));
    }
}
