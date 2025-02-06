package com.numbers.classification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class NumberServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @InjectMocks
    private NumberService numberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testClassify() {
        int number = 28;
        String funFact = "28 is a perfect number.";
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString(), anyInt())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(funFact));

        NumberResponse response = numberService.classify(number);

        assertNotNull(response);
        assertEquals(number, response.getNumber());
        assertFalse(response.isPrime());
        assertTrue(response.isPerfect());
        assertFalse(response.getProperties().contains("armstrong"));
        assertTrue(response.getProperties().contains("even"));
        assertEquals(10, response.getDigitSum());
        assertEquals(funFact, response.getFunFact());

        verify(webClient, times(1)).get();
        verify(requestHeadersUriSpec, times(1)).uri(anyString(), anyInt());
        verify(requestHeadersUriSpec, times(1)).retrieve();
        verify(responseSpec, times(1)).bodyToMono(String.class);
    }
}