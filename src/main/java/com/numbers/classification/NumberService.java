package com.numbers.classification;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    private final WebClient webClient;

    public NumberService(WebClient webClient) {
        this.webClient = webClient;
    }

    public NumberResponse classify(int number) {
        boolean isPrime = MathUtils.isPrime(number);
        boolean isPerfect = MathUtils.isPerfect(number);
        boolean isArmstrong = MathUtils.isArmstrong(number);
        boolean isOdd = number % 2 != 0;
        int digitSum = MathUtils.digitSum(number);

        List<String> properties = new ArrayList<>();
        if (isArmstrong) properties.add("armstrong");
        properties.add(isOdd ? "odd" : "even");

        String funFact = fetchFunFact(number);

        return new NumberResponse(number, isPrime, isPerfect, properties, digitSum, funFact);
    }

    private String fetchFunFact(int number) {
        return webClient.get()
                .uri("http://numbersapi.com/{number}/math", number)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
