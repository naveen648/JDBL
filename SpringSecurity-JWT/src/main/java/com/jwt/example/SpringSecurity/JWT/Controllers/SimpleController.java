package com.jwt.example.SpringSecurity.JWT.Controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SimpleController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin(){
        return ResponseEntity.ok("Yes, i am Admin");
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student")
    public ResponseEntity<String> getStudent(){
        return ResponseEntity.ok("Yes, i am Student");
    }

    @GetMapping("/public")
    public ResponseEntity<String> getVisitor(){
        return ResponseEntity.ok("Yes, i am Visitor");
    }
}
