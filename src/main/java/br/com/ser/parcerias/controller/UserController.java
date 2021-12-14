package br.com.ser.parcerias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    
    /**
     *  Métodos:
     *     @GET
     *     @POST
     *     @PUT
     *     @DELETE
     *     @PATCH 
     */
    
    
    // http://localhost:8080/users

    @GetMapping("/")
    public String hellowrold() {
        return "Hello World OK";
    }

}
