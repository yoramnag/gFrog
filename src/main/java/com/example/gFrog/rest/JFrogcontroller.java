package com.example.gFrog.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class JFrogcontroller {

    List<String> messages = Arrays.asList("https://api.github.com/search/issues?q=class in:file language:java repo:scala/scala",
            "https://api.github.com/search/issues?q=addClass in:file language:js repo:jquery/jquery",
            "https://api.github.com/search/issues?q=factory in:file language:java repo:openjdk/jdk",
            "https://api.github.com/search/issues?q=cache in:file repo:scala/scala",
            "https://api.github.com/search/issues?q=while in:file repo:openjdk/jdk");

    @GetMapping("/getAlldata")
    public ResponseEntity<String> getAllCoordinates() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity("https://api.github.com/search/issues?q=factory in:file language:java repo:openjdk/jdk", String.class);
//        var response = restTemplate.getForObject("https://api.github.com/search/issues?q=factory in:file language:java repo:openjdk/jdk", String.class);
        HttpHeaders httpHeaders = restTemplate.headForHeaders("https://api.github.com/search/issues?q=factory in:file language:java repo:openjdk/jdk");
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode header = mapper.readTree(String.valueOf(response.getHeaders()));
//        JsonNode name = header.path("Link");
        System.out.println(response);
        return response;
    }
}
