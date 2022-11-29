package org.opportunity.controller;

import org.opportunity.services.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Controller {
    @GetMapping("index")
    public String getIndex() {
        if (!Service.isInactive()) {
            return "Hi!";
        }
        else{
            return Service.content;
        }
    }
}
