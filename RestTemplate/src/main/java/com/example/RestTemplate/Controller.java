package com.example.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {
    UserService service=new UserService();
    RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/hi")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer id)
    {
        return service.findAUser(id);
    }

    @GetMapping("/users")
    public List<User> getAUser()
    {
        return service.findAll();
    }

    @PostMapping("/users")
    public User createAUser(@RequestBody User user){
        return service.addAUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable("id") Integer id ){
        service.deleteAUser(id);
        return true;
    }

    @RequestMapping("/gitHub/users/{login}")
    public ResponseEntity<GitHubUser> get(@PathVariable("login") String login){
        ResponseEntity<GitHubUser> response=restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GitHubUser.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        GitHubUser gitHubUser = response.getBody();
        System.out.println(gitHubUser.toString());
        return response;
    }
}