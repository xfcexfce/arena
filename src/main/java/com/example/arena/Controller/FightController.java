package com.example.arena.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class FightController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String returnString() {
        return "cos23";
    }

    @RequestMapping("/hello123")




    //podlaczyc repo z lekcji 10 przez @Autowired






    public String hello() {
        throw new NoSuchElementException("No such element exception message");


       // return "Hello world! ";
    }


}
