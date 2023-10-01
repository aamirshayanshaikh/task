package com.aamir.config;

import com.aamir.auth.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class OktaApiService {

    @Value("${okta.api.url}")
    private String oktaApiUrl;

    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;


    public User getCurrentUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", apiKey);
        String apiUrl = oktaApiUrl + "/api/v1/users/me";
        ResponseEntity<User> response = restTemplate.exchange(apiUrl, HttpMethod.GET,
                new HttpEntity<>(headers), User.class);
        return response.getBody();
    }

}
