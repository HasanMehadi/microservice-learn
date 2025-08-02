package com.microservices.accounts.gateway;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class LoanGateway {

    private final WebClient webClient;

    public LoanGateway(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String getLoanContactInfo() {

        String responseFromClient;
        try {
            responseFromClient= webClient.get()
                    .uri("lb://loan/loan/contact-info")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::is4xxClientError,
                            response -> Mono.error(new RuntimeException("Client error from loan-service"))
                    )
                    .onStatus(
                            HttpStatusCode::is5xxServerError,
                            response -> Mono.error(new RuntimeException("Server error from loan-service"))
                    )
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(10))
                    .onTerminateDetach()
                    .block();
            System.out.println(responseFromClient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallback: loan-service not available - " + e.getMessage();
        }
        return responseFromClient;
    }
}
