package com.numbers.classification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@JsonPropertyOrder({ "number", "is_prime", "is_perfect", "properties", "digit_sum", "fun_fact" })
public class NumberResponse {
    private int number;

    @JsonProperty("is_prime")
    private boolean isPrime;

    @JsonProperty("is_perfect")
    private boolean isPerfect;

    private List<String> properties;

    @JsonProperty("digit_sum")
    private int digitSum;

    @JsonProperty("fun_fact")
    private String funFact;


}
