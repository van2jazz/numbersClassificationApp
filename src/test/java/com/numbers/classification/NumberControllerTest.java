package com.numbers.classification;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Map;

class NumberControllerTest {

    @Mock
    private NumberService numberService;

    @InjectMocks
    private NumberController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testValidNumberRequest() throws Exception {
        var mockResponse = new NumberResponse(371, false, false, List.of("armstrong", "odd"), 11, "371 is an Armstrong number");

        when(numberService.classify(371)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/classify-number?number=371")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(371))
                .andExpect(jsonPath("$.is_prime").value(false))
                .andExpect(jsonPath("$.is_perfect").value(false))
                .andExpect(jsonPath("$.properties[0]").value("armstrong"))
                .andExpect(jsonPath("$.digit_sum").value(11))
                .andExpect(jsonPath("$.fun_fact").value("371 is an Armstrong number"));
    }

    @Test
    void testInvalidNumberRequest() throws Exception {
        mockMvc.perform(get("/api/classify-number?number=alphabet")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.number").value("alphabet"))
                .andExpect(jsonPath("$.error").value(true));
    }
}
