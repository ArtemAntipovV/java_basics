package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
     private FibonacciService service;

    @BeforeEach
    public void setUp() {
        service = mock(FibonacciService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new FibonacciController(service)).build();
        MockitoAnnotations.openMocks(this);
    }

    private static Stream<Arguments> fibonacciParameters() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(10, 55)
        );

    }
    @ParameterizedTest
    @MethodSource("fibonacciParameters")
    @DisplayName("Test return ok")
    public void testTrueFibonacciIndex(int index, int value) throws Exception {
        FibonacciNumber number = new FibonacciNumber(index, value);

        when(service.fibonacciNumber(index)).thenReturn(number);
        MockHttpServletRequestBuilder request = get("/fibonacci/" + index)
                .contentType(MediaType.APPLICATION_JSON);

         mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        verify(service, times(1)).fibonacciNumber(index);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("Test return false index")
    public void testFalseFibonacciNumber(int index) throws Exception {
        when(service.fibonacciNumber(-1)).thenThrow(new IllegalArgumentException("Index should be greater or equal to 1"));
        MockHttpServletRequestBuilder request = get("/fibonacci/-1").contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andReturn();
        assertEquals("Index should be greater or equal to 1", result.getResponse().getContentAsString());
    }

}
