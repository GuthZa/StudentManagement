package com.guthza.studentmanagement.manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//A Rest controller is ready to handle web requests
//Http get, post, put, delete
@RestController
public class ManagementController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}
