package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ConsumeRestController {

    private final RestTemplate restTemplate;

    //..............GETting data from REST API.....................

    @GetMapping("/restGet")
    public void getRest() {
        Student result = restTemplate.getForObject("http://localhost:8080/students/{id}", Student.class,1L);
        System.out.println(result);
    }

    @GetMapping("/restGet2")
    public void getRest2() {
        Map<String, Long> urlVariables = new HashMap<>();
        urlVariables.put("id", 2L);
        Student result = restTemplate.getForObject("http://localhost:8080/students/{id}", Student.class, urlVariables);
        System.out.println(result);
    }

    @GetMapping("/restGet3")
    public void getRest3() {
        Map<String, Long> urlVariables = new HashMap<>();
        urlVariables.put("id", 2L);
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/students/{id}")
                .build(urlVariables);
        Student result = restTemplate.getForObject(url, Student.class);
        System.out.println(result);
    }

    @GetMapping("/restGet4")
    public void getRest4() {
        ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:8080/students/{id}", Student.class,1L);
        System.out.println(response);
    }

    //..............POSTing data to REST API.....................

    @GetMapping("/restPost")
    public void postRest() {
        Student student = new Student(4L, "David", "example@example.com", "0000", "123 David St", "Senior", "Science");
        System.out.println(restTemplate.postForObject("http://localhost:8080/students", student, Student.class));
    }

    @GetMapping("/restPost2")
    public void postRest2() {
        Student student = new Student(5L, "Eve", "example@example.com", "0000", "123 Eve St", "Freshman", "Art");
        ResponseEntity<Student> response = restTemplate.postForEntity("http://localhost:8080/students", student, Student.class);
        System.out.println(response);
    }


    //..............DELETEing data from REST API.....................

    @GetMapping("/restDelete")
    public void deleteRest() {
        restTemplate.delete("http://localhost:8080/students/{id}", 4L);
        System.out.println("deleted");
    }

}
