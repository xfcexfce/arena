package com.example.arena.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FightController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String returnString() {
        return "cos23";
    }


}
